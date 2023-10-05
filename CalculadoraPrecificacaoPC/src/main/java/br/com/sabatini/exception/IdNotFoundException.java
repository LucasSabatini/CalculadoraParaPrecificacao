package br.com.sabatini.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class IdNotFoundException extends EntityNotFoundException {

    public IdNotFoundException(String message) {
        super(message);
    }
}
