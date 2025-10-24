package br.com.mmgabri.services;

import com.timgroup.statsd.StatsDClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.OffsetDateTime;

@Service
public class MetricsService {
    private static final Logger logger = LoggerFactory.getLogger(MetricsService.class);

    private final StatsDClient statsDClient;

    public MetricsService(StatsDClient statsDClient) {
        this.statsDClient = statsDClient;
    }

    public void incrementMetric(OffsetDateTime startTime) {
        try {
            //Calcula duration
            var duration = 0L;
            duration = Duration.between(startTime, OffsetDateTime.now()).toMillis();
        //    logger.info("Request processado em {} ms", duration);

            statsDClient.recordExecutionTime("app_transaction_duration", duration, "app:rate-limit");
        } catch (Exception e) {
            logger.error("Error ao enviar métrica", e);
            throw new RuntimeException(e);
        }
    }
}
