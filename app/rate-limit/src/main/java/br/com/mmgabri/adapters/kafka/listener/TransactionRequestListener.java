package br.com.mmgabri.adapters.kafka.listener;

import br.com.mmgabri.services.ProcessTransactionService;
import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
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

    private final ProcessTransactionService process;

    public TransactionRequestListener(final ProcessTransactionService process) {
        this.process = process;
    }

    @KafkaListener(
            topics = "${kafka.topic.request-transactions}",
            groupId = "${spring.kafka.consumer.group-id}",
            containerFactory = "kafkaListenerContainerFactory"
    )
   // @RateLimiter(name = "topic-request-transactions" , fallbackMethod = "onRateLimited")
    public void onEvent(final ConsumerRecord<String, String> message, final Acknowledgment ack) {
        receivedMessage(message, ack);
    }

    protected void receivedMessage(final ConsumerRecord<String, String> message, final Acknowledgment ack) {
        try {
            logger.info("Mensagem recebida do tópico: {}", message.value());
            process.process(message.value());
        } catch (Exception e) {
            logger.error("Erro ao processar mensagem: {}", e.getMessage(), e);
        } finally {
            ack.acknowledge();
        }
    }

    // Fallback: mesma assinatura + exceção como último parâmetro
    public void onRateLimited(ConsumerRecord<String, String> message,
                              Acknowledgment ack,
                              RequestNotPermitted ex) {
        logger.warn("Rate limit excedido; NÃO vou commitar. Mensagem será reentregue. key={} offset={}",
                message.key(), message.offset());
        // NÃO chamar ack.acknowledge() aqui -> sem commit.
        // (Opcional) Pausar um tiquinho para não entrar em loop agressivo:
        // try { Thread.sleep(5); } catch (InterruptedException ignored) {}
    }
}