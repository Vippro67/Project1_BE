package com.backend.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.backend.entity.Booking;

public interface BookingRepository extends MongoRepository<Booking, String> {

    @Query("{'userId': ?0}")
    List<Booking> findByUserId(String userId);

    @Query("{'tourId': ?0}")
    List<Booking> findByTourId(String tourId);

    @Query("{'voucherId': ?0}")
    List<Booking> findByVoucherId(String voucherId);

}
