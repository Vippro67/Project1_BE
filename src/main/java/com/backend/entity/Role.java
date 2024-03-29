package com.backend.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Document(collection = "role")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    @Id
    private String _id;

    private String name;

}
