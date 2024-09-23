# Java Spring Boot e Keycloak

Esse projeto é uma demonstração de um autenticador com o Java Spring Security e Keycloak

### Execução do Keycloak com o Docker

    $ docker compose up -d

### Endpoint para a geração do Token JWT do Keycloak

    POST http://localhost:8081/token/gerar

#### Objeto de autenticação para gerar o Token JWT

    {
      "clienId": "app_keycloak_spring",
      "username": "user_keycloak",
      "password": "user",
      "grantType": "password"
    }
    
### Endpoint para testar a autorização do usuário para enviar mensagem

    POST http://localhost:8081/mensagens/?mensagem=conteudo-mensagem

### Endpoint para testar a autorização do usuário para listar mensagens

    GET http://localhost:8081/mensagens/

