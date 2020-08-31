package br.com.therichies.comassinatura.integracao.kafka;

import br.com.therichies.comassinatura.domains.dtos.ClientDto;
import br.com.therichies.comassinatura.service.*;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding({Sink.class})
@RequiredArgsConstructor
public class ComunicaAssinaturaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(ComunicaAssinaturaConsumer.class);
    private final ComunicacaoAssinatura service;
    

    @StreamListener(target = Sink.INPUT)
    public void sentEmail(ClientDto clientDto){
        service.sendPlainToClient(clientDto);
        LOGGER.info("PARA VOCÊ QUE ACABOU DE SE REGISTRAR, SEGUE ALGUMAS ASSINATURAS PROMOCIONAIS = " + clientDto);
    }
}
