package com.example.Car_Available_Service.utils;

import lombok.Data;

@Data
public class BaseResponse<T> {
    private boolean success = true;
    private String userMessage = "";
    private T data;
}
