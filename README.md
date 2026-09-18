# Projeto Spring Boot com MySQL

API REST desenvolvida com Java e Spring Boot para gerenciamento de alunos e usuários, com persistência de dados utilizando Spring Data JPA e MySQL.

## 📌 Sobre o projeto

Este projeto foi desenvolvido durante minha formação em Desenvolvimento Java no SENAI, com o objetivo de aplicar na prática conceitos fundamentais do desenvolvimento de aplicações backend utilizando o ecossistema Spring.

A aplicação disponibiliza endpoints REST para cadastro, consulta, atualização e exclusão de dados, utilizando Spring Data JPA para a persistência das informações em banco de dados MySQL.

## 🚀 Tecnologias utilizadas

- Java 21
- Spring Boot 3.3.2
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- REST API

## 🏗️ Estrutura do projeto

A aplicação está organizada em camadas básicas:

```text
src
└── main
    ├── java
    │   └── com.example.projetospringbootcommysql
    │       ├── controller
    │       │   ├── AlunoController.java
    │       │   └── UsuarioController.java
    │       │
    │       ├── entity
    │       │   ├── AlunoEntity.java
    │       │   └── UsuarioEntity.java
    │       │
    │       ├── repository
    │       │   ├── AlunoRepository.java
    │       │   └── UsuarioRepository.java
    │       │
    │       └── ProjetoSpringBootComMysqlApplication.java
    │
    └── resources
        └── application.properties
