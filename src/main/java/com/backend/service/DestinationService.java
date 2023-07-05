package com.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.backend.entity.Destination;
import com.backend.repository.DestinationRepository;
import com.backend.repository.TourRepository;

@Service
public class DestinationService {

    @Autowired
    private DestinationRepository destinationRepository;

    @Autowired
    private TourRepository tourRepository;
    
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

    public Destination updateDestination(String id, Destination destination) {
        Destination destinationToUpdate = destinationRepository.findById(id).get();
        destinationToUpdate.setName(destination.getName());
        destinationToUpdate.setDescription(destination.getDescription());
        destinationToUpdate.setMain_img(destination.getMain_img());
        destinationToUpdate.setLocation(destination.getLocation());
        destinationToUpdate.setImg(destination.getImg());
        return destinationRepository.save(destinationToUpdate);
    }

    public String deleteDestination(String id) {

        if(tourRepository.findByDestinationId(id).size() > 0)
            return "Destination with id " + id + " is being used by a tour! Cannot delete!";

        destinationRepository.deleteById(id);
        return "Destination with id " + id + " has been deleted!";
    }
    
}
