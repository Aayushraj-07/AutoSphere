package com.codewithaayush.dto;

import lombok.Data;

@Data
public class AuthenticationRequest {

    private String email;

    private String password;

    public String getUsername() {
        return "";
    }

    public Object getPassword() {
        return null;
    }
}
