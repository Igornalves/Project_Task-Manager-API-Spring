package com.igor.br.sistema.de.gerenciamento.de.tarefas.modules.Tasks.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igor.br.sistema.de.gerenciamento.de.tarefas.modules.Tasks.entities.TaskEntity;
import com.igor.br.sistema.de.gerenciamento.de.tarefas.modules.Tasks.services.TasksService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/tasks")
public class TasksController {

    // permite fazer injecao de dependencia no spring criando para vc o construtor ja resolvido para vc 
    @Autowired
    private TasksService tasksService;
    
    @GetMapping("/testapi")
    public String testeDeRota(){
        return "Teste concluido com sucesso !!!!";
    }

    @GetMapping("/listaDeTarefas")
    public ResponseEntity<Object> listaDeTarefas(){
        try {
            var resultado = this.tasksService.listandoTodasAsTarefas();
            return ResponseEntity.ok().body(resultado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @PostMapping("/criandoTask/{usuario_id}")
    public ResponseEntity<Object> criacaoDeTasks(@PathVariable UUID usuario_id, @RequestBody TaskEntity taskEntity) {
        try {
            List<TaskEntity> resultado = this.tasksService.criandoTarefa(usuario_id,taskEntity);
            return ResponseEntity.ok().body(resultado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/atualizandoTarefaCompleta/{id}")
    public ResponseEntity<Object> atualizandoTarefaCompleta(@PathVariable UUID id, @RequestBody TaskEntity taskEntity) {
        TaskEntity taskAtualizada = tasksService.atualizandoTarefa(id, taskEntity);
        return ResponseEntity.ok(taskAtualizada);      
    }
    
    @PatchMapping("/atualizarCampoEspecificoDaTarefa/{Campo}/{id}")
    public ResponseEntity<Object> atualizarCampoEspecificoDaTarefa(@PathVariable String Campo,@PathVariable UUID id, @RequestBody String novoValor){
        TaskEntity taskAtualizada = tasksService.atualizandoCampoEspecificoDaTarefa(Campo, id, novoValor);
        return ResponseEntity.ok(taskAtualizada);
    }

    @DeleteMapping("/deletandoTask/{id}")
    public ResponseEntity<Object> deletandoTask(@PathVariable UUID id){
        try {
            List<TaskEntity> tasks = this.tasksService.deletandoTarefa(id);
            return ResponseEntity.ok().body(tasks);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
