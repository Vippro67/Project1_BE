package com.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.entity.Destination;
import com.backend.service.DestinationService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/v1/destinations")
public class DestinationController {

    @Autowired
    private DestinationService destinationService;

    @GetMapping
    public List<Destination> getAllDestinations(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "6") int size) {
        return destinationService.getAllDestinations(page, size);
    }

    @GetMapping("/{id}")
    public Optional<Destination> getDestinationById(@PathVariable String id) {
        return destinationService.getDestinationById(id);
    }

    @PostMapping
    public Destination createDestination(@RequestBody Destination destination) {
        return destinationService.createDestination(destination);
    }

    @PutMapping("/{id}")
    public Destination updateDestination(@PathVariable String id, @RequestBody Destination destination) {
        return destinationService.updateDestination(id, destination);
    }

    @DeleteMapping("/{id}")
    public String deleteDestination(@PathVariable String id) {
         return destinationService.deleteDestination(id);
    }

}
