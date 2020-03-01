package com.perfiltic.test.dto;

import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"username",
"password"
})
public class UserDto {

@JsonProperty("username")
@NotBlank(message = "username cannot be blank")
@Size(min = 5,message ="username need to have at least 5 characters")
private String username;

@JsonProperty("password")
@NotBlank(message = "password cannot be blank")
@Size(min = 5,message ="password need to have at least 5 characters")
private String password;

/**
* No args constructor for use in serialization
*
*/
public UserDto() {
}

/**
*
* @param password
* @param username
*/
public UserDto(String username, String password) {
super();
this.username = username;
this.password = password;
}

@JsonProperty("username")
public String getUsername() {
return username;
}

@JsonProperty("username")
public void setUsername(String username) {
this.username = username;
}

@JsonProperty("password")
public String getPassword() {
return password;
}

@JsonProperty("password")
public void setPassword(String password) {
this.password = password;
}

}