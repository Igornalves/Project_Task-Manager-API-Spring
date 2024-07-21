package com.igor.br.sistema.de.gerenciamento.de.tarefas.modules.Users.controller;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igor.br.sistema.de.gerenciamento.de.tarefas.modules.Users.entities.UserEntity;
import com.igor.br.sistema.de.gerenciamento.de.tarefas.modules.Users.repositories.UserRepository;
import com.igor.br.sistema.de.gerenciamento.de.tarefas.modules.Users.services.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/user")
public class UserController {

    // controle de rotas nos quais chamaram os servicos da aplicacao e suas regras de negocios

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;
    
    @PostMapping("/criarUsuario")
    public ResponseEntity<Object> criarUsuario(@Valid @RequestBody UserEntity userEntity){
        try {
            var resultado = this.userService.create(userEntity);
            return ResponseEntity.ok().body(resultado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/verificandoUsuario/{id}")
    public ResponseEntity<String> verificandoUsuario(@PathVariable UUID id) {
        Optional<UserEntity> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            // Usuário encontrado
            var message = "Usuario com o Id: " + id + " Foi encontrando com sucesso !!!";
            return ResponseEntity.ok(message);
        } else {
            // Usuário não encontrado
            var message = "Usuario com o Id" + id + " Nao foi encontrando no Sistema !!!";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }

    @PutMapping("/atualizacacaoDeUsuarioCompleto/{id}")
    public ResponseEntity<UserEntity> atualizacacaoDeUsuarioCompleto(@PathVariable UUID id, @RequestBody UserEntity usuario) {
        UserEntity updatedUser = userService.atualizarUsuarioCompleto(id, usuario);
        return ResponseEntity.ok(updatedUser);
    }

    @PatchMapping("/atualizarCamposEspecificosDoUsuario/{id}/{campo}")
    public ResponseEntity<UserEntity> atualizarCamposEspecificosDoUsuario(@PathVariable UUID id, @PathVariable String campo, @RequestBody String novoValor) {
        UserEntity atualizandoUsuario = userService.atualizarCamposEspecificosDoUsuario(id, campo, novoValor);
        return ResponseEntity.ok(atualizandoUsuario);
    }

    @DeleteMapping("/deletandoUsuario/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable UUID id) {
        userService.deletarUsuario(id);
        return ResponseEntity.noContent().build(); // Retorna 204 No Content ao excluir com sucesso
    }
    
}
