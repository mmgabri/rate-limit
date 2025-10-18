package br.com.mmgabri.adapters.grpc.clients;

import br.com.mmgabri.grpc.autorizador.ReactorAutorizadorServiceGrpc;
import org.springframework.stereotype.Component;

@Component
public class AutorizadorGrpcClient {

    private final ReactorAutorizadorServiceGrpc.ReactorAutorizadorServiceStub stub;

    public AutorizadorGrpcClient(ReactorAutorizadorServiceGrpc.ReactorAutorizadorServiceStub stub) {
        this.stub = stub;
    }

    public ReactorAutorizadorServiceGrpc.ReactorAutorizadorServiceStub getStub() {
        return stub;
    }
}