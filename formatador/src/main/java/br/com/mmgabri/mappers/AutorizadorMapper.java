package br.com.mmgabri.mappers;

import br.com.mmgabri.grpc.autorizador.AutorizadorRequest;
import br.com.mmgabri.grpc.autorizador.FormatadorRequest;
import br.com.mmgabri.grpc.comuns.Header;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class AutorizadorMapper {

    public AutorizadorRequest map(FormatadorRequest request) {
        Header header = Header.newBuilder()
                .setTransactionId(request.getIsReversal() ? request.getTransactionId() : UUID.randomUUID().toString())
                .setCorrelationId(UUID.randomUUID().toString())
                .setClearingId(UUID.randomUUID().toString())
                .setBandeira("Mastercard")
                .setPlataforma("SINGLE_MESSAGE")
                .setTimestamp(LocalDateTime.now().toString())
                .setIsReversal(request.getIsReversal())
                .setMessage("")
                .build();

        return AutorizadorRequest.newBuilder()
                .setHeader(header)
                .setDe02(request.getDe02())
                .setDe03(request.getDe03())
                .setDe04(request.getDe04())
                .setDe07(request.getDe07())
                .setDe12(request.getDe12())
                .setDe18(request.getDe18())
                .setDe22(request.getDe22())
                .setDe43(request.getDe43())
                .setDe49(request.getDe49())
                .setDe52(request.getDe52())
                .setDe55(request.getDe55())
                .setDe63(request.getDe63())
                .setCustomReturnSeguranca(request.getCustomReturnSeguranca())
                .setCustomReturnLimitePortador(request.getCustomReturnLimitePortador())
                .setCustomReturnLimite(request.getCustomReturnLimite())
                .setCustomReturnLancamentoConta(request.getCustomReturnLancamentoConta())
                .setCustomReturnFraude(request.getCustomReturnFraude())
                .build();
    }
}


