package com.keycloak.authenticator.config;

import java.util.Collection;
import java.util.Map;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

// Essa classe tem o objetivo de adicionar o prefixo "ROLE_" nos roles vindos do JWT
// Isso é necessário por que o Spring Security tem como padrão esse prefixo
public class JWTConverter implements Converter<Jwt, AbstractAuthenticationToken> {
    @Override
    public AbstractAuthenticationToken convert(Jwt jwt) {

        Map<String, Collection<String>> realmAccess = jwt.getClaim("realm_access"); 
        Collection<String> roles = realmAccess.get("roles");
        var grants = roles
        .stream()
        .map(role -> new SimpleGrantedAuthority("ROLE_"+ role)).toList();


        return new JwtAuthenticationToken(jwt, grants);
    }

}