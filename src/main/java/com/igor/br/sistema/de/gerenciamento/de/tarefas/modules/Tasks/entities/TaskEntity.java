package com.igor.br.sistema.de.gerenciamento.de.tarefas.modules.Tasks.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import com.igor.br.sistema.de.gerenciamento.de.tarefas.modules.Users.entities.UserEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity(name="Tarefas")
@Data
public class TaskEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id; 

    private String titulo;
    private String descricao;

    @NotBlank(message = "Campo é obrigatorio !!!!")
    private Boolean status;
    
    @ManyToOne()
    @JoinColumn(name = "usuario_id") // Removidos insertable = false, updatable = false
    private UserEntity userEntity;

    @CreationTimestamp
    private LocalDateTime dataDeCriacao;

}
