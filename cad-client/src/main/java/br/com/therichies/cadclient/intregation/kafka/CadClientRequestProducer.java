package br.com.therichies.cadclient;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;

import java.util.Map;

@RequiredArgsConstructor
@EnableBinding({Source.class})
public class CadClientRequestProducer {

    private final Source source;

    public void cadClient(ClientDto requestCadClient){
        source.output().send(MessageBuilder.withPayload(requestCadClient).build());
    }
}
