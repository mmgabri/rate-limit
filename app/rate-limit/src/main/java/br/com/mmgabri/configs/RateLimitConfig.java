package br.com.mmgabri.configs;

import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class RateLimitConfig {

    @Value("${app.rate-limit.enabled:true}")
    private boolean enabled;

    @Value("${app.rate-limit.global.limit-for-period:10}")
    private int limitForPeriod;

    @Value("${app.rate-limit.global.limit-refresh-period:1000}")
    private long limitRefreshPeriodMs;

    @Value("${app.rate-limit.global.timeout-duration:0}")
    private long timeoutDurationMs;

    @Bean("globalTpsLimiter")
    public RateLimiter GlobalTpsLimiter() {
        RateLimiterConfig cfg = RateLimiterConfig.custom()
                .limitForPeriod(limitForPeriod)
                .limitRefreshPeriod(Duration.ofMillis(limitRefreshPeriodMs))
                .timeoutDuration(Duration.ofMillis(Math.max(0, timeoutDurationMs)))
                .build();
        return RateLimiter.of("global-tps-limiter", cfg);
    }
}