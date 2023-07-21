package br.com.sabatini.controller;

import br.com.sabatini.exception.EmptyFieldException;
import br.com.sabatini.exception.IdNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(IdNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleIdNotFoundException(IdNotFoundException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(EmptyFieldException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleEmptyFieldException(EmptyFieldException ex) {
        return ex.getMessage();
    }

}
