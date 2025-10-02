# LumiisLU - API de Gerenciamento de Consultório
API RESTful para o gerenciamento de um consultório de psicologia, permitindo o cadastro de psicólogos, pacientes e seus respectivos prontuários. O projeto utiliza Spring Boot para o back-end, com segurança baseada em tokens JWT e persistência de dados com PostgreSQL.

---

## 🚀 Tecnologias Utilizadas
- **Java 17+**
- **Spring Boot 3.5.4**
- **Spring Web: Para a criação de endpoints REST**
- **Spring Data JPA: Para a persistência de dados**
- **Spring Security: Para autenticação e autorização via JWT**
- **PostgreSQL: Como banco de dados**
- **Maven: Para gerenciamento de dependências e build do projeto**
- **ModelMapper: Para mapeamento de objetos (DTOs)**

---

## Pré-requisitos
Antes de começar, você precisará ter instalado em sua máquina:

JDK 21 ou superior.

Um servidor PostgreSQL ativo e rodando.

Maven (opcional, pois o projeto usa o Maven Wrapper).

---

## Instalação e Execução

1. Clone o repositório:

<Este Repositório>.

2. Configure o Banco de Dados:

Abra o arquivo src/main/resources/application.properties e altere as seguintes linhas com as credenciais do seu banco de dados PostgreSQL:

spring.datasource.url=jdbc:postgresql://localhost:5432/seu_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

3. Dê start no arquivo **LumiisLuApplication.java**, localizado:

lumiisLU/
├── .mvn/
│   └── wrapper/
│       └── x
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── br/ufpb/dcx/dsc/lumiislu/
│   │   │       ├── config/
│   │   │       │   ├── ModelMapperConfig.java
│   │   │       │   └── WebSecurityConfig.java
│   │   │       ├── controller/
│   │   │       │   ├── AuthController.java
│   │   │       │   ├── PacienteController.java
│   │   │       │   └── ProntuarioController.java
│   │   │       ├── dto/
│   │   │       │   ├── LoginRequestDTO.java
│   │   │       │   ├── x
│   │   │       │   └── PsicologoResponseDTO.java
│   │   │       ├── exception/
│   │   │       │   └── GlobalExceptionHandler.java
│   │   │       ├── models/
│   │   │       │   ├── Paciente.java
│   │   │       │   ├── Prontuario.java
│   │   │       │   └── Psicologo.java
│   │   │       ├── repository/
│   │   │       │   ├── PacienteRepository.java
│   │   │       │   ├── ProntuarioRepository.java
│   │   │       │   └── PsicologoRepository.java
│   │   │       ├── security/
│   │   │       │   ├── JWTAuthenticationFilter.java
│   │   │       │   ├── JWTAuthorizationFilter.java
│   │   │       │   └── x
│   │   │       ├── services/
│   │   │       │   ├── PacienteService.java
│   │   │       │   ├── ProntuarioService.java
│   │   │       │   └── PsicologoService.java
│   │   │       ├── validation/
│   │   │       │   └── x
│   │   │       └── LumiisLuApplication.java
│   │   x
│   │       
x   x                        
