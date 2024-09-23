
# Java Spring Boot e Keycloak

Esse projeto é uma demonstração de um autenticador com o Java Spring Security e Keycloak

### Execução do Keycloak com o Docker

    $ docker compose up -d

#### URL do painel administrativo do Keycloak

	http://localhost:8080/admin
	user=admin
	password=admin

#### Após acessar o painel administrativo do Keycloak, executar os passos:

 1. **Create Realm** -> **Realm name:** keycloak-spring
 2. Aba **Clientes** -> **Create client** -> **Client ID:** app_keycloak_spring
 3. Aba **Realm roles** -> **Create role** -> **Role Name:** USER, ADMIN
 4. Aba **Users** -> **Create user:**
	 **Username:** admin_keycloak, user_keycloak
	 **Email:** admin@root, user@email
	 **Email verified:** true
8. Aba **Users** -> **User details** -> **Role Mapping** -> **Assign Role** -> **Filter by realm roles** -> ADMIN (admin_keycloak), USER (user_keycloak)

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
