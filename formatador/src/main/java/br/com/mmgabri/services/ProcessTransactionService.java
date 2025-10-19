package br.com.mmgabri.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class ProcessTransactionService {
    private static final Logger logger = LoggerFactory.getLogger(ProcessTransactionService.class);
    private final MetricsService metricsService;

    // 5 ms = tps de 168
    private static int SLEEP = 5;

    public ProcessTransactionService(MetricsService metricsService) {
        this.metricsService = metricsService;
    }

    public void process(String message) {
        var startTime = OffsetDateTime.now();

        try {
            Thread.sleep(SLEEP);
            metricsService.incrementMetric(startTime);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.error("Thread was interrupted during processing", e);
        }
    }
}
