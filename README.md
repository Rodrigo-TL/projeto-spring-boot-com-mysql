# Projeto Spring Boot com MySQL

API REST desenvolvida em **Java 21 e Spring Boot** para gerenciamento de alunos e usuários, com operações CRUD e persistência em **MySQL** por meio de **Spring Data JPA / Hibernate**.

> **Status:** CRUD funcional para as duas entidades, com testes manuais realizados no Postman e verificações de persistência no MySQL Workbench. O projeto está em evolução; validação de entrada, testes automatizados e melhorias arquiteturais ainda estão planejados.

## 📌 Sobre o projeto

O projeto teve origem na formação de **Desenvolvedor Java do SENAI** e vem sendo aprimorado como parte de um portfólio de desenvolvimento backend. Seu objetivo é exercitar a construção de APIs REST, a integração com bancos relacionais e a evolução gradual de boas práticas com o ecossistema Spring.

**Funcionalidades implementadas:**

- Cadastro, listagem, consulta por ID, atualização e exclusão de alunos.
- Cadastro, listagem, consulta por ID, atualização e exclusão de usuários.
- Respostas HTTP `201` para cadastros, `200` para consultas e atualizações, `204` para exclusões bem-sucedidas e `404` quando o ID solicitado não existe.
- Persistência de dados em banco MySQL local.
- Configuração da conexão com o banco por variáveis de ambiente.

## 🚀 Tecnologias utilizadas

- Java 21
- Spring Boot 3.3.2
- Spring Web
- Spring Data JPA e Hibernate
- MySQL (ambiente local testado com MySQL Community Server 8.0.39)
- MySQL Connector/J
- Maven e Maven Wrapper
- Postman e MySQL Workbench (ferramentas utilizadas nos testes manuais)

## 🏗️ Estrutura do projeto

A aplicação utiliza uma estrutura inicial em camadas, na qual os controllers acessam diretamente os repositories. A introdução de uma camada `service` está prevista no roadmap.

```text
src/main/
├── java/com/example/projetospringbootcommysql/
│   ├── controller/
│   │   ├── AlunoController.java
│   │   └── UsuarioController.java
│   ├── entity/
│   │   ├── AlunoEntity.java
│   │   └── UsuarioEntity.java
│   ├── repository/
│   │   ├── AlunoRepository.java
│   │   └── UsuarioRepository.java
│   └── ProjetoSpringBootComMysqlApplication.java
└── resources/
    └── application.properties
```

## 🔌 Endpoints da API

A URL-base utilizada no ambiente local é `http://localhost:8080`.

### Alunos

| Método | Endpoint | Operação | Respostas previstas |
| --- | --- | --- | --- |
| `POST` | `/alunos` | Cadastrar aluno | `201 Created` |
| `GET` | `/alunos` | Listar alunos | `200 OK` |
| `GET` | `/alunos/{id}` | Buscar aluno por ID | `200 OK` / `404 Not Found` |
| `PUT` | `/alunos/{id}` | Atualizar aluno | `200 OK` / `404 Not Found` |
| `DELETE` | `/alunos/{id}` | Excluir aluno | `204 No Content` / `404 Not Found` |

Exemplo de corpo JSON para `POST /alunos`:

```json
{
  "nome": "Ana Souza",
  "idade": 24,
  "registroAluno": "2026003",
  "emailInstitucional": "ana@example.com",
  "turma": "A",
  "periodo": "Matutino",
  "apresentacao": "Cadastro de exemplo"
}
```

### Usuários

| Método | Endpoint | Operação | Respostas previstas |
| --- | --- | --- | --- |
| `POST` | `/usuarios` | Cadastrar usuário | `201 Created` |
| `GET` | `/usuarios` | Listar usuários | `200 OK` |
| `GET` | `/usuarios/{id}` | Buscar usuário por ID | `200 OK` / `404 Not Found` |
| `PUT` | `/usuarios/{id}` | Atualizar usuário | `200 OK` / `404 Not Found` |
| `DELETE` | `/usuarios/{id}` | Excluir usuário | `204 No Content` / `404 Not Found` |

Exemplo de corpo JSON para `POST /usuarios`:

```json
{
  "nome": "Pedro Oliveira",
  "email": "pedro@example.com"
}
```

**Observação:** os endpoints de atualização (`PUT`) utilizam o ID da URL e os dados enviados no corpo da requisição. O código atual ainda não implementa validação formal dos campos de entrada.

## 🗄️ Persistência de dados

O projeto utiliza `JpaRepository` para acessar as entidades `AlunoEntity` e `UsuarioEntity`. No ambiente local testado, o banco de dados é `escola_db` e a conexão MySQL utiliza a porta padrão `3306`.

As tabelas `aluno_entity` e `usuario_entity` foram criadas/gerenciadas pelo Hibernate com a configuração:

```properties
spring.jpa.hibernate.ddl-auto=update
```

Essa configuração é usada **somente como conveniência no desenvolvimento local**. Em projetos de produção, a evolução do esquema deve ser controlada por migrações versionadas, como Flyway ou Liquibase.

## ▶️ Como executar o projeto

### Pré-requisitos

- JDK 21
- MySQL Server instalado e em execução
- Git
- Maven Wrapper (já incluído neste repositório)
- Postman ou outra ferramenta HTTP (opcional)

### 1. Clonar o repositório

```bash
git clone https://github.com/Rodrigo-TL/projeto-spring-boot-com-mysql.git
cd projeto-spring-boot-com-mysql
```

### 2. Criar o banco de dados e um usuário local

Conecte-se ao MySQL com uma conta administrativa e execute:

```sql
CREATE DATABASE IF NOT EXISTS escola_db
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;
```

Crie uma conta específica para a aplicação e conceda acesso **somente** a `escola_db`. Substitua a senha de exemplo por uma senha forte de sua escolha; não reutilize a senha administrativa do MySQL.

```sql
CREATE USER 'escola_app'@'localhost' IDENTIFIED BY 'SUBSTITUA_POR_SENHA_FORTE';
GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, ALTER, INDEX, REFERENCES
  ON escola_db.* TO 'escola_app'@'localhost';
```

> Se a conta `escola_app` já existir, não execute `CREATE USER` novamente. Configure a senha e as permissões dessa conta conforme necessário.

### 3. Configurar as variáveis de ambiente

O arquivo `src/main/resources/application.properties` utiliza as variáveis abaixo, sem armazenar credenciais diretamente no repositório.

| Variável | Exemplo |
| --- | --- |
| `DB_URL` | `jdbc:mysql://localhost:3306/escola_db` |
| `DB_USERNAME` | `escola_app` |
| `DB_PASSWORD` | Senha definida para o usuário da aplicação |

No **IntelliJ IDEA**, abra **Run → Edit Configurations** e configure as três variáveis no campo **Environment variables** da aplicação Spring Boot.

Se preferir executar no terminal, defina as variáveis no seu ambiente antes de iniciar a aplicação. No PowerShell, por exemplo:

```powershell
$env:DB_URL = "jdbc:mysql://localhost:3306/escola_db"
$env:DB_USERNAME = "escola_app"
$env:DB_PASSWORD = Read-Host "Senha do banco"
```

> O exemplo acima define as variáveis apenas na sessão atual do PowerShell. Não salve senhas reais no README, em arquivos versionados ou em capturas de tela públicas.

### 4. Compilar e executar

**Windows (PowerShell ou Prompt de Comando):**

```powershell
.\mvnw.cmd clean compile
.\mvnw.cmd spring-boot:run
```

**Linux/macOS:**

```bash
./mvnw clean compile
./mvnw spring-boot:run
```

Após a inicialização, a API estará disponível em `http://localhost:8080`, desde que essa porta esteja livre.

Exemplos de consultas HTTP:

```text
GET http://localhost:8080/alunos
GET http://localhost:8080/usuarios
```

## 🧪 Testes e validações

### Testes manuais realizados

As operações CRUD de ambas as entidades foram exercitadas no **Postman**, com os seguintes cenários:

| Cenário | Alunos | Usuários |
| --- | --- | --- |
| Cadastro — `201 Created` | Validado | Validado |
| Listagem — `200 OK` | Validado | Validado |
| Consulta por ID existente — `200 OK` | Validado | Validado |
| Consulta por ID inexistente — `404 Not Found` | Validado | Validado |
| Atualização de ID existente — `200 OK` | Validado | Validado |
| Atualização de ID inexistente — `404 Not Found` | Validado | Validado |
| Exclusão de ID existente — `204 No Content` | Validado | Validado |
| Exclusão de ID inexistente — `404 Not Found` | Validado | Validado |

As alterações e exclusões foram verificadas no MySQL Workbench, e a compilação com **Java 21** foi concluída com `BUILD SUCCESS` pelo Maven Wrapper.

### Testes automatizados

O `pom.xml` já inclui a dependência `spring-boot-starter-test`, porém a criação e a execução de uma suíte de testes automatizados de controllers, serviços e persistência ainda fazem parte do roadmap.

## 🔄 Próximas melhorias

- Introduzir uma camada `Service` para separar a lógica de aplicação dos controllers.
- Adotar injeção de dependências via construtor.
- Criar DTOs para entrada e saída de dados.
- Adicionar validações com Bean Validation (`@Valid`, `@NotBlank`, etc.).
- Centralizar o tratamento de exceções com `@RestControllerAdvice`.
- Criar testes automatizados com JUnit 5, Mockito e MockMvc.
- Publicar e documentar uma coleção de requisições do Postman.
- Documentar os endpoints com OpenAPI/Swagger.
- Revisar a política de CORS, a gestão de credenciais e as dependências do projeto.
- Adotar migrações versionadas do banco de dados com Flyway ou Liquibase.

## 🎓 Contexto acadêmico e portfólio

Projeto iniciado durante a formação de **Desenvolvedor Java no SENAI** e posteriormente ampliado para estudo e demonstração de competências em desenvolvimento Backend Java.

**Rodrigo Leandro**

Tecnólogo em Análise e Desenvolvimento de Sistemas | Estudante de Engenharia de Software | Foco em Backend Java
