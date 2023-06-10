package com.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.entity.Destination;
import com.backend.service.DestinationService;

@RestController
@RequestMapping("api/v1//destinations")
public class DestinationController {

    @Autowired
    private DestinationService destinationService;

    @GetMapping
    public List<Destination> getAllDestinations() {
        return destinationService.getAllDestinations();
    }

    @GetMapping("/{id}")
    public Optional<Destination> getDestinationById(@PathVariable String id) {
        return destinationService.getDestinationById(id);
    }

    @PostMapping
    public Destination createDestination(@RequestBody Destination destination) {
        return destinationService.createDestination(destination);
    }

}
