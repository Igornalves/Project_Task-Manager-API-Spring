package com.igor.br.sistema.de.gerenciamento.de.tarefas.modules.Users.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igor.br.sistema.de.gerenciamento.de.tarefas.modules.Users.entities.UserEntity;
import com.igor.br.sistema.de.gerenciamento.de.tarefas.modules.Users.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public void execute(UserEntity userEntity){
        
    }
}
