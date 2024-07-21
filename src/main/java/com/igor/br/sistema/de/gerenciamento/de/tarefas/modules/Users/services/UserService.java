package com.igor.br.sistema.de.gerenciamento.de.tarefas.modules.Users.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.igor.br.sistema.de.gerenciamento.de.tarefas.exceptions.UserFoundException;
import com.igor.br.sistema.de.gerenciamento.de.tarefas.exceptions.UserNotFoundException;
import com.igor.br.sistema.de.gerenciamento.de.tarefas.modules.Users.entities.UserEntity;
import com.igor.br.sistema.de.gerenciamento.de.tarefas.modules.Users.repositories.UserRepository;

@Service
public class UserService {
    
    // regras de negocio da aplicacao e operacoes na aplicacao 

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public UserEntity create(UserEntity userEntity){
        this.userRepository.findByUsernameOrEmail(userEntity.getUsername(), userEntity.getEmail()).ifPresent((user) -> {
            throw new UserFoundException();
        });

        return this.userRepository.save(userEntity);
    }

    @Transactional
    public UserEntity atualizarUsuarioCompleto(UUID id, UserEntity usuarioAtualizado){
        UserEntity usuarioExistente = userRepository.findById(id)
        .orElseThrow(() -> new UserNotFoundException("Usuario com Id: " + id + " nao existe no sistema"));

        usuarioExistente.setName(usuarioAtualizado.getName());
        usuarioExistente.setUsername(usuarioAtualizado.getUsername());
        usuarioExistente.setEmail(usuarioAtualizado.getEmail());
        usuarioExistente.setPassword(usuarioAtualizado.getPassword());
        usuarioExistente.setTasksUsers(usuarioAtualizado.getTasksUsers());

        return userRepository.save(usuarioExistente);
    }

    @Transactional
    public UserEntity atualizarCamposEspecificosDoUsuario(UUID id, String campo, String novoValor) {
        UserEntity usuarioExistente = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Usuario com Id: " + id + " nao existe no sistema"));
        
        switch (campo.toLowerCase()) {
            case "name":
                usuarioExistente.setName(novoValor);
                break;
            case "username":
                usuarioExistente.setUsername(novoValor);
                break;
            case "email":
                usuarioExistente.setEmail(novoValor);
                break;
            case "password":
                usuarioExistente.setPassword(novoValor);
                break;
            default:
                throw new IllegalArgumentException("Campo Invalido: " + campo);
        }

        return userRepository.save(usuarioExistente);
    }

    @Transactional
    public void deletarUsuario(UUID id) {
        UserEntity usuarioExistente = userRepository.findById(id)
            .orElseThrow(() -> new UserNotFoundException("Usuario com Id: " + id + " nao existe no sistema"));
        userRepository.delete(usuarioExistente);
    }
}
