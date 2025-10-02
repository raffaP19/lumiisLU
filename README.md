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

lumiisLU/src/main/java/br/ufpb/dcx/dsc/lumiislu/LumiisLuApplication.java

4. Utilizar o Postman para executar as rotas:

Para que os pacientes sejam cadastrados é preciso que o Psicologo tenha sido cadastrado primeiro, pois com o token do Psicologo, todas as rotas recebem a liberação para funcionarem.

5. Inicialmente para funcionar:

- Post: http://localhost:8080/auth/register -> Registar o Psicologo. (Deve-se colocar no Authorization **No Auth**)
- Post: http://localhost:8080/auth/login -> Para gerar o token e poder liberar as demais requisições. (Deve-se colocar no Authorization **No Auth**)
- Get: http://localhost:8080/auth/me -> Retorna as informações necessárias para o psicologo conferir seu cadastro. (Aqui o token é necessário, ele foi gerado no login. No Auth Type, colocar **Bearer Token** para funcionar a requisição)
  
->>> Para facilitar, aqui vai um script que preenche automaticamente após gerar o token nas demais requisições: (Ele deve ser colocado em **Script** de Login)

pm.test("Token foi recebido com sucesso", function () {
    // 1. Converte a resposta JSON em um objeto JavaScript
    const responseJson = pm.response.json();

    // 2. Verifica se a propriedade "token" existe na resposta
    pm.expect(responseJson.token).to.not.be.empty;

    // 3. Extrai o valor do token
    const token = responseJson.token;

    // 4. Guarda o token na variável de coleção chamada "AUTH_TOKEN"
    pm.collectionVariables.set("AUTH_TOKEN", token);

    console.log("Token de autenticação salvo com sucesso!");

});

**Para que ele faça isso sem precisar copiar e colar o token, deve-se preencher neste campo em branco de Authorization com a variavel "{{AUTH_TOKEN}}" em: Auth Type, **Bearer Token, campo em branco ao lado direito.**

...continua

---

Acesse o Swagger para ver as demais rotas:
- http://localhost:8080/swagger-ui.html
  
