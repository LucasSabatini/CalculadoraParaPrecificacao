package br.com.sabatini.controller;

import br.com.sabatini.exception.CampoVazioException;
import br.com.sabatini.exception.IdNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(IdNaoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleIdNaoEncontradoException(IdNaoEncontradoException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(CampoVazioException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleCampoVazioException(CampoVazioException ex) {
        return ex.getMessage();
    }

}
