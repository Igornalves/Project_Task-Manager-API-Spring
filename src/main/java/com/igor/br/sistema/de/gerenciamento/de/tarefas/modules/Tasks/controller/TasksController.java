package com.igor.br.sistema.de.gerenciamento.de.tarefas.modules.Tasks.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TasksController {
    
    @GetMapping("/testapi")
    public String testeDeRota(){
        return "Teste concluido com sucesso !!!!";
    }
    
}
