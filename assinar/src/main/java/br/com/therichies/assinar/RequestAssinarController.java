package br.com.therichies.assinar;

import br.com.therichies.assinar.dtos.SolicitacaoAssinaturaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/api/assinar")
public class RequestAssinarController {

    @Autowired
    private AssinarService assinarService;

    @PostMapping
    public String requestAssinar(@Valid @RequestBody SolicitacaoAssinaturaDto assinatura){
        assinarService.assinar(assinatura);
        return "Your Assign Request Was Sent Successfully";
    }
}
