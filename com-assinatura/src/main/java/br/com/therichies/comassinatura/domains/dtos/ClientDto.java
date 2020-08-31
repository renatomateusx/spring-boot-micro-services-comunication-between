package br.com.therichies.cadclient.domains.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {

    private Long id;

    @NotEmpty(message = "Campo nome não pode ser vazio")
    @NotNull(message = "Campo nome não pode ser vazio")
    private String fullName;

    @Email(message = "Campo e-mail não é válido")
    @NotEmpty(message = "Campo e-mail não pode ser vazio")
    @NotNull(message = "Campo nome não pode ser vazio")
    private String emailAddres;

    @NotEmpty(message = "Campo data de nascimento não pode ser vazio")
    @NotNull(message = "Campo data de nascimento não pode ser vazio")
    private Instant dt_birthDate;

    private Long idPlain;
}
