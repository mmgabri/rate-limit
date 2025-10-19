package br.com.mmgabri.configs;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RateLimitConfig {

    @Bean
    public RateLimiter tpsLimiter(@Value("${app.rate-limit.tps:10}") double tps) {
        // Suaviza rajadas. Se quiser warmup: RateLimiter.create(tps, 5, TimeUnit.SECONDS);
        return RateLimiter.create(tps);
    }
}
