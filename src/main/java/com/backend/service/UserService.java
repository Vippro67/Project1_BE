package com.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.entity.User;
import com.backend.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        // Check if username or email already exists
        if (userRepository.findByUsername(user.getUsername()) != null) {
           // throw new UserAlreadyExistsException("Username already exists");
        }
        if (userRepository.findByEmail(user.getEmail()) != null) {
          //  throw new UserAlreadyExistsException("Email already exists");
        }
        return userRepository.save(user);
    }
    public User getUserByEmail(String email) {
            return userRepository.findByEmail(email);
        }
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);

    }
    public Optional<User> getUserById(String id)
    {
        return userRepository.findById(id);
    }
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}