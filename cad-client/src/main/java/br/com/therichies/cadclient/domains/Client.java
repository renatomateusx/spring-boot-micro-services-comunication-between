package br.com.therichies.cadclient.domains;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.Instant;
import java.util.Date;

@Data
@Entity
@Table
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private String fullName;

    @NotNull
    private String password;

    @NotNull
    private String emailAddres;
//    @NotNull
//    private Date dt_birthDate;
    @Null
    private Long idPlain;

}
