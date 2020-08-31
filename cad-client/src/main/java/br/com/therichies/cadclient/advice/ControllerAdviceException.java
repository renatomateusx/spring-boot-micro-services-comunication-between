package br.com.therichies.cadclient.advice;

import br.com.therichies.cadclient.exceptions.ItemNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerAdviceException {

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<?> erroItemNotFound(final ItemNotFoundException e,
                                              final HttpServletRequest httpRequest) {

        HttpStatus status = HttpStatus.NOT_FOUND;

        return ResponseEntity
                .status(status)
                .body(newStandardError(
                        "Item não encontrado!",
                        e));
    }

    private ErroResponse newStandardError(String titleError, RuntimeException e){
        return new ErroResponse(titleError, e.getMessage());
    }

}
