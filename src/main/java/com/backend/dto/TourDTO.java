package com.backend.dto;

import java.time.LocalDateTime;

import com.backend.entity.Destination;
import com.backend.entity.Tour;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TourDTO {
    private String _id;

    private String tourName;

    private String destination;

    private LocalDateTime dateFrom;

    private LocalDateTime dateTo;

    private String schedule;

    private Double price;

    public TourDTO(Tour tour,Destination destination)
    {
        this._id = tour.get_id();
        this.tourName = tour.getTourName();
        this.destination = destination.getName();
        this.dateFrom = tour.getDateFrom();
        this.dateTo = tour.getDateTo();
        this.schedule = tour.getSchedule();
        this.price = tour.getPrice();
    }

}
