package br.com.therichies.assinar;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RequestAssinarController {
    private final AssinarProducer assinarProd;
    public RequestAssinarController(AssinarProducer assinarProd){
        this.assinarProd = assinarProd;
    }

    @PostMapping("/api/request-assinar")
    public String requestAssinar(@RequestBody final Map<String, Object> objectAssinar){
        objectAssinar.put("status", "requested");
        assinarProd.requestAssinar(objectAssinar);
        return "Your Assign Request Was Sent Successfully";
    }
}
