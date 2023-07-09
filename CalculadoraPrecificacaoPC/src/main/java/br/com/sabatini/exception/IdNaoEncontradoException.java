package br.com.sabatini.exception;

public class IdNaoEncontradoException extends RuntimeException {
    private final Long id;

    public IdNaoEncontradoException(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return String.format("A matéria-prima com ID: '%s' não foi encontrada! Consulte os IDs no menu inicial.", id);
    }
}
