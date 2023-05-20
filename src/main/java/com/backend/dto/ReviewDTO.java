package com.backend.dto;

import java.time.LocalDateTime;

import com.backend.entity.Review;
import com.backend.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {
    private String _id;

    private String fullName;

    private float rating;

    private String comment;

    private LocalDateTime createdAt;

    public ReviewDTO(Review review, User user)
    {
        this._id=review.get_id();
        this.fullName=user.getFullName();
        this.rating=review.getRating();
        this.comment=review.getComment();
        this.createdAt=review.getCreatedAt();
    }
}
