package com.example.patagoniatest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subject {
    private Long id;
    private double amount;
    private String type;
    private Long clientId;
}