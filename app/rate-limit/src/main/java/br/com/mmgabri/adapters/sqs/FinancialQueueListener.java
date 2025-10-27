package br.com.mmgabri.adapters.sqs;

import br.com.mmgabri.services.ProcessTransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;

@Component
public class FinancialQueueListener {
    private static final Logger logger = LoggerFactory.getLogger(FinancialQueueListener.class);

    private final ProcessTransactionService process;
    private final SqsClient sqs;
    private final AtomicBoolean running = new AtomicBoolean(false);
    private Thread worker;
    private String queueUrl;
    private ReceiveMessageRequest receiveReq;

    @Value("${app.queue.dlq.financial.name}")
    private String queueNameReversal;

    private static final int WAIT_SECONDS = 10;
    private static final int MAX_MESSAGES = 10;
    private static final int VISIBILITY_TIMEOUT = 0;
    private static final int BACKOFF_MIN_MS = 100;
    private static final int BACKOFF_MAX_MS = 1000;

    public FinancialQueueListener(SqsClient sqs, ProcessTransactionService process) {
        this.sqs = sqs;
        this.process = process;
    }

    @PostConstruct
    void start() {
        if (!running.compareAndSet(false, true)) return;

        this.queueUrl = sqs.getQueueUrl(GetQueueUrlRequest.builder()
                .queueName(queueNameReversal)
                .build()).queueUrl();

        ReceiveMessageRequest.Builder rb = ReceiveMessageRequest.builder()
                .queueUrl(queueUrl)
                .waitTimeSeconds(WAIT_SECONDS)
                .maxNumberOfMessages(MAX_MESSAGES)
                // System attributes (ex.: tentativas de recebimento)
                .attributeNamesWithStrings("ApproximateReceiveCount")
                // Traz todas as message attributes de usuário, se houver
                .messageAttributeNames("All");

        if (VISIBILITY_TIMEOUT > 0) {
            rb = rb.visibilityTimeout(VISIBILITY_TIMEOUT);
        }

        this.receiveReq = rb.build();

        worker = new Thread(this::loop, "sqs-financial-poller");
        worker.setDaemon(true);
        worker.start();

        logger.info("SQS Financial poller iniciado. queue='{}' url='{}' waitSeconds={} maxMessages={} visibilityTimeout={}",
                queueNameReversal, queueUrl, WAIT_SECONDS, MAX_MESSAGES, VISIBILITY_TIMEOUT);
    }

    @PreDestroy
    void stop() {
        if (!running.compareAndSet(true, false)) return;

        logger.info("Encerrando SQS Financial poller...");
        if (worker != null) {
            worker.interrupt();              // acorda long-poll/sleep
            try {
                worker.join(2000);          // aguarda até 2s para finalizar
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        logger.info("SQS Financial poller encerrado.");
    }

    private void loop() {
        while (running.get()) {
            try {
                ReceiveMessageResponse resp = sqs.receiveMessage(receiveReq);

                List<Message> messages = resp.messages();
                if (messages == null || messages.isEmpty()) {
                    backoff();               // evita "martelar" a API
                    continue;
                }

                // Processa e acumula deletes para batch
                List<DeleteMessageBatchRequestEntry> deletes = new ArrayList<>(messages.size());

                for (Message msg : messages) {
                    try {
                        logger.info("Mensagem recebida na fila sqs financial {}", msg.body());
                        process.process(String.valueOf(msg.body()),0);

                        deletes.add(DeleteMessageBatchRequestEntry.builder()
                                .id(msg.messageId()) // precisa ser único por batch; o próprio messageId resolve
                                .receiptHandle(msg.receiptHandle())
                                .build());

                    } catch (Exception e) {
                        // Não deleta -> reentrega após visibility timeout
                        logger.error("Erro processando FINANCIAL (messageId={}): {}", msg.messageId(), e.getMessage(), e);
                    }
                }

                // Deleta em lote o que foi processado com sucesso
                if (!deletes.isEmpty()) {
                    DeleteMessageBatchResponse delResp = sqs.deleteMessageBatch(DeleteMessageBatchRequest.builder()
                            .queueUrl(queueUrl)
                            .entries(deletes)
                            .build());

                    if (!delResp.failed().isEmpty()) {
                        delResp.failed().forEach(f ->
                                logger.warn("Falha ao deletar messageId={} code={} msg={}",
                                        f.id(), f.code(), f.message()));
                    }
                }

            } catch (QueueDoesNotExistException e) {
                logger.error("Fila não existe: {}. Encerrando poller.", queueNameReversal, e);
                break; // nada a fazer
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
                logger.info("Poller interrompido.");
                break;
            } catch (Exception e) {
                logger.error("Erro no poll FINANCIAL: {}", e.getMessage(), e);
                quietSleep(300); // pequeno respiro em erro inesperado
            }
        }
    }

    private void backoff() throws InterruptedException {
        long min = Math.max(0, BACKOFF_MIN_MS);
        long max = Math.max(min, BACKOFF_MAX_MS);
        long sleep = ThreadLocalRandom.current().nextLong(min, max + 1);
        Thread.sleep(sleep);
    }

    private void quietSleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
