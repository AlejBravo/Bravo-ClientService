package com.example.patagoniatest.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "client")
public class Client {
    @Id
    private Long id;
    private String fullName;
    private Integer income;

}
