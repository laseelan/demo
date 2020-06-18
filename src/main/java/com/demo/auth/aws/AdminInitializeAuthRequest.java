package com.demo.auth.aws;

import java.util.HashMap;
import java.util.Map;

public class AdminInitializeAuthRequest {
    private Map<String, String> params= new HashMap();

    public AdminInitializeAuthRequest(Map<String, String> params) {
        this.params = params;
    }

    public String get(String name) {
        return this.params.get(name);
    }
}
