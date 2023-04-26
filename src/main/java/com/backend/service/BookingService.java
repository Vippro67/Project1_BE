package com.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.entity.Booking;
import com.backend.repository.BookingRepository;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private TourService tourService;

    public Booking createBooking(String userId, String tourId, Booking booking) {
        // Check if user and tour exist
        userService.getUserById(userId);
        tourService.getTourById(tourId);
        booking.setUserId(userId);
        booking.setTourId(tourId);
        return bookingRepository.save(booking);
    }

    public List<Booking> getBookingsByUserId(String userId) {
        return bookingRepository.findByUserId(userId);
    }

    public List<Booking> getBookingsByTourId(String tourId) {
        return bookingRepository.findByTourId(tourId);
    }

}
