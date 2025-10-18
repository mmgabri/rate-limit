package br.com.mmgabri.adapters.grpc.server;

import br.com.mmgabri.grpc.autorizador.FormatadorRequest;
import br.com.mmgabri.grpc.autorizador.FormatadorResponse;
import br.com.mmgabri.grpc.autorizador.ReactorFormatadorServiceGrpc;
import br.com.mmgabri.services.AutorizadorService;
import io.grpc.Status;
import lombok.AllArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.time.OffsetDateTime;

@AllArgsConstructor
@GrpcService
public class ControllerRouter extends ReactorFormatadorServiceGrpc.FormatadorServiceImplBase {
    private static final Logger logger = LoggerFactory.getLogger(ControllerRouter.class);

    private final AutorizadorService service;

    @Override
    public Mono<FormatadorResponse> processaTransacao(FormatadorRequest request) {
        var startTime = OffsetDateTime.now();

        return Mono.just(request)
                .doFirst(() -> logger.info("Mensagem recebida do Router"))
                .flatMap(service::execute)
                .doOnSuccess(response -> onSuccess(request, response, startTime))
                .onErrorResume(this::errorHandler);
    }


    private Mono<FormatadorResponse> errorHandler(Throwable error) {
        logger.error("Request com falha. Respondendo para o router com exceção {}", error.getMessage());
        return Mono.error(Status.INTERNAL.withDescription("Erro no processamento").asRuntimeException());
    }

    private void onSuccess(FormatadorRequest request, FormatadorResponse response, OffsetDateTime startTime) {
        logger.info("Request concluído. Respondendo para o router - DE39: {}", response.getDe39());
    }
}