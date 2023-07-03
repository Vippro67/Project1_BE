package com.backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    public List<BookingDTO> getAllBooking(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<Booking> listbooking = bookingRepository.findAll(pageable);
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

    public Booking createBooking(String userId, String tourId, String voucherId) {
        Booking booking = new Booking();
        booking.setUserId(userId);
        booking.setTourId(tourId);
        if (voucherId == null) {
            voucherId = "";
        }
        booking.setVoucherId(voucherId);
        booking.setStatus("Pending");
        return bookingRepository.save(booking);
    }
    public Booking updateBooking(String bookingId, String status) {
        Optional<Booking> booking = bookingRepository.findById(bookingId);
        if (booking.isPresent()) {
            booking.get().setStatus(status);
            return bookingRepository.save(booking.get());
        }
        return null;
    }
    public BookingDTO getBookingDTOById(String bookingId)
    {
        Optional<Booking> booking = bookingRepository.findById(bookingId);
        if(!booking.isPresent()) {
            return null;
        }
        else
        {
            Optional<Tour> tour = tourService.getTourById(booking.get().getTourId());
            Optional<User> user = userService.getUserById(booking.get().getUserId());
            if(booking.get().getVoucherId() == null) {
                booking.get().setVoucherId("");
            }
            Optional<Voucher> voucher = voucherService.getVoucherById(booking.get().getVoucherId());
            if (user.isPresent() && tour.isPresent()) {
                if (voucher.isPresent()) {
                    BookingDTO bookingDTO = new BookingDTO(booking.get(), user.get(), tour.get(), voucher.get());
                    return bookingDTO;
                } else {
                    BookingDTO bookingDTO = new BookingDTO(booking.get(), user.get(), tour.get());
                    return bookingDTO;
                }
            }
            return null;
        }
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
