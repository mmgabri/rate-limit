package br.com.mmgabri.grpc.autorizador;

import static br.com.mmgabri.grpc.autorizador.FormatadorServiceGrpc.getServiceDescriptor;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;


@javax.annotation.Generated(
value = "by ReactorGrpc generator",
comments = "Source: Formatador.proto")
public final class ReactorFormatadorServiceGrpc {
    private ReactorFormatadorServiceGrpc() {}

    public static ReactorFormatadorServiceStub newReactorStub(io.grpc.Channel channel) {
        return new ReactorFormatadorServiceStub(channel);
    }

    public static final class ReactorFormatadorServiceStub extends io.grpc.stub.AbstractStub<ReactorFormatadorServiceStub> {
        private FormatadorServiceGrpc.FormatadorServiceStub delegateStub;

        private ReactorFormatadorServiceStub(io.grpc.Channel channel) {
            super(channel);
            delegateStub = FormatadorServiceGrpc.newStub(channel);
        }

        private ReactorFormatadorServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
            delegateStub = FormatadorServiceGrpc.newStub(channel).build(channel, callOptions);
        }

        @Override
        protected ReactorFormatadorServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ReactorFormatadorServiceStub(channel, callOptions);
        }

        public reactor.core.publisher.Mono<br.com.mmgabri.grpc.autorizador.FormatadorResponse> processaTransacao(reactor.core.publisher.Mono<br.com.mmgabri.grpc.autorizador.FormatadorRequest> reactorRequest) {
            return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactorRequest, delegateStub::processaTransacao, getCallOptions());
        }

        public reactor.core.publisher.Mono<br.com.mmgabri.grpc.autorizador.FormatadorResponse> processaTransacao(br.com.mmgabri.grpc.autorizador.FormatadorRequest reactorRequest) {
           return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactor.core.publisher.Mono.just(reactorRequest), delegateStub::processaTransacao, getCallOptions());
        }

    }

    public static abstract class FormatadorServiceImplBase implements io.grpc.BindableService {

        public reactor.core.publisher.Mono<br.com.mmgabri.grpc.autorizador.FormatadorResponse> processaTransacao(br.com.mmgabri.grpc.autorizador.FormatadorRequest request) {
            return processaTransacao(reactor.core.publisher.Mono.just(request));
        }

        public reactor.core.publisher.Mono<br.com.mmgabri.grpc.autorizador.FormatadorResponse> processaTransacao(reactor.core.publisher.Mono<br.com.mmgabri.grpc.autorizador.FormatadorRequest> request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(
                            br.com.mmgabri.grpc.autorizador.FormatadorServiceGrpc.getProcessaTransacaoMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            br.com.mmgabri.grpc.autorizador.FormatadorRequest,
                                            br.com.mmgabri.grpc.autorizador.FormatadorResponse>(
                                            this, METHODID_PROCESSA_TRANSACAO)))
                    .build();
        }

        protected io.grpc.CallOptions getCallOptions(int methodId) {
            return null;
        }

        protected Throwable onErrorMap(Throwable throwable) {
            return com.salesforce.reactorgrpc.stub.ServerCalls.prepareError(throwable);
        }
    }

    public static final int METHODID_PROCESSA_TRANSACAO = 0;

    private static final class MethodHandlers<Req, Resp> implements
            io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final FormatadorServiceImplBase serviceImpl;
        private final int methodId;

        MethodHandlers(FormatadorServiceImplBase serviceImpl, int methodId) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_PROCESSA_TRANSACAO:
                    com.salesforce.reactorgrpc.stub.ServerCalls.oneToOne((br.com.mmgabri.grpc.autorizador.FormatadorRequest) request,
                            (io.grpc.stub.StreamObserver<br.com.mmgabri.grpc.autorizador.FormatadorResponse>) responseObserver,
                            serviceImpl::processaTransacao, serviceImpl::onErrorMap);
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
