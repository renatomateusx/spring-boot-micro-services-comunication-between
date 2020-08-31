package br.com.therichies.assinar;

import br.com.therichies.assinar.dtos.SolicitacaoAssinaturaDto;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;

import java.util.Map;

@EnableBinding({Source.class})
public class AssinarProducer {
    private final Source source;

    public AssinarProducer(Source source){
        this.source = source;
    }

    public void requestAssinar(SolicitacaoAssinaturaDto requestAssinar){
        source.output().send(MessageBuilder.withPayload(requestAssinar).build());
    }
}
