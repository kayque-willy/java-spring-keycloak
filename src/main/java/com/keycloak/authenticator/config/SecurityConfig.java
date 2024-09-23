package com.keycloak.authenticator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

    http
      // Desabilita o padrão de segurança para as rotas
      .csrf(csrf -> csrf.disable())
      // Faz conversão para adicionar o prefixo "ROLE_" nos roles que vierem no JWT
      .oauth2ResourceServer(oauth2 -> oauth2
      .jwt(jwt -> jwt.jwtAuthenticationConverter(new JWTConverter())));

    return http.build();
  }
  
}
