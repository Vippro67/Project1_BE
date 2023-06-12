package com.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.backend.entity.Blog;
import com.backend.entity.Destination;
import com.backend.repository.DestinationRepository;

@Service
public class DestinationService {

    @Autowired
    private DestinationRepository destinationRepository;
    
    public Optional<Destination> getDestinationById(String destinationId) {
        
        return destinationRepository.findById(destinationId);
    }

    public List<Destination> getAllDestinations(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<Destination> destinationPage = destinationRepository.findAll(pageable);
        return destinationPage.getContent();
    }

    public Destination createDestination(Destination destination) {
        return destinationRepository.save(destination);
    }
    
}
