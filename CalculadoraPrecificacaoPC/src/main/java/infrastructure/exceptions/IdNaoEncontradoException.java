package infrastructure.exceptions;

public class IdNaoEncontradoException extends RuntimeException {
    private final int id;

    public IdNaoEncontradoException(int id) {
        this.id = id;
    }

    public String getMessage() {
        return String.format("A matéria-prima com ID: '%s' não foi encontrada! Consulte os IDs no menu inicial.", id);
    }
}
