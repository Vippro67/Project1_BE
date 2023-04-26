package com.backend.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.backend.entity.Review;

public interface ReviewRepository extends MongoRepository<Review,String>{

    List<Review> findByDestinationId(String destinationId);
    
}
