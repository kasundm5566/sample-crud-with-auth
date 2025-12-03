package com.example.samplecrudwithauth.service;

import com.example.samplecrudwithauth.model.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findByUsername(String username);
}
