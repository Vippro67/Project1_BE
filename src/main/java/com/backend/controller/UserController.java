package com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.dto.UserDTO;
import com.backend.entity.User;
import com.backend.service.UserService;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping()
    public List<UserDTO> getAllUser(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size)
    {
        return userService.getAllUser(page, size);
    }
    
    @PostMapping()
    public User createUser(@RequestBody User user)
    {
        return userService.createUser(user);
    }
}