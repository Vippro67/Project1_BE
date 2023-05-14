package com.backend.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Document(collection = "voucher")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Voucher {

    @Id
    private String _id;

    private int number;
    
    private float value;
    
    private LocalDateTime start;
    
    private LocalDateTime end;

}
