package com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.dto.TourDTO;
import com.backend.entity.Tour;
import com.backend.service.TourService;
import org.springframework.web.bind.annotation.PutMapping;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/v1/tours")
public class TourController {

    @Autowired
    private TourService tourService;

    @GetMapping()
    public List<TourDTO> getAllTours(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        return tourService.getAllTours(page, size);
    }

    @GetMapping("/{id}")
    public TourDTO getTourById(@PathVariable String id) {
        return tourService.getTourDTOById(id);
    }

    @GetMapping("/destination/{destinationId}")
    public List<Tour> getToursByDestinationId(@PathVariable String destinationId) {
        return tourService.getToursByDestinationId(destinationId);
    }

    @PostMapping()
    public Tour createTour(@RequestBody Tour tour) {
        return tourService.createTour(tour);
    }

    @PutMapping("/{id}")
    public Tour updateTour(@PathVariable String id, @RequestBody Tour tour) {
        return tourService.updateTour(id, tour);
    }

    @DeleteMapping("/{id}")
    public String deleteTour(@PathVariable String id) {
        return tourService.deleteTour(id);
    }
}
