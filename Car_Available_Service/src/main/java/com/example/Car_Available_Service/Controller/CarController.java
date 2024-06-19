package com.example.Car_Available_Service.Controller;

import com.example.Car_Available_Service.Entity.Car;
import com.example.Car_Available_Service.Service.CarService;
import com.example.Car_Available_Service.utils.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Car")
public class CarController {
    @Autowired
    CarService carService;
    @PostMapping("/addCar")
    public BaseResponse addCar(@RequestBody Car car) {
        BaseResponse response = new BaseResponse();
        try {
            return carService.addCar(car);
        } catch (Exception e) {
            response.setSuccess(false);
            response.setUserMessage("Car Registration failed: " + e.getMessage());
        }
        return response;
    }
    @GetMapping("/allCars")
    public BaseResponse<List<Car>> getAllCar(){
        BaseResponse response = new BaseResponse();
        try {
            return carService.getAllCars();
        } catch (Exception e) {
            response.setSuccess(false);
            response.setUserMessage("Car fetching failed: " + e.getMessage());
        }
        return response;
    }

    @GetMapping("/getCarById/{id}")
    public ResponseEntity<BaseResponse<Car>> getCarById(@PathVariable String id){
        BaseResponse<Car> response = carService.getCarById(id);
        if (response.getData() != null) {
            return ResponseEntity.ok(response); // User found
        } else {
            response.setSuccess(true);
            response.setUserMessage("User not found with id: " + id);
            return ResponseEntity.status(Integer.parseInt("Not Found")).body(response);
        }
    }
    @DeleteMapping("/deleteCarbyId/{id}")
    public ResponseEntity<BaseResponse<Car>> deleteCarById(@PathVariable String id) {
        BaseResponse<Car> response = carService.deleteCarById(id);
        if (response.getData() != null) {
            return ResponseEntity.ok(response); // Car found and deleted
        } else {
            response.setSuccess(false);
            response.setUserMessage("Car not found with id: " + id);
            return ResponseEntity.status(404).body(response);
        }
    }
}
