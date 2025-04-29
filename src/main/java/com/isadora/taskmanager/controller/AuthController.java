package com.isadora.taskmanager.controller;

import com.isadora.taskmanager.entity.User;
import com.isadora.taskmanager.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    // DTO interno para registrar
    public static class RegisterRequest {
        public String name;
        public String email;
        public String password;
    }

    // DTO interno para login
    public static class LoginRequest {
        public String email;
        public String password;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterRequest request) {
        User newUser = authService.register(request.name, request.email, request.password);
        return ResponseEntity.ok(newUser);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginRequest request) {
        User loggedUser = authService.login(request.email, request.password);
        return ResponseEntity.ok(loggedUser);
    }
}

