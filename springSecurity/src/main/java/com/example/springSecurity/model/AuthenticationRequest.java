package com.example.springSecurity.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class AuthenticationRequest {

    private String username;
    private String password;

    public AuthenticationRequest(){

    }
}
