package com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.dto.UserDTO;
import com.backend.entity.User;
import com.backend.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping()
    public List<UserDTO> getAllUser()
    {
        return userService.getAllUser();
    }
    
    @PostMapping()
    public User createUser(@RequestBody User user)
    {
        return userService.createUser(user);
    }
}