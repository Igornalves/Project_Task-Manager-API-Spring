package com.igor.br.sistema.de.gerenciamento.de.tarefas.modules.Users.entities;

import java.util.List;
import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import com.igor.br.sistema.de.gerenciamento.de.tarefas.modules.Tasks.entities.TaskEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity(name = "user")
@Data
public class UserEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Campo name Obrigatorio !!!")
    private String name;

    @NotBlank(message = "Campo username Obrigatotio !!!")
    private String username;

    @NotBlank(message = "Campo email Obrigatorio !!!!")
    private String email;

    @Length(min = 10, max = 100, message = "A senha deve conter entre (10) e (100) caracteres")
    private String password;

    @OneToMany(mappedBy = "TaskEntity", cascade = CascadeType.ALL)
    private List<TaskEntity> tasks_users;

}
