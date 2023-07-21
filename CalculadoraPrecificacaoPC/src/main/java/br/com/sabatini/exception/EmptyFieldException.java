package br.com.sabatini.exception;

public class EmptyFieldException extends RuntimeException {

    private final String emptyField;

    public EmptyFieldException(String emptyField) {
        this.emptyField = emptyField;
    }

    public String getMessage() {
        return String.format("O campo '%s' está vazio. Atualize as informações desta matéria-prima ou calcule-a novamente.",
                emptyField);
    }
}
