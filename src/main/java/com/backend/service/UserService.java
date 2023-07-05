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
        Optional<User> userCheckPhone = userRepository.findByPhone(user.getPhoneNumber());
        Optional<User> userCheckEmail = userRepository.findByEmail(user.getEmail());
        if (userCheckPhone.isPresent()) {
            return userCheckPhone.get();
        } else if (userCheckEmail.isPresent()) {
            return userCheckEmail.get();
        } else {
            return userRepository.save(user);
        }
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Optional<User> getUserByPhone(String phone) {
        return userRepository.findByPhone(phone);
    }

    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    public List<UserDTO> getAllUser(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);

        Page<User> listUser = userRepository.findAll(pageable);
        List<UserDTO> listUserDTO = new ArrayList<>();

        for (User user : listUser) {
            UserDTO userDTO = new UserDTO(user);
            listUserDTO.add(userDTO);
        }
        return listUserDTO;
    }

    public User updateUser(String id, User user) {
        User userUpdate = userRepository.findById(id).get();
        userUpdate.setUsername(user.getUsername());
        userUpdate.setFullName(user.getFullName());
        userUpdate.setPhoneNumber(user.getPhoneNumber());
        userUpdate.setEmail(user.getEmail());
        userUpdate.setPassword(user.getPassword());
        userUpdate.setRoleId(user.getRoleId());

        return userRepository.save(userUpdate);
    }
}