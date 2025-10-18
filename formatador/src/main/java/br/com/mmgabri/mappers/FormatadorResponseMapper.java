package br.com.mmgabri.mappers;

import br.com.mmgabri.grpc.autorizador.AutorizadorResponse;
import br.com.mmgabri.grpc.autorizador.FormatadorRequest;
import br.com.mmgabri.grpc.autorizador.FormatadorResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class FormatadorResponseMapper {

    public Mono<FormatadorResponse> toFormatadorResponseSuccess(AutorizadorResponse response) {
        FormatadorResponse transacaoResponse = FormatadorResponse.newBuilder()
                .setDe02(response.getDe02())
                .setDe03(response.getDe03())
                .setDe04(response.getDe04())
                .setDe07(response.getDe07())
                .setDe12(response.getDe12())
                .setDe18(response.getDe18())
                .setDe22(response.getDe22())
                .setDe39(response.getDe39())
                .setDe43(response.getDe43())
                .setDe49(response.getDe49())
                .setDe63(response.getDe63())
                .build();
        return Mono.just(transacaoResponse);
    }

    public FormatadorResponse toFormatadorResponseError(FormatadorRequest request) {

        return FormatadorResponse.newBuilder()
                .setDe02(request.getDe02())
                .setDe03(request.getDe03())
                .setDe04(request.getDe04())
                .setDe07(request.getDe07())
                .setDe12(request.getDe12())
                .setDe18(request.getDe18())
                .setDe22(request.getDe22())
                .setDe39("96")
                .setDe43(request.getDe43())
                .setDe49(request.getDe49())
                .setDe63(request.getDe63())
                .build();
    }

}
