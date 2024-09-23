package com.keycloak.authenticator.auth;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.keycloak.authenticator.dto.UserDTO;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/token")
public class TokenController{

  @Value("${url-keycloak}")
  String urlKeycloak;

  @PostMapping("/gerar")
  public ResponseEntity<String> gerarToken(@RequestBody UserDTO user){

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

    MultiValueMap <String, String> formData = new LinkedMultiValueMap<>();
    formData.add("client_id", user.getClienId());
    formData.add("username", user.getUsername());
    formData.add("password", user.getPassword());
    formData.add("grant_type", user.getGrantType());

    HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<MultiValueMap<String, String>>(formData, headers);

    RestTemplate restTemplate = new RestTemplate();
    return restTemplate.postForEntity(
      urlKeycloak, 
      httpEntity, 
      String.class);

  }

 
}