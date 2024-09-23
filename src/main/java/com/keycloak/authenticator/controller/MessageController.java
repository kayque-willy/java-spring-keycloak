package com.keycloak.authenticator.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/mensagens")
public class MessageController{

  @PostMapping("/")
  @PreAuthorize("hasRole('ADMIN')")
  public String enviar(@RequestParam String mensagem){
    return "Mensagem enviada: " + mensagem;
  }

  @GetMapping("/")
  @PreAuthorize("hasRole('USER')")
  public String listar() {
      return "Listando mensagens";
  }
 
}