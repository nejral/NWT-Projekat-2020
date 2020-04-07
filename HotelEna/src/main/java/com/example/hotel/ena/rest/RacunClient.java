package com.example.hotel.ena.rest;

import com.example.hotel.ena.dto.Racun;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("racun")
public interface RacunClient {

    @GetMapping("racun/{userId}")
    Racun findByUserId(@PathVariable Long userId);
}