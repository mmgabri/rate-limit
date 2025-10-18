package br.com.mmgabri.grpc.autorizador;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.52.1)",
    comments = "Source: Formatador.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class FormatadorServiceGrpc {

  private FormatadorServiceGrpc() {}

  public static final String SERVICE_NAME = "br.com.mmgabri.grpc.autorizador.FormatadorService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<br.com.mmgabri.grpc.autorizador.FormatadorRequest,
      br.com.mmgabri.grpc.autorizador.FormatadorResponse> getProcessaTransacaoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ProcessaTransacao",
      requestType = br.com.mmgabri.grpc.autorizador.FormatadorRequest.class,
      responseType = br.com.mmgabri.grpc.autorizador.FormatadorResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<br.com.mmgabri.grpc.autorizador.FormatadorRequest,
      br.com.mmgabri.grpc.autorizador.FormatadorResponse> getProcessaTransacaoMethod() {
    io.grpc.MethodDescriptor<br.com.mmgabri.grpc.autorizador.FormatadorRequest, br.com.mmgabri.grpc.autorizador.FormatadorResponse> getProcessaTransacaoMethod;
    if ((getProcessaTransacaoMethod = FormatadorServiceGrpc.getProcessaTransacaoMethod) == null) {
      synchronized (FormatadorServiceGrpc.class) {
        if ((getProcessaTransacaoMethod = FormatadorServiceGrpc.getProcessaTransacaoMethod) == null) {
          FormatadorServiceGrpc.getProcessaTransacaoMethod = getProcessaTransacaoMethod =
              io.grpc.MethodDescriptor.<br.com.mmgabri.grpc.autorizador.FormatadorRequest, br.com.mmgabri.grpc.autorizador.FormatadorResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ProcessaTransacao"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  br.com.mmgabri.grpc.autorizador.FormatadorRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  br.com.mmgabri.grpc.autorizador.FormatadorResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FormatadorServiceMethodDescriptorSupplier("ProcessaTransacao"))
              .build();
        }
      }
    }
    return getProcessaTransacaoMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FormatadorServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FormatadorServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FormatadorServiceStub>() {
        @java.lang.Override
        public FormatadorServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FormatadorServiceStub(channel, callOptions);
        }
      };
    return FormatadorServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FormatadorServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FormatadorServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FormatadorServiceBlockingStub>() {
        @java.lang.Override
        public FormatadorServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FormatadorServiceBlockingStub(channel, callOptions);
        }
      };
    return FormatadorServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FormatadorServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FormatadorServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FormatadorServiceFutureStub>() {
        @java.lang.Override
        public FormatadorServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FormatadorServiceFutureStub(channel, callOptions);
        }
      };
    return FormatadorServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class FormatadorServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void processaTransacao(br.com.mmgabri.grpc.autorizador.FormatadorRequest request,
        io.grpc.stub.StreamObserver<br.com.mmgabri.grpc.autorizador.FormatadorResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getProcessaTransacaoMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getProcessaTransacaoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                br.com.mmgabri.grpc.autorizador.FormatadorRequest,
                br.com.mmgabri.grpc.autorizador.FormatadorResponse>(
                  this, METHODID_PROCESSA_TRANSACAO)))
          .build();
    }
  }

  /**
   */
  public static final class FormatadorServiceStub extends io.grpc.stub.AbstractAsyncStub<FormatadorServiceStub> {
    private FormatadorServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FormatadorServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FormatadorServiceStub(channel, callOptions);
    }

    /**
     */
    public void processaTransacao(br.com.mmgabri.grpc.autorizador.FormatadorRequest request,
        io.grpc.stub.StreamObserver<br.com.mmgabri.grpc.autorizador.FormatadorResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getProcessaTransacaoMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class FormatadorServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<FormatadorServiceBlockingStub> {
    private FormatadorServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FormatadorServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FormatadorServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public br.com.mmgabri.grpc.autorizador.FormatadorResponse processaTransacao(br.com.mmgabri.grpc.autorizador.FormatadorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getProcessaTransacaoMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class FormatadorServiceFutureStub extends io.grpc.stub.AbstractFutureStub<FormatadorServiceFutureStub> {
    private FormatadorServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FormatadorServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FormatadorServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<br.com.mmgabri.grpc.autorizador.FormatadorResponse> processaTransacao(
        br.com.mmgabri.grpc.autorizador.FormatadorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getProcessaTransacaoMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PROCESSA_TRANSACAO = 0;

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
          serviceImpl.processaTransacao((br.com.mmgabri.grpc.autorizador.FormatadorRequest) request,
              (io.grpc.stub.StreamObserver<br.com.mmgabri.grpc.autorizador.FormatadorResponse>) responseObserver);
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

  private static abstract class FormatadorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FormatadorServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return br.com.mmgabri.grpc.autorizador.Formatador.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FormatadorService");
    }
  }

  private static final class FormatadorServiceFileDescriptorSupplier
      extends FormatadorServiceBaseDescriptorSupplier {
    FormatadorServiceFileDescriptorSupplier() {}
  }

  private static final class FormatadorServiceMethodDescriptorSupplier
      extends FormatadorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    FormatadorServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (FormatadorServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FormatadorServiceFileDescriptorSupplier())
              .addMethod(getProcessaTransacaoMethod())
              .build();
        }
      }
    }
    return result;
  }
}
