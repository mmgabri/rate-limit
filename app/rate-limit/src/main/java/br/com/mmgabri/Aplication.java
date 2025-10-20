package br.com.mmgabri;

import br.com.mmgabri.services.ProcessTransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Aplication {
    private static final Logger logger = LoggerFactory.getLogger(Aplication.class);
    public static void main(String[] args) {
        logger.info("Subindo aplicação versão 1.0");
        SpringApplication.run(Aplication.class, args);
    }
}
