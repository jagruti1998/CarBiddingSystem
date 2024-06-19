package com.example.Car_Available_Service.Service;

import com.example.Car_Available_Service.Entity.Car;
import com.example.Car_Available_Service.Repository.CarRepo;
import com.example.Car_Available_Service.utils.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    CarRepo carRepo;
    public BaseResponse addCar(Car car) {
        BaseResponse response = new BaseResponse();
        try {
            Car existingCar = carRepo.findByCarId(car.getCar_id());
            if (existingCar != null) {
                response.setSuccess(false);
                response.setUserMessage("Car already exists");
            } else {
                carRepo.save(car);
                response.setSuccess(true);
                response.setData(car);
                response.setUserMessage("Car registered successfully");
            }
        } catch (Exception e) {
            response.setSuccess(false);
            response.setUserMessage("Registration failed: " + e.getMessage());
        }
        return response;
    }

    public BaseResponse<List<Car>> getAllCars() {
        BaseResponse response = new BaseResponse();
        try {
            List<Car> listCar = carRepo.findAllCars();
            response.setSuccess(true);
            if (listCar.isEmpty()) {
                response.setUserMessage("No Cars Available");
            } else {
                response.setData(listCar);
                response.setUserMessage("List of Cars");
            }
        } catch (Exception e) {
            response.setSuccess(false);
            response.setUserMessage("Car Fetching failed: " + e.getMessage());
        }
        return response;
    }

    public BaseResponse<Car> getCarById(String id) {
        BaseResponse<Car> response = new BaseResponse<>();
        Car car = carRepo.findByCarId(id);
        if (car != null) {
            response.setSuccess(true);
            response.setData(car);
            response.setUserMessage("Car with id = " + id + " found");
        } else {
            response.setSuccess(false);
            response.setUserMessage("Car not found with id: " + id);
            response.setData(null);  // Set data to null explicitly
        }
        return response;
    }

    public BaseResponse<Car> deleteCarById(String id) {
        BaseResponse<Car> response = new BaseResponse<>();
        Car car = carRepo.findByCarId(id);
        if (car != null) {
            carRepo.deleteCarById(id);
            response.setSuccess(true);
            response.setData(car);
            response.setUserMessage("Car with id = " + id + " deleted Successfully");
        } else {
            response.setSuccess(false);
            response.setUserMessage("Car not found with id: " + id);
            response.setData(null);  // Set data to null explicitly
        }
        return response;
    }
}
