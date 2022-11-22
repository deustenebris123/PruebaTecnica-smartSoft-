package com.registros.registrofacbackend.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
//excepciones personalizadas
public class exception extends RuntimeException {
    private static final Long serialVersionID = 1L;
    public exception(String mensaje){
        super(mensaje);

    }
}
