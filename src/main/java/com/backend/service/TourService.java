package com.backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.backend.dto.TourDTO;
import com.backend.entity.Blog;
import com.backend.entity.Destination;
import com.backend.entity.Tour;
import com.backend.repository.TourRepository;

@Service
public class TourService {

    @Autowired
    private TourRepository tourRepository;

    @Autowired
    private DestinationService destinationService;


    public List<TourDTO> getAllTours(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<Tour> listTour = tourRepository.findAll(pageable);
        List<TourDTO> listTourDTO = new ArrayList<>();

        Optional<Destination> destination ;

        for (Tour tour : listTour) {
            destination = destinationService.getDestinationById(tour.getDestinationId());
            if(destination.isPresent())
            {
                TourDTO tourDTO = new TourDTO(tour,destination.get());
                listTourDTO.add(tourDTO);
            }
        }
        return listTourDTO;
    }


    public List<Tour> getToursByDestinationId(String destinationId) {
        return tourRepository.findByDestinationId(destinationId);
    }

    public Tour createTour(Tour tour) {
        // Check if destination exists
        return tourRepository.save(tour);
    }


    public Optional<Tour> getTourById(String tourId) {
        return tourRepository.findById(tourId);
    }

    // Other methods omitted for brevity

}
