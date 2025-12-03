package com.example.samplecrudwithauth.controller;

import com.example.samplecrudwithauth.model.TokenRequest;
import com.example.samplecrudwithauth.model.User;
import com.example.samplecrudwithauth.service.UserService;
import com.example.samplecrudwithauth.util.JwtUtil;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("v1/auth/token")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    @PostMapping
    @RateLimiter(name = "authApi", fallbackMethod = "rateLimitFallback")
    public Map<String, Object> token(@RequestBody TokenRequest tokenRequest) {
        Optional<User> user = userService.findByUsername(tokenRequest.getUsername());
        if (user.isPresent() && user.get().getPassword().equals(tokenRequest.getPassword())) {
            String token = jwtUtil.generateToken(tokenRequest.getUsername());
            return Map.of("token", token, "expiresIn", 3600);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    public String rateLimitFallback(Throwable t) {
        return "⛔ Too many requests. Please try again later.";
    }
}
