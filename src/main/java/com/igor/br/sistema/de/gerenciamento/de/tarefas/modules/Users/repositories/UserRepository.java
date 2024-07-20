package com.igor.br.sistema.de.gerenciamento.de.tarefas.modules.Users.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igor.br.sistema.de.gerenciamento.de.tarefas.modules.Users.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,UUID> {
    Optional<UserEntity> findByUsernameOrEmail(String username, String email);
    Optional<UserEntity> findById(UUID id);
}
