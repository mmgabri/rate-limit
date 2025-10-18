package br.com.mmgabri.grpc.autorizador;

import static br.com.mmgabri.grpc.autorizador.AutorizadorServiceGrpc.getServiceDescriptor;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;


@javax.annotation.Generated(
value = "by ReactorGrpc generator",
comments = "Source: Autorizador.proto")
public final class ReactorAutorizadorServiceGrpc {
    private ReactorAutorizadorServiceGrpc() {}

    public static ReactorAutorizadorServiceStub newReactorStub(io.grpc.Channel channel) {
        return new ReactorAutorizadorServiceStub(channel);
    }

    public static final class ReactorAutorizadorServiceStub extends io.grpc.stub.AbstractStub<ReactorAutorizadorServiceStub> {
        private AutorizadorServiceGrpc.AutorizadorServiceStub delegateStub;

        private ReactorAutorizadorServiceStub(io.grpc.Channel channel) {
            super(channel);
            delegateStub = AutorizadorServiceGrpc.newStub(channel);
        }

        private ReactorAutorizadorServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
            delegateStub = AutorizadorServiceGrpc.newStub(channel).build(channel, callOptions);
        }

        @Override
        protected ReactorAutorizadorServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ReactorAutorizadorServiceStub(channel, callOptions);
        }

        public reactor.core.publisher.Mono<br.com.mmgabri.grpc.autorizador.AutorizadorResponse> autorizarTransacao(reactor.core.publisher.Mono<br.com.mmgabri.grpc.autorizador.AutorizadorRequest> reactorRequest) {
            return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactorRequest, delegateStub::autorizarTransacao, getCallOptions());
        }

        public reactor.core.publisher.Mono<br.com.mmgabri.grpc.autorizador.AutorizadorResponse> autorizarTransacao(br.com.mmgabri.grpc.autorizador.AutorizadorRequest reactorRequest) {
           return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactor.core.publisher.Mono.just(reactorRequest), delegateStub::autorizarTransacao, getCallOptions());
        }

    }

    public static abstract class AutorizadorServiceImplBase implements io.grpc.BindableService {

        public reactor.core.publisher.Mono<br.com.mmgabri.grpc.autorizador.AutorizadorResponse> autorizarTransacao(br.com.mmgabri.grpc.autorizador.AutorizadorRequest request) {
            return autorizarTransacao(reactor.core.publisher.Mono.just(request));
        }

        public reactor.core.publisher.Mono<br.com.mmgabri.grpc.autorizador.AutorizadorResponse> autorizarTransacao(reactor.core.publisher.Mono<br.com.mmgabri.grpc.autorizador.AutorizadorRequest> request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(
                            br.com.mmgabri.grpc.autorizador.AutorizadorServiceGrpc.getAutorizarTransacaoMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            br.com.mmgabri.grpc.autorizador.AutorizadorRequest,
                                            br.com.mmgabri.grpc.autorizador.AutorizadorResponse>(
                                            this, METHODID_AUTORIZAR_TRANSACAO)))
                    .build();
        }

        protected io.grpc.CallOptions getCallOptions(int methodId) {
            return null;
        }

        protected Throwable onErrorMap(Throwable throwable) {
            return com.salesforce.reactorgrpc.stub.ServerCalls.prepareError(throwable);
        }
    }

    public static final int METHODID_AUTORIZAR_TRANSACAO = 0;

    private static final class MethodHandlers<Req, Resp> implements
            io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final AutorizadorServiceImplBase serviceImpl;
        private final int methodId;

        MethodHandlers(AutorizadorServiceImplBase serviceImpl, int methodId) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_AUTORIZAR_TRANSACAO:
                    com.salesforce.reactorgrpc.stub.ServerCalls.oneToOne((br.com.mmgabri.grpc.autorizador.AutorizadorRequest) request,
                            (io.grpc.stub.StreamObserver<br.com.mmgabri.grpc.autorizador.AutorizadorResponse>) responseObserver,
                            serviceImpl::autorizarTransacao, serviceImpl::onErrorMap);
                    break;
                default:
                    throw new java.lang.AssertionError();
            }
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public io.grpc.stub.StreamObserver<Req> invoke(io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                default:
                    throw new java.lang.AssertionError();
            }
        }
    }

}
