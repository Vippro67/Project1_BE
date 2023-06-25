package com.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.backend.dto.AuthRequest;
import com.backend.dto.CreateUserReq;
import com.backend.entity.User;
import com.backend.security.JwtProvider;
import com.backend.service.UserDetailsServiceImpl;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/signin")
    public String getToken(@RequestBody AuthRequest authRequest) throws Exception {
        // Get user details
        UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());

        if(passwordEncoder.matches(authRequest.getPassword(), userDetails.getPassword())){
            // Generate token
            return jwtProvider.generateToken(authRequest.getUsername());
        }

        throw new Exception("User details invalid.");
    }

    @PostMapping("/createUser")
    public User createUser(@RequestBody CreateUserReq req) throws Exception {
        return userDetailsService.createUser(req);
    }
}
