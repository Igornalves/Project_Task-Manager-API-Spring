package com.igor.br.sistema.de.gerenciamento.de.tarefas.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message){
        super(message);
    }
}
