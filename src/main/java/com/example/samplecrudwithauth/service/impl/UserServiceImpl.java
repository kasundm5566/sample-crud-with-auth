package com.example.samplecrudwithauth.service.impl;

import com.example.samplecrudwithauth.model.User;
import com.example.samplecrudwithauth.repository.UserRepository;
import com.example.samplecrudwithauth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
