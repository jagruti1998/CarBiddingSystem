package com.example.Car_Available_Service.Repository;

import com.example.Car_Available_Service.Entity.Car;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepo extends JpaRepository<Car,Long> {
    @Query("SELECT u FROM Car u WHERE u.car_id = :carId")
    Car findByCarId(String carId);

    @Query("SELECT c FROM Car c")
    List<Car> findAllCars();

    @Modifying
    @Transactional
    @Query("DELETE FROM Car WHERE car_id = :id")
    void deleteCarById(String id);
}
