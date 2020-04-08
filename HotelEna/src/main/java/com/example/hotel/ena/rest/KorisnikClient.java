package com.example.hotel.ena.rest;

import com.example.hotel.ena.dto.Racun;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("racun")
public interface RacunClient {

    @GetMapping("racun/{userId}")
    Racun findByUserId(@PathVariable Long userId);


}