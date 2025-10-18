package br.com.mmgabri.grpc.autorizador;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.52.1)",
    comments = "Source: Autorizador.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AutorizadorServiceGrpc {

  private AutorizadorServiceGrpc() {}

  public static final String SERVICE_NAME = "br.com.mmgabri.grpc.autorizador.AutorizadorService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<br.com.mmgabri.grpc.autorizador.AutorizadorRequest,
      br.com.mmgabri.grpc.autorizador.AutorizadorResponse> getAutorizarTransacaoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AutorizarTransacao",
      requestType = br.com.mmgabri.grpc.autorizador.AutorizadorRequest.class,
      responseType = br.com.mmgabri.grpc.autorizador.AutorizadorResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<br.com.mmgabri.grpc.autorizador.AutorizadorRequest,
      br.com.mmgabri.grpc.autorizador.AutorizadorResponse> getAutorizarTransacaoMethod() {
    io.grpc.MethodDescriptor<br.com.mmgabri.grpc.autorizador.AutorizadorRequest, br.com.mmgabri.grpc.autorizador.AutorizadorResponse> getAutorizarTransacaoMethod;
    if ((getAutorizarTransacaoMethod = AutorizadorServiceGrpc.getAutorizarTransacaoMethod) == null) {
      synchronized (AutorizadorServiceGrpc.class) {
        if ((getAutorizarTransacaoMethod = AutorizadorServiceGrpc.getAutorizarTransacaoMethod) == null) {
          AutorizadorServiceGrpc.getAutorizarTransacaoMethod = getAutorizarTransacaoMethod =
              io.grpc.MethodDescriptor.<br.com.mmgabri.grpc.autorizador.AutorizadorRequest, br.com.mmgabri.grpc.autorizador.AutorizadorResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AutorizarTransacao"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  br.com.mmgabri.grpc.autorizador.AutorizadorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  br.com.mmgabri.grpc.autorizador.AutorizadorResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AutorizadorServiceMethodDescriptorSupplier("AutorizarTransacao"))
              .build();
        }
      }
    }
    return getAutorizarTransacaoMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AutorizadorServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AutorizadorServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AutorizadorServiceStub>() {
        @java.lang.Override
        public AutorizadorServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AutorizadorServiceStub(channel, callOptions);
        }
      };
    return AutorizadorServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AutorizadorServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AutorizadorServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AutorizadorServiceBlockingStub>() {
        @java.lang.Override
        public AutorizadorServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AutorizadorServiceBlockingStub(channel, callOptions);
        }
      };
    return AutorizadorServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AutorizadorServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AutorizadorServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AutorizadorServiceFutureStub>() {
        @java.lang.Override
        public AutorizadorServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AutorizadorServiceFutureStub(channel, callOptions);
        }
      };
    return AutorizadorServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class AutorizadorServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void autorizarTransacao(br.com.mmgabri.grpc.autorizador.AutorizadorRequest request,
        io.grpc.stub.StreamObserver<br.com.mmgabri.grpc.autorizador.AutorizadorResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAutorizarTransacaoMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAutorizarTransacaoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                br.com.mmgabri.grpc.autorizador.AutorizadorRequest,
                br.com.mmgabri.grpc.autorizador.AutorizadorResponse>(
                  this, METHODID_AUTORIZAR_TRANSACAO)))
          .build();
    }
  }

  /**
   */
  public static final class AutorizadorServiceStub extends io.grpc.stub.AbstractAsyncStub<AutorizadorServiceStub> {
    private AutorizadorServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AutorizadorServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AutorizadorServiceStub(channel, callOptions);
    }

    /**
     */
    public void autorizarTransacao(br.com.mmgabri.grpc.autorizador.AutorizadorRequest request,
        io.grpc.stub.StreamObserver<br.com.mmgabri.grpc.autorizador.AutorizadorResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAutorizarTransacaoMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class AutorizadorServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<AutorizadorServiceBlockingStub> {
    private AutorizadorServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AutorizadorServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AutorizadorServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public br.com.mmgabri.grpc.autorizador.AutorizadorResponse autorizarTransacao(br.com.mmgabri.grpc.autorizador.AutorizadorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAutorizarTransacaoMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AutorizadorServiceFutureStub extends io.grpc.stub.AbstractFutureStub<AutorizadorServiceFutureStub> {
    private AutorizadorServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AutorizadorServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AutorizadorServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<br.com.mmgabri.grpc.autorizador.AutorizadorResponse> autorizarTransacao(
        br.com.mmgabri.grpc.autorizador.AutorizadorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAutorizarTransacaoMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_AUTORIZAR_TRANSACAO = 0;

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
          serviceImpl.autorizarTransacao((br.com.mmgabri.grpc.autorizador.AutorizadorRequest) request,
              (io.grpc.stub.StreamObserver<br.com.mmgabri.grpc.autorizador.AutorizadorResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class AutorizadorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AutorizadorServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return br.com.mmgabri.grpc.autorizador.Autorizador.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AutorizadorService");
    }
  }

  private static final class AutorizadorServiceFileDescriptorSupplier
      extends AutorizadorServiceBaseDescriptorSupplier {
    AutorizadorServiceFileDescriptorSupplier() {}
  }

  private static final class AutorizadorServiceMethodDescriptorSupplier
      extends AutorizadorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AutorizadorServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (AutorizadorServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AutorizadorServiceFileDescriptorSupplier())
              .addMethod(getAutorizarTransacaoMethod())
              .build();
        }
      }
    }
    return result;
  }
}
