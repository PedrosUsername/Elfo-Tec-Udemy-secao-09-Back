package io.github.pedrosusername.customers;

public class UsuarioCadastradoException extends RuntimeException {

    public UsuarioCadastradoException(String login) {
        super("Usuario " + login + " ja cadastrado");
    }
}
