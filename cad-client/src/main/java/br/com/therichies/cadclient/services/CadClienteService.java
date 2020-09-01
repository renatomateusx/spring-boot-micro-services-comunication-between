package br.com.therichies.cadclient.services;

import br.com.therichies.cadclient.intregation.kafka.CadClientRequestProducer;
import br.com.therichies.cadclient.domains.dtos.ClientDto;
import br.com.therichies.cadclient.mappers.ClientMapper;
import br.com.therichies.cadclient.repositorys.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadClienteService {

    private final ClientRepository repository;
    private final CadClientRequestProducer producer;
    private final ClientMapper mapper;

    public ClientDto insert(ClientDto itemDto){
        final var client = repository.save(mapper.toEntity(itemDto));
        producer.cadClient(itemDto);
        return mapper.toDto(client);
    }
}
