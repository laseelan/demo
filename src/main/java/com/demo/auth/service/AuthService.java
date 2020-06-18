package com.demo.auth.service;

import com.demo.auth.model.User;

public interface AuthService {
    boolean authenticate(User user);
}
