package br.com.therichies.cadclient;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CadClientController {
    private final CadClientRequestProducer cadClientRequestProducer;

    public CadClientController(CadClientRequestProducer cadClientRequestProducer){
        this.cadClientRequestProducer = cadClientRequestProducer;
    }

    @PostMapping("/api/request-cad-client")
    public String cadClientRequest(@RequestBody final Map<String, Object> requestCadClient){
        requestCadClient.put("status", "pending");
        cadClientRequestProducer.cadClient(requestCadClient);
        return "Your Request Was Sent do Our DataBase";
    }

}
