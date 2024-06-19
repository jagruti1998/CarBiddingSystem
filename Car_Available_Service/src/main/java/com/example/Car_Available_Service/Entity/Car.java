package com.example.Car_Available_Service.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String owner_id;
    private String car_id;
    private String carName;
    private String category_id;
    private String model;
    private int year;
    private int mileage;
    private String status;
    private double price;
}
