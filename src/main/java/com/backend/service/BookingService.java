package com.backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.dto.BookingDTO;
import com.backend.entity.Booking;
import com.backend.entity.Tour;
import com.backend.entity.User;
import com.backend.entity.Voucher;
import com.backend.repository.BookingRepository;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private TourService tourService;

    @Autowired
    private VoucherService voucherService;

    public List<BookingDTO> getAllBooking() {
        List<Booking> listbooking = bookingRepository.findAll();
        List<BookingDTO> listbookingDTO = new ArrayList<>();

        Optional<Tour> tour;
        Optional<User> user;
        Optional<Voucher> voucher;

        for (Booking booking : listbooking) {
            user = userService.getUserById(booking.getUserId());
            tour = tourService.getTourById(booking.getTourId());
            voucher = voucherService.getVoucherById(booking.getVoucherId());
            if (user.isPresent() && tour.isPresent()) {
                if (voucher.isPresent()) {
                    BookingDTO bookingDTO = new BookingDTO(booking, user.get(), tour.get(), voucher.get());
                    listbookingDTO.add(bookingDTO);
                } else {
                    BookingDTO bookingDTO = new BookingDTO(booking, user.get(), tour.get());
                    listbookingDTO.add(bookingDTO);
                }
            }
        }
        return listbookingDTO;
    }

    public Booking createBooking(String userId, String tourId, Booking booking) {
        
        booking.setUserId(userId);
        booking.setTourId(tourId);
        return bookingRepository.save(booking);
    }

    public List<BookingDTO> getBookingsByUserId(String userId) {
        List<Booking> listbooking = bookingRepository.findByUserId(userId);
        List<BookingDTO> listbookingDTO = new ArrayList<>();

        Optional<Tour> tour;
        Optional<User> user;
        Optional<Voucher> voucher;

        for (Booking booking : listbooking) {
            user = userService.getUserById(booking.getUserId());
            tour = tourService.getTourById(booking.getTourId());
            voucher = voucherService.getVoucherById(booking.getVoucherId());
            if (user.isPresent() && tour.isPresent()) {
                if (voucher.isPresent()) {
                    BookingDTO bookingDTO = new BookingDTO(booking, user.get(), tour.get(), voucher.get());
                    listbookingDTO.add(bookingDTO);
                } else {
                    BookingDTO bookingDTO = new BookingDTO(booking, user.get(), tour.get());
                    listbookingDTO.add(bookingDTO);
                }
            }
        }
        return listbookingDTO;    
    }
    public List<BookingDTO> getBookingsByTourId(String tourId) {
        List<Booking> listbooking = bookingRepository.findByTourId(tourId);
        List<BookingDTO> listbookingDTO = new ArrayList<>();

        Optional<Tour> tour;
        Optional<User> user;
        Optional<Voucher> voucher;

        for (Booking booking : listbooking) {
            user = userService.getUserById(booking.getUserId());
            tour = tourService.getTourById(booking.getTourId());
            voucher = voucherService.getVoucherById(booking.getVoucherId());
            if (user.isPresent() && tour.isPresent()) {
                if (voucher.isPresent()) {
                    BookingDTO bookingDTO = new BookingDTO(booking, user.get(), tour.get(), voucher.get());
                    listbookingDTO.add(bookingDTO);
                } else {
                    BookingDTO bookingDTO = new BookingDTO(booking, user.get(), tour.get());
                    listbookingDTO.add(bookingDTO);
                }
            }
        }
        return listbookingDTO;    
    }
}
