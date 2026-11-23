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
```
## 🔌 Endpoints da API

A aplicação disponibiliza operações REST para gerenciamento de alunos e usuários.

### Alunos

| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/alunos` | Cadastrar aluno |
| GET | `/alunos` | Listar alunos |
| PUT | `/alunos/{id}` | Atualizar aluno |
| DELETE | `/alunos/{id}` | Excluir aluno |

### Usuários

| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/usuarios` | Cadastrar usuário |
| GET | `/usuarios` | Listar usuários |
| PUT | `/usuarios/{id}` | Atualizar usuário |

Os endpoints foram identificados diretamente nos controllers do projeto. Seu funcionamento atual ainda precisa ser validado.

---

## 🗄️ Persistência de dados

A aplicação utiliza Spring Data JPA e Hibernate para realizar operações de persistência no banco de dados MySQL.

As entidades principais são:

- `AlunoEntity`: representa os dados de alunos.
- `UsuarioEntity`: representa os dados de usuários.

Os repositórios estendem `JpaRepository`, disponibilizando operações de persistência e consulta.

---

## ▶️ Como executar o projeto

### Pré-requisitos

- Java 21
- MySQL configurado e acessível
- Git
- IntelliJ IDEA ou outra IDE Java

O projeto possui Maven Wrapper, permitindo executar comandos Maven sem uma instalação global separada.

### Configuração do banco de dados

A conexão utiliza variáveis de ambiente:

- `DB_URL`: URL JDBC de conexão com o MySQL.
- `DB_USERNAME`: usuário do banco de dados.
- `DB_PASSWORD`: senha do banco de dados.

Exemplo de URL para uma instalação local:

`jdbc:mysql://localhost:3306/nome_do_banco`

O banco de dados deve existir e as credenciais precisam possuir as permissões necessárias.

**Segurança:** não publique credenciais reais no código, nos commits ou na documentação.

### Execução

No terminal, dentro da pasta do projeto:

**Windows:**

`.\mvnw.cmd spring-boot:run`

**Linux/macOS:**

`./mvnw spring-boot:run`

Após a inicialização bem-sucedida, os endpoints poderão ser acessados em `http://localhost:8080`, desde que a porta padrão esteja disponível.

**Estado atual:** execução e conexão com o banco de dados pendentes de nova validação.

---

## 🧪 Testes

O projeto possui a dependência `spring-boot-starter-test`.

A implementação de testes automatizados para controllers, repositórios e regras de negócio está prevista como evolução do projeto.

---

## 🔄 Próximas melhorias

- Validar a conexão com o MySQL.
- Implementar uma camada Service.
- Utilizar DTOs para entrada e saída de dados.
- Adicionar validação de dados.
- Implementar tratamento padronizado de exceções.
- Criar testes automatizados.
- Documentar a API com OpenAPI/Swagger.
- Revisar as configurações de segurança.
- Melhorar a organização da arquitetura backend.

---

## 🎓 Contexto acadêmico

Projeto desenvolvido durante a formação em Desenvolvimento Java pelo SENAI, com o objetivo de aplicar conceitos de Java, Spring Boot, APIs REST e persistência de dados.

O repositório integra meu portfólio de desenvolvimento Backend Java e está em processo de aprimoramento técnico.

**Rodrigo Leandro**

Tecnólogo em Análise e Desenvolvimento de Sistemas | Estudante de Engenharia de Software | Foco em Backend Java
