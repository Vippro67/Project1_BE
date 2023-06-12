package com.backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.backend.dto.UserDTO;
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
    public List<UserDTO> getAllUser(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        
        Page<User> listUser = userRepository.findAll(pageable);
        List<UserDTO> listUserDTO = new ArrayList<>();

        for (User user: listUser) {
            UserDTO userDTO = new UserDTO(user);
            listUserDTO.add(userDTO);
        }
        return listUserDTO;
    }
}