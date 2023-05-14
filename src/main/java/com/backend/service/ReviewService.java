package com.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.entity.Review;
import com.backend.repository.ReviewRepository;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private DestinationService destinationService;

    
    public Review createReview(String userId, String destinationId, Review review) {
        // Check if user and destination exist
        userService.getUserById(userId);
        destinationService.getDestinationById(destinationId);
        review.setUserId(userId);
        review.setDestinationId(destinationId);
        return reviewRepository.save(review);
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public List<Review> getReviewsByDestinationId(String destinationId) {
        return reviewRepository.findByDestinationId(destinationId);
    }  
}
