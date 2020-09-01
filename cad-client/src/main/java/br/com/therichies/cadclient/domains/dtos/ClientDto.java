package br.com.therichies.cadclient.domains.dtos;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {

    private Long id;

    @NotEmpty(message = "Campo nome não pode ser vazio")
    @NotNull(message = "Campo nome não pode ser vazio")
    private String fullName;

    @NotEmpty(message = "Campo senha não pode ser vazio")
    @NotNull(message = "Campo senha não pode ser vazio")
    private String password;

    @Email(message = "Campo e-mail não é válido")
    @NotEmpty(message = "Campo e-mail não pode ser vazio")
    @NotNull(message = "Campo nome não pode ser vazio")
    private String emailAddres;

//    @NotEmpty(message = "Campo data de nascimento não pode ser vazio")
//    @NotNull(message = "Campo data de nascimento não pode ser vazio")
//    private Date dt_birthDate;

    private Long idPlain;
}
