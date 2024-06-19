package com.example.Car_Available_Service.Exception;

import lombok.Data;

@Data
public class CustomException extends RuntimeException {

    public CustomException(String message) {
        super(message);
    }
}