package com.ulco.curae.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class AlreadyExistsException extends RuntimeException {
    public AlreadyExistsException() {
        super("La ressource existe déjà");
    }

    public AlreadyExistsException(String msg) {
        super(msg);
    }
}







