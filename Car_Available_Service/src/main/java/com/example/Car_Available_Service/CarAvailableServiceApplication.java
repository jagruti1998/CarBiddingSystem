package com.example.Car_Available_Service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CarAvailableServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarAvailableServiceApplication.class, args);
	}

}
