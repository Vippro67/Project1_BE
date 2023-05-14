package com.backend.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.backend.entity.Role;

public interface RoleRepository extends MongoRepository<Role,String>{

    
    
}
