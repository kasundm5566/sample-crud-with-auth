package com.example.samplecrudwithauth.model;

import lombok.Getter;

@Getter
public class TokenRequest {
    private String username;
    private String password;
}
