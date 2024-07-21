package com.igor.br.sistema.de.gerenciamento.de.tarefas.modules.Tasks.services;

import java.util.List;
import java.util.UUID;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.igor.br.sistema.de.gerenciamento.de.tarefas.exceptions.TaskNotFundException;
import com.igor.br.sistema.de.gerenciamento.de.tarefas.modules.Tasks.entities.TaskEntity;
import com.igor.br.sistema.de.gerenciamento.de.tarefas.modules.Tasks.repositories.TaskRepository;
import com.igor.br.sistema.de.gerenciamento.de.tarefas.modules.Users.entities.UserEntity;
import com.igor.br.sistema.de.gerenciamento.de.tarefas.modules.Users.repositories.UserRepository;

@Service
public class TasksService {
    
    @Autowired
    private TaskRepository taskRepository;

    @Autowired 
    private UserRepository userRepository;

    // fazer metodo para listar as Tasks com status nao concluido

    @Transactional
    public List<TaskEntity> listandoTodasAsTarefas(){
        return taskRepository.findAll();
    }

    @Transactional
    public List<TaskEntity> criandoTarefa(UUID usuario_id,TaskEntity taskEntity){
        UserEntity userEntity = userRepository.findById(usuario_id)
            .orElseThrow(() -> new TaskNotFundException("Este Usuario nao existe no nosso sistema"));

        taskEntity.setUserEntity(userEntity);
        taskRepository.save(taskEntity);

        return taskRepository.findByUserEntity(userEntity);
    }

    @Transactional
    public TaskEntity atualizandoTarefa(UUID id, TaskEntity taskAtualizada){
        TaskEntity taskExistente = taskRepository.findById(id).orElseThrow(() -> {
            String mensagem = "Esta Taks com o Id: " + id + " nao existe no sistema !!!";
            throw new TaskNotFundException(mensagem);
        });

        taskExistente.setTitulo(taskAtualizada.getTitulo());
        taskExistente.setDescricao(taskAtualizada.getDescricao());
        taskExistente.setStatus(taskAtualizada.getStatus());
        // taskExistente.setUserEntity(taskAtualizada.getUserEntity());
                
        return taskRepository.save(taskExistente);
    }
    
    @Transactional
    public TaskEntity atualizandoCampoEspecificoDaTarefa(String Campo, UUID id, String novoValor){
        TaskEntity taskExistente = taskRepository.findById(id).orElseThrow(() -> {
            String message = "esta task nao pode ser alterada pq nao existe ";
            throw new TaskNotFundException(message);
        });
        
        switch (Campo.toLowerCase()) {
            case "titulo":
                taskExistente.setTitulo(novoValor);
                break;
            case "descricao":
                taskExistente.setDescricao(novoValor);
                break;
            case "status":
                if (novoValor == null) {
                    throw new IllegalArgumentException("Valor de status não pode ser nulo");
                }
                if ("true".equalsIgnoreCase(novoValor)) {
                    taskExistente.setStatus(true);
                } else if ("false".equalsIgnoreCase(novoValor)) {
                    taskExistente.setStatus(false);
                } else {
                    throw new IllegalArgumentException("Valor de status invalido: " + novoValor);
                }
                break;
                // case "usuario_id":
                // taskExistente.setUserEntity(novoValor);
                // break;
            default:
                throw new IllegalArgumentException("Campo Invalido: " + Campo);
            }
                        
            return taskRepository.save(taskExistente);
        }
        
        @Transactional
        public List<TaskEntity> deletandoTarefa(UUID id){
            this.taskRepository.findById(id)
                .ifPresentOrElse((task_id) -> taskRepository.delete(task_id), 
                    () -> {
                        try {
                            throw new BadRequestException("A Task %d nao existe no sistema".formatted(id));
                        } catch (BadRequestException e) {
                            e.getMessage();
                        }
                    });
                
            return taskRepository.findAll();
        }
}
