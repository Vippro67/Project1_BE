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
import com.backend.entity.Destination;
import com.backend.entity.Tour;
import com.backend.repository.BookingRepository;
import com.backend.repository.TourRepository;

@Service
public class TourService {

    @Autowired
    private TourRepository tourRepository;

    @Autowired
    private DestinationService destinationService;

    @Autowired
    private BookingRepository bookingRepository;

    public List<TourDTO> getAllTours(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<Tour> listTour = tourRepository.findAll(pageable);
        List<TourDTO> listTourDTO = new ArrayList<>();

        Optional<Destination> destination;

        for (Tour tour : listTour) {
            destination = destinationService.getDestinationById(tour.getDestinationId());
            if (destination.isPresent()) {
                TourDTO tourDTO = new TourDTO(tour, destination.get());
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

    public TourDTO getTourDTOById(String tourId) {
        Optional<Tour> tour = tourRepository.findById(tourId);
        Optional<Destination> destination = destinationService.getDestinationById(tour.get().getDestinationId());
        TourDTO tourDTO = new TourDTO(tour.get(), destination.get());
        return tourDTO;
    }
    // Other methods omitted for brevity

    public Tour updateTour(String id, Tour tour) {
        Tour tourToUpdate = tourRepository.findById(id).get();
        tourToUpdate.setDestinationId(tour.getDestinationId());
        tourToUpdate.setTourName(tour.getTourName());
        tourToUpdate.setDateFrom(tour.getDateFrom());
        tourToUpdate.setDateTo(tour.getDateTo());
        tourToUpdate.setPrice(tour.getPrice());
        tourToUpdate.setSchedule(tour.getSchedule());
        return tourRepository.save(tourToUpdate);
    }

    public String deleteTour(String id) {
        if (bookingRepository.findByTourId(id).size() > 0)
            throw new RuntimeException("Tour with id " + id + " is being booked by some users");

        tourRepository.deleteById(id);
        return "Tour with id " + id + " has been deleted successfully";
    }

}
