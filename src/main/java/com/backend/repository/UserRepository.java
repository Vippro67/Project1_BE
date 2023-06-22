package com.backend.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.backend.entity.User;

public interface UserRepository extends MongoRepository<User, String> {

    @Query("{'username': ?0}")
    Optional<User> findByUsername(String username);

    @Query("{'email': ?0}")
    Optional<User> findByEmail(String email);

    @Query(value = "{'username' : ?0 }", exists = true)
    boolean existsByUsername(String username);

    @Query(value = "{$group: {_id: null, maxId: {$max: '$id'}}}")
    Integer findMaxId();
}
