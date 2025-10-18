package br.com.mmgabri.adapters.grpc.config;

import br.com.mmgabri.grpc.autorizador.ReactorAutorizadorServiceGrpc;
import io.grpc.ManagedChannel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpcClientConfig {

    @Bean
    public ReactorAutorizadorServiceGrpc.ReactorAutorizadorServiceStub autorizadorServiceStub(
            @Qualifier("managedChannelAutorizador") ManagedChannel channel) {
        return ReactorAutorizadorServiceGrpc.newReactorStub(channel);
    }
}