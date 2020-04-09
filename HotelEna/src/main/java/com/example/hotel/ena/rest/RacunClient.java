package com.example.hotel.ena.rest;

import com.example.hotel.ena.dto.Racun;
import com.example.hotel.ena.dto.RacunReservationRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("racun")
public interface RacunClient {

    @GetMapping("racun/{userId}")
    Racun findByUserId(@PathVariable Long userId);

    @PostMapping("/reservation")
    String newRacunReservation(@RequestBody RacunReservationRequest noviRacun);

    @GetMapping("/reservation/{reservationId}")
    Racun reservationRacun(@PathVariable Long reservationId);


}