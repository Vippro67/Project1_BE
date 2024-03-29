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

import com.backend.dto.ReviewDTO;
import com.backend.entity.Review;
import com.backend.service.ReviewService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/v1/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping()
    public List<ReviewDTO> getAllReview(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        return reviewService.getAllReviews(page, size);
    }
    @PostMapping("/{userId}/{destinationId}")
    public Review createReview(@PathVariable String userId, @PathVariable String destinationId, @RequestBody Review review) {
        return reviewService.createReview(userId, destinationId, review);
    }

    @GetMapping("/destination/{destinationId}")
    public List<ReviewDTO> getReviewsByDestinationId(@PathVariable String destinationId) {
        return reviewService.getReviewsByDestinationId(destinationId);
    }

    @DeleteMapping("/{id}")
    public String deleteReview(@PathVariable String id) {
        return reviewService.deleteReview(id);
    }
}
