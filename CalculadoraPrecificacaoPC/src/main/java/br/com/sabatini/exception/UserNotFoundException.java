package br.com.sabatini.exception;

public class UserNotFoundException extends RuntimeException {

    private final String username;

    public UserNotFoundException(String username) {
        this.username = username;
    }

    public String getMessage() {
        return String.format("Usuário com o email '%s' não encontrado!", username);
    }
}
