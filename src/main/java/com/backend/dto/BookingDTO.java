package com.backend.dto;

import java.time.LocalDateTime;

import com.backend.entity.Booking;
import com.backend.entity.Tour;
import com.backend.entity.User;
import com.backend.entity.Voucher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO {
    private String _id;
    
    private String fullName;

    private String tourName;

    private LocalDateTime dateFrom;

    private LocalDateTime dateTo;

    private Double price;

    private float valueVoucher;

    public BookingDTO(Booking booking,User user, Tour tour, Voucher voucher)
    {
        this._id=booking.get_id();
        this.fullName=user.getFullName();
        this.tourName=tour.getTourName();
        this.dateFrom=tour.getDateFrom();
        this.dateTo=tour.getDateTo();
        this.price=tour.getPrice();
        this.valueVoucher=voucher.getValue();
    }

    public BookingDTO(Booking booking,User user, Tour tour)
    {
        this._id=booking.get_id();
        this.fullName=user.getFullName();
        this.tourName=tour.getTourName();
        this.dateFrom=tour.getDateFrom();
        this.dateTo=tour.getDateTo();
        this.price=tour.getPrice();
        this.valueVoucher = 0 ;
    }
}
