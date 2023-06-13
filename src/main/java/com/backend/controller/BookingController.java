package com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.dto.BookingDTO;
import com.backend.entity.Booking;
import com.backend.service.BookingService;

@RestController
@RequestMapping("api/v1/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping()
    public List<BookingDTO> getAllBooking(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        return bookingService.getAllBooking(page, size);
    }

    @PostMapping("/{userId}/{tourId}")
    public Booking createBooking(@PathVariable String userId, @PathVariable String tourId, @RequestBody Booking booking) {
        return bookingService.createBooking(userId, tourId, booking);
    }

    @GetMapping("/user/{userId}")
    public List<BookingDTO> getBookingsByUserId(@PathVariable String userId) {
        return bookingService.getBookingsByUserId(userId);
    }

    @GetMapping("/tour/{tourId}")
    public List<BookingDTO> getBookingsByTourId(@PathVariable String tourId) {
        return bookingService.getBookingsByUserId(tourId);
    }

}
