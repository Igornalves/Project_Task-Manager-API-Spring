package com.igor.br.sistema.de.gerenciamento.de.tarefas.exceptions;

public class UserFoundException extends RuntimeException {
    public UserFoundException(){
        super("User ja existente no sistema !!!!");
    }
}
