package br.com.therichies.cadclient.controllers;

import br.com.therichies.cadclient.services.CadClienteService;
import br.com.therichies.cadclient.domains.dtos.ClientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/clients")
public class CadClientController {

    @Autowired
    private CadClienteService service;

    @PostMapping()
    public ResponseEntity<?> cadClientRequest(@Valid @RequestBody final ClientDto requestCadClient){
        URI location = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/clientes/{id}")
                .build(service.insert(requestCadClient).getId());

        return ResponseEntity.created(location).build();

    }

}
