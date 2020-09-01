package br.com.therichies.cadclient.mappers;

import br.com.therichies.cadclient.domains.Client;
import br.com.therichies.cadclient.domains.dtos.ClientDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ClientMapper {

    Client toEntity(ClientDto dto);

    @Mapping(target = "password", ignore = true)
    ClientDto toDto(Client entity);
}
