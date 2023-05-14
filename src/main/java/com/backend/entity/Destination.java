package com.backend.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "destination")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Destination {
    @Id
    private String _id;

    private String name;

    private String description;

    private String location;

    private String img;
}
