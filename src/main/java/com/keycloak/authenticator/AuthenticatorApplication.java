package com.keycloak.authenticator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuthenticatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticatorApplication.class, args);
		System.out.println("App listen on port: 8081");
	}

}
