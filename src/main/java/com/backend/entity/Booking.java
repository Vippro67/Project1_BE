package com.backend.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "booking")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    private String _id;
    
    private String userId;

    private String tourId;

    private String voucherId;
}
