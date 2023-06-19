package com.backend.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "tour")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tour {
    @Id
    private String _id;

    private String tourName;

    private String destinationId;

    private LocalDateTime dateFrom;

    private LocalDateTime dateTo;

    private String schedule;

    private Double price;

}
