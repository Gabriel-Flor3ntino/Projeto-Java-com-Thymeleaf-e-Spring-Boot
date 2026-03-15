# Aula de Criacao de Formulario Spring Boot

Um projeto Spring Boot para criação e gerenciamento de formulários de cadastro de usuários, utilizando Thymeleaf como template engine.

## Descrição

Este projeto demonstra o uso do Spring Boot com Thymeleaf para criar um sistema de cadastro de usuários completo, incluindo validação de CPF e email, CRUD (Create, Read, Update, Delete) de usuários, e interface web responsiva.

## Tecnologias Utilizadas

- **Java 25**
- **Spring Boot 4.0.3**
- **Spring Web MVC**
- **Thymeleaf** - Template engine para views HTML
- **Apache Tomcat** - Servidor de aplicação (embalado como WAR)
- **Maven** - Gerenciamento de dependências e build

## Funcionalidades

- ✅ Cadastro de usuários com validação de CPF
- ✅ Listagem de usuários cadastrados
- ✅ Edição de registros existentes
- ✅ Exclusão de registros por CPF
- ✅ Validação de CPF personalizada
- ✅ Validação de email
- ✅ Interface web com Thymeleaf

## Estrutura do Projeto

```
src/
├── main/
│   ├── java/com/br/odevjava/formulario/
│   │   ├── AulaDeCriacaoDeFormularioSpringBootApplication.java
│   │   ├── ServletInitializer.java
│   │   ├── controller/
│   │   │   └── FormularioController.java
│   │   ├── entity/
│   │   │   └── Usuario.java
│   │   └── validation/
│   │       ├── CPFValidator.java
│   │       └── EmailValidator.java
│   └── resources/templates/
│       ├── cadastrar.html
│       ├── index.html
│       └── mostrar.html
└── test/
    └── java/com/br/odevjava/formulario/
        └── AulaDeCriacaoDeFormularioSpringBootApplicationTests.java
```

## Entidade Usuario

O sistema gerencia usuários com os seguintes campos:

- `id` - Identificador único
- `nome` - Nome completo
- `cpf` - CPF (com validação)
- `sexo` - Sexo
- `email` - Endereço de email (com validação)
- `senha` - Senha de acesso
- `cargo` - Cargo/função
- `habilidades` - Lista de habilidades

## Endpoints da API

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/home` | Página inicial |
| GET | `/cadastrar` | Formulário de cadastro |
| POST | `/salvar` | Salva/atualiza usuário |
| GET | `/editar/{id}` | Edita usuário pelo ID |
| GET | `/mostrar` | Lista todos os usuários |
| GET | `/excluir/{cpf}` | Exclui usuário pelo CPF |

## Pré-requisitos

- Java 25 ou superior
- Maven 3.6+
- Um servidor de aplicação compatível com WAR (Tomcat, Jetty, etc.)

## Como Executar

### Usando Maven Wrapper

```bash
# No Linux/Mac
./mvnw spring-boot:run

# No Windows
mvnw.cmd spring-boot:run
```

### Usando Maven Direto

```bash
mvn spring-boot:run
```

### Build e Deploy

```bash
# Gerar o arquivo WAR
mvn clean package

# O arquivo será gerado em target/formulario-0.0.1-SNAPSHOT.war
```

Após o build, faça deploy do arquivo WAR no seu servidor de aplicação preferido.

## Acessando a Aplicação

Após iniciar a aplicação, acesse:

- **Página Inicial**: http://localhost:8080/home
- **Cadastro**: http://localhost:8080/cadastrar
- **Listagem**: http://localhost:8080/mostrar

## Validações

### CPF Validator
O sistema inclui um validador de CPF personalizado que verifica se o CPF informado é válido antes de salvar o usuário.

### Email Validator
Validação de formato de email para garantir que o endereço informado esteja correto.

## Testes

Execute os testes unitários com:

```bash
mvn test
```

## Observações

- Os dados são armazenados em memória (ArrayList) e serão perdidos ao reiniciar a aplicação
- Este projeto é destinado para fins educacionais e de demonstração
- Para produção, considere implementar persistência em banco de dados

## Licença

Este projeto está sob licença livre para uso educacional.

## Autor

Desenvolvido como parte de um tutorial sobre criação de formulários com Spring Boot e Thymeleaf.
