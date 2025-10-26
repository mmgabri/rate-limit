package br.com.mmgabri.adapters.kafka.listener;

import br.com.mmgabri.services.MetricsService;
import br.com.mmgabri.services.ProcessTransactionService;
import com.timgroup.statsd.StatsDClient;
import io.github.resilience4j.ratelimiter.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class TransactionRequestListener {
    private static final Logger logger = LoggerFactory.getLogger(TransactionRequestListener.class);

    private final RateLimiter tpsLimiter;
    private final MetricsService metricsService;

    @Value("${app.rate-limit.toggle:false}")
    private boolean toggleRateLimiter;

    @Value("${app.rate-limit.global.nack-duration:0}")
    private int nackDuration;


    private final ProcessTransactionService process;

    private TransactionRequestListener(@Qualifier("globalTpsLimiter") RateLimiter tpsLimiter, final ProcessTransactionService process, final  MetricsService metricsService) {
        this.tpsLimiter = tpsLimiter;
        this.process = process;
        this.metricsService = metricsService;
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

        if (toggleRateLimiter && !tpsLimiter.acquirePermission()) {
            metricsService.incrementMetricCounter();
            logger.warn("Limite de taxa TPS atingido. Mensagem será reentregue ao tópico: {}", message.offset());
            ack.nack(Duration.ofMillis(nackDuration));
            return;
        }

        try {
   //         logger.info("Mensagem recebida do tópico: {}", message.offset());
            process.process(message.value());
        } catch (Exception e) {
            logger.error("Erro ao processar mensagem: {}", e.getMessage(), e);
        } finally {
            ack.acknowledge();
        }
    }
}