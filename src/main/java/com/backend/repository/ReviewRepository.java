package com.backend.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.backend.entity.Review;

public interface ReviewRepository extends MongoRepository<Review,String>{

    @Query("{'destinationId': ?0}")
    List<Review> findByDestinationId(String destinationId);
    
}
