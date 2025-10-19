package br.com.mmgabri.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ProcessTransactionService {
    private static final Logger logger = LoggerFactory.getLogger(ProcessTransactionService.class);

    public void process(String message) {
        try {
            Thread.sleep(50);
            logger.info("Transaction processed with success");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.error("Thread was interrupted during processing", e);
        }
    }
}
