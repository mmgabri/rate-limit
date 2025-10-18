package br.com.mmgabri.services;

import br.com.mmgabri.adapters.grpc.clients.AutorizadorGrpcClient;
import br.com.mmgabri.grpc.autorizador.FormatadorRequest;
import br.com.mmgabri.grpc.autorizador.FormatadorResponse;
import br.com.mmgabri.mappers.AutorizadorMapper;
import br.com.mmgabri.mappers.FormatadorResponseMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class AutorizadorService {

    private static final Logger logger = LoggerFactory.getLogger(AutorizadorService.class);

    private final FormatadorResponseMapper formatadorResponseMapper;
    private final AutorizadorGrpcClient autorizadorGrpcClient;
    private final AutorizadorMapper autorizadorMapper;

    public Mono<FormatadorResponse> execute(FormatadorRequest request) {
        return autorizadorGrpcClient.getStub()
                .autorizarTransacao(autorizadorMapper.map(request))
                .contextWrite(Context.of("transactionId", request.getTransactionId()))
                .timeout(Duration.ofMillis(5000))
                .share()
                .retry(3)
                .doOnSubscribe(subscription -> logger.info("Chamando Autorizador..."))
                .doOnSuccess(__ -> logger.info("Chamada do Autorizador concluida com sucesso."))
                .flatMap(formatadorResponseMapper::toFormatadorResponseSuccess)
                .doOnError(error -> logger.error("Erro inesperado na chamada do Autorizador", error));
    }
}
