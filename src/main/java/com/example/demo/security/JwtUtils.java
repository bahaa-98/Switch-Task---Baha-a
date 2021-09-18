package com.example.demo.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

public class JwtUtils {

    @Value("${app.jwtSecret}")
    private String jwtSecret;

    @Value("${app.jwtExpMs}")
    private int jwtExpMs;

    public String generateToken(Authentication authentication){
        return null;
    }
}
