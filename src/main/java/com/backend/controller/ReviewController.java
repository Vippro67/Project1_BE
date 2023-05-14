package com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.entity.Review;
import com.backend.service.ReviewService;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping()
    public List<Review> getAllReview() {
        return reviewService.getAllReviews();
    }
    @PostMapping("/{userId}/{destinationId}")
    public Review createReview(@PathVariable String userId, @PathVariable String destinationId, @RequestBody Review review) {
        return reviewService.createReview(userId, destinationId, review);
    }

    @GetMapping("/destination/{destinationId}")
    public List<Review> getReviewsByDestinationId(@PathVariable String destinationId) {
        return reviewService.getReviewsByDestinationId(destinationId);
    }

}
