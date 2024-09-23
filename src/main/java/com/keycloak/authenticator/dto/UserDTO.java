package com.keycloak.authenticator.dto;

public class UserDTO {

  String clienId;
  String username;
  String password;
  String grantType;

  public String getClienId() {
    return clienId;
  }
  public void setClienId(String clienId) {
    this.clienId = clienId;
  }
  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public String getGrantType() {
    return grantType;
  }
  public void setGrantType(String grantType) {
    this.grantType = grantType;
  }

}
