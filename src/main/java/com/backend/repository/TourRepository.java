package com.backend.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.backend.entity.Tour;

public interface TourRepository extends MongoRepository<Tour, String> {

    @Query("{'destinationId': ?0}")
    List<Tour> findByDestinationId(String destinationId);

}
