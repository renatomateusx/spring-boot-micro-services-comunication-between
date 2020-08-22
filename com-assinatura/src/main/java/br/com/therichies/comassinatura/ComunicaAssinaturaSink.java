package br.com.therichies.comassinatura;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

import java.util.Map;

@EnableBinding({Sink.class})
public class ComunicaAssinaturaSink {
    private static final Logger LOGGER = LoggerFactory.getLogger(ComunicaAssinaturaSink.class);

    @StreamListener(target = Sink.INPUT)
    public void sentEmail(Message<Map<String, Object>> paymentNotification){
        LOGGER.info("PARA VOCÊ QUE ACABOU DE SE REGISTRAR, SEGUE ALGUMAS ASSINATURAS PROMOCIONAIS = " + paymentNotification);
    }
}
