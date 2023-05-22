package com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.dto.TourDTO;
import com.backend.entity.Tour;
import com.backend.service.TourService;

@RestController
@RequestMapping("/tours")
public class TourController {

    @Autowired
    private TourService tourService;

    @GetMapping()
    public List<TourDTO> getAllTours() {
        return tourService.getAllTours();
    }

    @GetMapping("/destination/{destinationId}")
    public List<Tour> getToursByDestinationId(@PathVariable String destinationId) {
        return tourService.getToursByDestinationId(destinationId);
    }

    @PostMapping("/destination/{destinationId}")
    public Tour createTour(@PathVariable String destinationId, @RequestBody Tour tour) {
        return tourService.createTour(destinationId, tour);
    }
}
