package com.example.hotel.ena;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@EnableEurekaServer
@SpringBootApplication
public class HotelEnaApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelEnaApplication.class, args);
    }
}
