package com.backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.backend.entity.User;

public interface UserRepository extends MongoRepository<User, String> {

    @Query("{'username': ?0}")
    User findByUsername(String username);
    
    @Query("{'email': ?0}")
    User findByEmail(String email);

}
