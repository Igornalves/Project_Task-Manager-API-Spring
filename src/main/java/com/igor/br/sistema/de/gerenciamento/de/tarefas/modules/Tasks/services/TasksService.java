package com.igor.br.sistema.de.gerenciamento.de.tarefas.modules.Tasks.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igor.br.sistema.de.gerenciamento.de.tarefas.modules.Tasks.repositories.TaskRepository;

@Service
public class TasksService {
    
    @Autowired
    private TaskRepository taskRepository;

}
