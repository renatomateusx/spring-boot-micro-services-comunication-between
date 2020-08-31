package br.com.therichies.comassinatura.domains.dtos;

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

    private String fullName;

    private String emailAddres;

    private Date dt_birthDate;

    private String password;

    private Long idPlain;
}
