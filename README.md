<h1>Cobertura de testes</h1>

Objetivo: Criar uma API REST com cobertura de testes de 100% com JUnit e Mockito utilizando Spring Boot e banco de dados em memória H2.

Recurso: users

<h2>Atributos:</h2>

- ID
- NAME
- EMAIL
- PASSWORD

<h2>Tecnologias utilizadas:</h2>

- Java 17 
- Spring Boot
- Maven
- JUnit 5 
- Mockito 
- Lombok 
- ModelMapper 
- Spring Data JPA 
- Hibernate 
- H2 

<h2>Como executar o projeto:</h2>

Certifique se que seu computador tenha instalado o java 17 e maven, após siga os seguintes passos.

1. Clone o projeto do GitHub:<br>```git clone https://github.com/danieltsuzuki/cobertura-de-testes.git```
2. Entre na pasta do projeto:<br>```cd cobertura-de-testes```
3. Instale as dependências do projeto:<br>```mvn clean install```
4. Execute a aplicação:<br>```mvn spring-boot:run```

A aplicação estará disponível na porta 8080. 

Documentação da API:

A documentação da API está disponível no seguinte endpoint:

http://localhost:8080/swagger-ui.html

<h2>>Endpoints</h2>

- GET /users<br>Requisição: ```GET http://localhost:8080/users```<br>Resposta:
  ```
    [
      {
        "id": 1,
        "name": "Fulano de Tal",
        "email": "fulano@example.com",
        "password": "123456"
      },
      {
        "id": 2,
        "name": "Beltrano de Tal",
        "email": "beltrano@example.com",
        "password": "789012"
      }
    ]
  ```

- GET /users/{id}<br>Requisição: ```GET /users/1```<br>Resposta:
  ```
    {
      "id": 1,
      "name": "Fulano de Tal",
      "email": "fulano@example.com",
      "password": "123456"
    }
  ```
- POST /users<br>Requisição:
  ```
    POST http://localhost:8080/users
    Content-Type: application/json
                              
    {
      "name": "Ciclano de Tal",
      "email": "ciclano@example.com",
      "password": "345678"
    }
  ```
  Resposta:
  ```
    {
      "id": 3,
      "name": "Ciclano de Tal",
      "email": "ciclano@example.com",
      "password": "345678"
    }
  ```
- PUT /users/{id}:<br>Requisição
  ```
    PUT http://localhost:8080/users/2
    Content-Type: application/json
    
    {
      "name": "Beltrano de Tal alterado",
      "email": "beltranoalterado@example.com",
      "password": "987654"
    }
  ```
  Resposta:
  ```
    {
      "id": 2,
      "name": "Beltrano de Tal alterado",
      "email": "beltranoalterado@example.com",
      "password": "987654"
    }
  ```
- DELETE /users/{id}<br>Requisição: ```DELETE http://localhost:8080/users/3```<br>Resposta: ```Status Code: 204```

<h2>Testes:</h2>

Os testes da API estão localizados no diretório src/test/java. Para executar os testes, execute o seguinte comando:<br>```mvn test```

A cobertura de testes deve ser de 100%.

<h2>Recursos adicionais:</h2>

O projeto também inclui os seguintes recursos adicionais:

- Validação de dados
- Tratamento de exceções
- Uso adequado do protocolo HTTP no padrão REST

<h2>Referências:</h2>

Spring Boot: https://spring.io/projects/spring-boot<br>
JUnit 5: https://junit.org/junit5/<br>
Mockito: https://site.mockito.org/<br>
Lombok: https://projectlombok.org/<br>
ModelMapper: https://modelmapper.org/<br>
Spring Data JPA: https://spring.io/projects/spring-data-jpa<br>
Hibernate: https://hibernate.org/<br>
H2: https://www.h2database.com/<br>
