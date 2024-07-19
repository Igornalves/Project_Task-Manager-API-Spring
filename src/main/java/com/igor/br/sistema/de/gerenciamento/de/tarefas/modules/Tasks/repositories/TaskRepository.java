package com.igor.br.sistema.de.gerenciamento.de.tarefas.modules.Tasks.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igor.br.sistema.de.gerenciamento.de.tarefas.modules.Tasks.entities.TaskEntity;

public interface TaskRepository extends JpaRepository<TaskEntity,UUID>{
    
}
