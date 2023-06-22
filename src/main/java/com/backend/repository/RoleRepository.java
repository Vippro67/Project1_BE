package com.backend.repository;


import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.backend.entity.Role;

public interface RoleRepository extends MongoRepository<Role,String>{

    @Query("{'name': ?0}")
    Optional <Role> findByRoleName(String roleName);
    
}
