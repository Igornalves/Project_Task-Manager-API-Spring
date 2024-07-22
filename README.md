# Projeto de Sistema de gerencimento de Tarefas 

Este projeto é um sistema de gerenciamento de tarefas projetado para ajudar indivíduos a organizar, acompanhar e concluir tarefas de forma eficiente. A aplicação permite a criação, edição e exclusão de tarefas, além de fornecer funcionalidades para o gerenciamento de usuários e a atribuição de tarefas de forma diferente a cada usuario.

## Principais Tecnologias Utilizadas

<br>

<div style="display: inline_block" align="center">

<img  alt="React-Native" width="120" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/spring/spring-original.svg">
<img  alt="React-Native" width="120" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/hibernate/hibernate-original.svg
">
<img  alt="React-Native" width="120" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/postgresql/postgresql-original.svg">
<img  alt="React-Native" width="120" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/postman/postman-original.svg">

</div>

<br>

- Fremework: Spring-Boot 

- Banco de Dados: PostgreSQL 

- ORM: Hibernate

- Teste De Rotas: Postman 

## Funcionalidades Principais

- Cadastro de Usuários

- Atualizacao de campos do Usuario

- Deletar Usuario 

- Buscar por usuario 

- Gerenciamento de Tarefas

- Exclusão de tarefas 

- Status da Tarefa 

- Atualizacao da Tarefa

## Principais Rotas da API CRUD desenvolvida 

### Porta que roda a Aplicacao 

```
localhost:8080
```

### Rota para Criacao de Usuario 
```
localhost:8080/user/criarUsuario
```

#### Body da requisicao (Exemplo)
```Json
{
    "name":"wanderson",
    "username":"coisado da TI",
    "email":"wandersondati90@gmail.com",
    "password":"wandersonTI9012"
}
```

### Rota de Verificacao de Usuario 

```
localhost:8080/user/verificandoUsuario/{id}
```

### Rota para Atualizacao Todos os Campos do Usuario 

```
localhost:8080/user/atualizacacaoDeUsuarioCompleto/{id}
```

#### Body da Requisicao (Exemplo)

```Json
{
    "name":"wanderson",
    "username":"programador de backend da gringa",
    "email":"wandersondati901@gmail.com",
    "password":"Wandersonback9012"
}
```

### Rota Atualizacao dos Campos Especificos Do Usuario

```
localhost:8080/user/atualizarCamposEspecificosDoUsuario/{id}/{campo}
```

#### Body da Requisicao (Exemplo)
```Text
wanderson
```

OBS:. esta requisicao nao pode ser enviada no formato Text e sem espacos para poder voltar o response 200 ok 

### Rota Para deletar o Usuario

```
localhost:8080/user/deletandoUsuario/{id}
```

### Rota para Criar Tasks 

```
localhost:8080/tasks/criandoTask/{id_user}
```

#### Body da Requisicao (Exemplo)

```json
{
    "titulo": "API de login para lojas ",
    "descricao": "as verificacao do usuarios",
    "status": false
}
```

### Rota para deletar Task 

```
localhost:8080/tasks/deletandoTask/{id}
```

### Rota para Listagem de Task 

``` 
localhost:8080/tasks/listaDeTarefas
```

### Rota para Atualizando Tarefas completa

```
localhost:8080/tasks/atualizandoTarefaCompleta/{id}
```

#### Body da Requisicao (Exemplo)

```Json
{
    "titulo": "API para pizzaria",
    "descricao": "usando a Tecnologia React Native e python",
    "status": true
}
```

### Rota de Atualizando Campo Especifico Da Tarefa

```
localhost:8080/tasks/atualizarCampoEspecificoDaTarefa/{campo}/{id}
```

#### Body da Requisicao (Exemplo)

```
false
```

OBS:. esta requisicao nao pode ser enviada no formato Text e sem espacos para poder voltar o response 200 ok 
