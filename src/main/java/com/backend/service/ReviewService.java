package com.backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.backend.dto.ReviewDTO;
import com.backend.entity.Review;
import com.backend.entity.User;
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

    public List<ReviewDTO> getAllReviews(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<Review> listReview = reviewRepository.findAll(pageable);
        List<ReviewDTO> listReviewDTO = new ArrayList<>();

        Optional<User> user ;

        for (Review review : listReview) {
            user = userService.getUserById(review.getUserId());
            if(user.isPresent())
            {
                ReviewDTO reviewDTO = new ReviewDTO(review,user.get());
                listReviewDTO.add(reviewDTO);
            }
        }
        return listReviewDTO;
    }

    public List<ReviewDTO> getReviewsByDestinationId(String destinationId) {
        List<Review> listReview = reviewRepository.findByDestinationId(destinationId);
        List<ReviewDTO> listReviewDTO = new ArrayList<>();
        Optional<User> user ;
        for (Review review : listReview) {
            user = userService.getUserById(review.getUserId());
            if(user.isPresent())
            {
                ReviewDTO reviewDTO = new ReviewDTO(review,user.get());
                listReviewDTO.add(reviewDTO);
            }
        }
        return listReviewDTO;
    }  
}
