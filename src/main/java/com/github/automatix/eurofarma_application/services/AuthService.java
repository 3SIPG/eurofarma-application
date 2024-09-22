package com.github.automatix.eurofarma_application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    public Authentication authenticate(String username, String password) throws AuthenticationException {
        // Create the authentication token with username and password
        UsernamePasswordAuthenticationToken authRequest =
                new UsernamePasswordAuthenticationToken(username, password);

        // Authenticate the user using AuthenticationManager
        Authentication authResult = authenticationManager.authenticate(authRequest);

        return authResult;  // If authentication is successful, return the authenticated user
    }
}
