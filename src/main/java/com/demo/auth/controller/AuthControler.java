package com.demo.auth.controller;

import com.demo.auth.model.User;
import com.demo.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class AuthControler {
    private AuthService service;

    @Autowired
    public AuthControler(AuthService service) {
        this.service = service;
    }

    @GetMapping("auth")
    public boolean authenticate(String username, String password) {
        User user= new User(username, password);
        return service.authenticate(user);
    }
}
