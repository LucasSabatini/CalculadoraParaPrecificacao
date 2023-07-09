package br.com.sabatini.exceptions;

public class CampoVazioException extends RuntimeException {

    private final String campoVazio;

    public CampoVazioException(String campoVazio) {
        this.campoVazio = campoVazio;
    }

    public String getMessage() {
        return String.format("O campo '%s' está vazio. Atualize as informações desta matéria-prima ou calcule-a novamente.",
                campoVazio);
    }
}
