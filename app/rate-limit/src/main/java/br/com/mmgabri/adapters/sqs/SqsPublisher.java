package br.com.mmgabri.adapters.sqs;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.GetQueueUrlRequest;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

@Slf4j
@Service
@RequiredArgsConstructor
public class SqsPublisher {
    private static final Logger logger = LoggerFactory.getLogger(SqsPublisher.class);

    private final SqsClient sqsClient;

    @Value("${aws.sqs.queue.financial}")
    private String queueNameFinancial;

    @Value("${aws.sqs.queue.reversal}")
    private String queueNameReversal;

    private String financialUrl;
    private String reversalUrl;

    public SqsPublisher(SqsClient sqsClient) {
        this.sqsClient = sqsClient;
    }

    @PostConstruct
    void init() {
        this.financialUrl = resolveUrl(queueNameFinancial);
        this.reversalUrl = resolveUrl(queueNameReversal);
        logger.info("SQS URLs resolvidas: financial={}, reversal={}", financialUrl, reversalUrl);
    }

    private String resolveUrl(String queueName) {
        return sqsClient.getQueueUrl(
                GetQueueUrlRequest.builder().queueName(queueName).build()
        ).queueUrl();
    }

    public void publishToFinancial(String message) {
        publish(financialUrl, message);
    }

    public void publishToReversal(String message) {
        publish(reversalUrl, message);
    }

    private void publish(String queueUrl, String message) {
        try {
            sqsClient.sendMessage(SendMessageRequest.builder()
                    .queueUrl(queueUrl)
                    .messageBody(message)
                    .build()
            );
            logger.info("Success Publish");
        } catch (Exception e) {
            logger.error("Error publishing message to SQS: {}", e.getMessage(), e);
        }
    }
}