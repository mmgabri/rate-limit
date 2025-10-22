package br.com.mmgabri.configs;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RateLimitConfig {

    @Bean("globalTpsLimiter")
    public RateLimiter globalTpsLimiter(@Value("${app.rate-limit.global.tps:100}") double tps) {
        return RateLimiter.create(tps);
    }

    @Bean("topicRequestTransactionTpsLimiter")
    public RateLimiter topicTransactionLimiter(@Value("${app.rate-limit.topic.request-transactions.tps:50}") double tps) {
        return RateLimiter.create(tps);
    }

    @Bean("topicRequestReversalTpsLimiter")
    public RateLimiter topicRequestReversalTpsLimiter(@Value("${app.rate-limit.topic.request-reversal.tps:10}") double tps) {
        return RateLimiter.create(tps);
    }
}