package com.igor.br.sistema.de.gerenciamento.de.tarefas.exceptions;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message){
        super(message);
    }
}
