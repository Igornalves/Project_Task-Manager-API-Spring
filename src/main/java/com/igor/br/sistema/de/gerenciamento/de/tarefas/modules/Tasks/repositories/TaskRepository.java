package com.igor.br.sistema.de.gerenciamento.de.tarefas.modules.Tasks.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igor.br.sistema.de.gerenciamento.de.tarefas.modules.Tasks.entities.TaskEntity;
import com.igor.br.sistema.de.gerenciamento.de.tarefas.modules.Users.entities.UserEntity;


public interface TaskRepository extends JpaRepository<TaskEntity,UUID>{
    Optional<TaskEntity> findById(UUID id);
    List<TaskEntity> findByUserEntity(UserEntity userEntity);
}
