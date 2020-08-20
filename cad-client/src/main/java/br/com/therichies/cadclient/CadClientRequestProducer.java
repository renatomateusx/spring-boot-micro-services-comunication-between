package br.com.therichies.cadclient;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;

import java.util.Map;


@EnableBinding({Source.class})
public class CadClientRequestProducer {
    private final Source source;

    public CadClientRequestProducer(Source source){
        this.source = source;
    }

    public void cadClient(Map<String, Object> requestCadClient){
        source.output().send(MessageBuilder.withPayload(requestCadClient).build());
    }
}
