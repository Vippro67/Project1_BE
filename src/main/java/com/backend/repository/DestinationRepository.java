package com.backend.repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.backend.entity.Destination;

public interface DestinationRepository extends MongoRepository<Destination, String> {

}