package com.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.entity.Destination;
import com.backend.repository.DestinationRepository;

@Service
public class DestinationService {

    @Autowired
    private DestinationRepository destinationRepository;
    
    public Optional<Destination> getDestinationById(String destinationId) {
        
        return destinationRepository.findById(destinationId);
    }

    public List<Destination> getAllDestinations() {
        return destinationRepository.findAll();
    }

    public Destination createDestination(Destination destination) {
        return destinationRepository.save(destination);
    }
    
}
