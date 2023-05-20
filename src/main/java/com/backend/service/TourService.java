package com.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.entity.Tour;
import com.backend.repository.TourRepository;

@Service
public class TourService {

    @Autowired
    private TourRepository tourRepository;

    @Autowired
    private DestinationService destinationService;


    public List<Tour> getAllTours() {
        return tourRepository.findAll();
    }


    public List<Tour> getToursByDestinationId(String destinationId) {
        return tourRepository.findByDestinationId(destinationId);
    }

    public Tour createTour(String destinationId, Tour tour) {
        // Check if destination exists
        destinationService.getDestinationById(destinationId);
        tour.setDestinationId(destinationId);
        return tourRepository.save(tour);
    }


    public Optional<Tour> getTourById(String tourId) {
        return tourRepository.findById(tourId);
    }

    // Other methods omitted for brevity

}
