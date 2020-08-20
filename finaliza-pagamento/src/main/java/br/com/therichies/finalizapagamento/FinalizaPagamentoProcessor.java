package br.com.therichies.finalizapagamento;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;

import java.util.Map;

@EnableBinding({Processor.class})
public class FinalizaPagamentoProcessor {
    private static final Logger LOGGER = LoggerFactory.getLogger(FinalizaPagamentoProcessor.class);

    @StreamListener(target = Processor.INPUT, condition = "headers['notificationPriority']=='normal'")
    public void sentEmail(Message<Map<String, Object>> paymentNotification){
        String status = String.valueOf(paymentNotification.getPayload().getOrDefault("status", "approved"));
        LOGGER.info("SEU PAGAMENTO FOI APROVADO. APROVEITE SEU PLANO DA MELHOR MANEIRA. = " + status);
    }

    @StreamListener(target =Processor.INPUT, condition = "headers['notificationPriority']=='urgent'")
    public void sentUrgentEmail(Message<Map<String, Object>> paymentNotification){
        String status = String.valueOf(paymentNotification.getPayload().getOrDefault("status", "denied"));
        LOGGER.info("SEU PAGAMENTO NÁO FOI APROVADO. SINTO MUITO = " + status);
    }

}
