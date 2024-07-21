package com.igor.br.sistema.de.gerenciamento.de.tarefas.exceptions;

public class TaskNotFundException extends RuntimeException {
    public TaskNotFundException(String message){
        super(message);
    }
}
