package br.com.therichies.cadclient.advice;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class ErroResponse {
    private String message;
    private String title;
}
