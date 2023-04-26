package com.backend.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.backend.entity.Tour;

public interface TourRepository extends MongoRepository<Tour, String> {

    List<Tour> findByDestinationId(String destinationId);

}
