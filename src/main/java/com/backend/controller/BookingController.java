package com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.dto.BookingDTO;
import com.backend.entity.Booking;
import com.backend.service.BookingService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/v1/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping()
    public List<BookingDTO> getAllBooking(@RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        return bookingService.getAllBooking(page, size);
    }

    @PostMapping()
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.createBooking(booking.getUserId(), booking.getTourId(), booking.getVoucherId());
    }

    @GetMapping("/user/{userId}")
    public List<BookingDTO> getBookingsByUserId(@PathVariable String userId) {
        return bookingService.getBookingsByUserId(userId);
    }

    @GetMapping("/tour/{tourId}")
    public List<BookingDTO> getBookingsByTourId(@PathVariable String tourId) {
        return bookingService.getBookingsByUserId(tourId);
    }
    @GetMapping("/{id}")
    public BookingDTO getBookingById(@PathVariable String id) {
        return bookingService.getBookingDTOById(id);
    }

    @PutMapping("/{id}")
    public Booking updateBooking(@PathVariable String id, @RequestBody String status) {
        return bookingService.updateBooking(id, status);
    }

}
