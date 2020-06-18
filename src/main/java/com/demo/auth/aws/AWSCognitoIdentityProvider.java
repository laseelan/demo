package com.demo.auth.aws;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AWSCognitoIdentityProvider {
    private static Map<String, String> users = new HashMap();

    static {
        users.put("admin", "password");
    }

    public boolean adminInitialization(AdminInitializeAuthRequest request) {
        String username = request.get("USERNAME");
        String password = request.get("PASSWORD");
        return users.containsKey(username) && users.get(username).equals(password);
    }
}
