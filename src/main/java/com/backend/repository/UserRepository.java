package com.backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.backend.entity.User;

public interface UserRepository extends MongoRepository<User, String> {

    User findByUsername(String username);

    User findByEmail(String email);

}
