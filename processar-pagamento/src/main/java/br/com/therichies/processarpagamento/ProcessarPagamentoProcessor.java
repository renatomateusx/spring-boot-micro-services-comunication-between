package br.com.therichies.processarpagamento;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;

import java.util.Map;

@EnableBinding({Processor.class})
public class ProcessarPagamentoProcessor {

    private final Logger LOGGER = LoggerFactory.getLogger(ProcessarPagamentoProcessor.class);

    @SendTo(Processor.OUTPUT)
    @StreamListener(target = Processor.INPUT)
    public Message<Map<String, Object>> processaPagamento(Message<Map<String, Object>> paymentPreApproval){
        Map<String, Object> request = paymentPreApproval.getPayload();
        String priority = "normal";
        if(System.currentTimeMillis() % 2  == 0){
            request.put("status", "approved");
        }
        else{
            request.put("status", "denied");
            priority = "urgent";
        }
        LOGGER.info(request.toString());

        return MessageBuilder.withPayload(request).setHeader("notificationPriority",priority).build();
    }

}
