# Task Management System Project

This project is a task management system designed to help individuals ***organize, track, and complete tasks*** efficiently. The application allows for ***creating, editing, and deleting tasks***, as well as providing functionality for managing users and assigning tasks differently to each user.

## Index

- [Technologies and Tools Used](#technologies-and-tools-used)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Installation and Configuration](#installation-and-configuration)
- [Project Execution](#project-execution)

## Technologies and Tools Used

<br>
<div style="display: inline_block" align="center">

<img width="100" src="https://skillicons.dev/icons?i=java">
<img width="100" src="https://skillicons.dev/icons?i=spring">
<img width="100" alt="Spring" width="120" src="https://skillicons.dev/icons?i=hibernate">
<img width="100" src="https://skillicons.dev/icons?i=postgres">
<img width="100" src="https://skillicons.dev/icons?i=postman">

</div>
<br>

- ***Language:*** Java

- ***Fremework:*** Spring-Boot

- ***Database:*** PostgreSQL

- ***ORM:*** Hibernate

- ***Route Testing:*** Postman

## Project Structure

## Prerequisites

You need to ensure that your development environment is properly configured. Here are the main prerequisites:

<br>
<div style="display: inline_block" align="center">

<img width="100" src="https://skillicons.dev/icons?i=java">
<img width="100" src="https://skillicons.dev/icons?i=maven">
<img width="100" src="https://skillicons.dev/icons?i=gradle">
<img width="100" src="https://skillicons.dev/icons?i=mysql">

</div>
<br>

- Java Development Kit (JDK): ***version 8*** or higher as ***JDK 11*** recommended by the documentation

- Maven or Gradle: ***build*** tools to manage ***dependencies*** and create application artifacts.

- Database (SQL or NoSQL): Make sure that ***PostgreSQL*** or others are already installed and configured correctly.

#### IDE (Integrated Development Environment):

<br>
<div style="display: inline_block" align="center">

<img width="100" src="https://skillicons.dev/icons?i=vscode">
<img width="100" src="https://skillicons.dev/icons?i=eclipse">
<img width="100" src="https://skillicons.dev/icons?i=idea">

</div>
<br>

- ***IntelliJ IDEA*** (with the Spring Boot plugin integrated).
- ***Eclipse*** (with the Spring Tools Suite - STS plugin).
- ***VS Code*** (with extensions for Java and Spring Boot)

## Installation and Configuration

1. **Clone the repository**:
```bash
git clone https://github.com/Igornalves/Projeto_Gerenciador-de-Tarefas-Spring
```
2. **Database configuration**:

- Create a PostgreSQL or other database. - Configure the database access credentials in the application.properties or application.yml file

```bash
spring.datasource.url=jdbc:postgresql://localhost:5432/database_name
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

3. **Installing the dependencies**:

- If you are using Maven:

```bash
mvn clean install
```

- If you are using Gradle:

```bash
gradle build
```

## Project Execution

1. **Running the application:**

- If you are using Maven:

```bash
mvn spring-boot:run
```

- If you are using Gradle:

```bash
gradle bootRun
```

2. **Accessing the application:**

<br>
<div style="display: inline_block" align="center">

<img width="100" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/chrome/chrome-original.svg" />

</div>
<br>

- The application will be running at ```http://localhost:8080``` by default, NOTE:. check if there is any change in the default port to be run in the application.

3. **Testing API routes:**

<br>
<div style="display: inline_block" align="center">

<img width="100" src="https://skillicons.dev/icons?i=postman">

</div>
<br>

- Use Postman to test requests such as GET, POST, PUT and DELETE.
