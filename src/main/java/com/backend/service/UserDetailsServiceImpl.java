package com.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.backend.dto.CreateUserReq;
import com.backend.repository.RoleRepository;
import com.backend.repository.UserRepository;
import com.backend.security.JwtProvider;

import java.util.ArrayList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Find user by username
        com.backend.entity.User appUser = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username + " not found."));

        var authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(roleRepository.findById(appUser.getRoleId()).get().getName()));

        return new User(appUser.getUsername(), appUser.getPassword(), authorities);
    }

    public String createUser(CreateUserReq req) throws Exception {
        // Extract parameters from request
        String username = req.getUsername();
        String password = req.getPassword();
        String userRole = req.getUserRole();

        // Check whether username exists or not
        boolean isExists = userRepository.existsByUsername(username);

        if (isExists) {
            return ("User already exists.");
        }

        // Create new user
        long maxId = userRepository.count();
        while (userRepository.findById(String.valueOf(maxId)).isPresent()) {
            maxId++;
        }

        // Create new user
        com.backend.entity.User user = new com.backend.entity.User();
        user.set_id(String.valueOf(maxId)); // Set new ID as max ID + 1 or 1 if no existing users
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRoleId(roleRepository.findByRoleName(userRole).get().get_id());

        // Save user
        userRepository.save(user);
        return jwtProvider.generateToken(user.getUsername());
    }
}
