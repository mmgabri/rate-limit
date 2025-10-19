package br.com.mmgabri.adapters.kafka.listener;

import br.com.mmgabri.services.ProcessTransactionService;
import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TransactionRequestListener {
    private static final Logger logger = LoggerFactory.getLogger(TransactionRequestListener.class);
    private final RateLimiter tpsLimiter; // injetado do bean

    private final ProcessTransactionService process;

    private TransactionRequestListener(RateLimiter tpsLimiter, final ProcessTransactionService process) {
        this.tpsLimiter = tpsLimiter;
        this.process = process;
    }

    @KafkaListener(
            topics = "${kafka.topic.request-transactions}",
            groupId = "${spring.kafka.consumer.group-id}",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void onEvent(final ConsumerRecord<String, String> message, final Acknowledgment ack) {
        receivedMessage(message, ack);
    }

    protected void receivedMessage(final ConsumerRecord<String, String> message, final Acknowledgment ack) {
        try {
            // Bloqueia até conseguir 1 permissão (1 transação)
            tpsLimiter.acquire(); // 1 permit = 1 msg

            logger.info("Mensagem recebida do tópico: {}", message.value());
            process.process(message.value());
        } catch (Exception e) {
            logger.error("Erro ao processar mensagem: {}", e.getMessage(), e);
        } finally {
            ack.acknowledge();
        }
    }
}