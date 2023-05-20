package com.backend.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "blog")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    @Id
    private String _id;

    private String title;

    private String content;

    private String tag;

    private LocalDateTime createdAt;

}
