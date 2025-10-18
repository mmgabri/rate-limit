package br.com.mmgabri.adapters.grpc.config;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class GrpcConfig {

    @Value("${grpc.autorizador-client.host}")
    private String autorizadorHost;

    @Value("${grpc.autorizador-client.port}")
    private int autorizadorPort;

    @Bean
    public ManagedChannel managedChannelAutorizador() {
        return ManagedChannelBuilder.forAddress(autorizadorHost, autorizadorPort)
                .usePlaintext()
                .keepAliveTime(3600, TimeUnit.MINUTES) // Tempo de keep-alive no cliente
                .keepAliveTimeout(3600, TimeUnit.SECONDS) // Timeout de keep-alive
                .build();
    }
}