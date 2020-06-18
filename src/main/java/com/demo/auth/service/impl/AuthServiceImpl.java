package com.demo.auth.service.impl;

import com.demo.auth.aws.AWSCognitoIdentityProvider;
import com.demo.auth.aws.AdminInitializeAuthRequest;
import com.demo.auth.model.User;
import com.demo.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthServiceImpl implements AuthService {

    private AWSCognitoIdentityProvider provider;

    @Autowired
    public AuthServiceImpl(AWSCognitoIdentityProvider provider){
        this.provider = provider;
    }
    public boolean authenticate(User user) {
        Map<String, String> params= new HashMap<>();
        params.put("USERNAME", user.getUsername());
        params.put("PASSWORD", user.getPassword());
        AdminInitializeAuthRequest request = new AdminInitializeAuthRequest(params);
        return provider.adminInitialization(request);
    }
}
