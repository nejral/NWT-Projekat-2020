package com.example.hotel.ena.rest;

import com.example.hotel.ena.dto.Racun;
import com.example.hotel.ena.dto.RacunReservationRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

//@AllArgsConstructor
@FeignClient("racun")
public interface RacunClient {

    @GetMapping("/racun/{reservationId}")
    Racun reservationRacun(@PathVariable("reservationId") Long reservationId);

    @GetMapping("/racun/{reservationId}")
    Racun reservationCreateRacun(@PathVariable("reservationId") Long reservationId);



/*
    @GetMapping("/racun/reservationRacun/{reservationId}")
    Racun reservationRacun(@PathVariable Long reservationId);*/
/*
    @GetMapping("racun/{userId}")
    Racun findByUserId(@PathVariable Long userId);

    @PostMapping("/reservation")
    String newRacunReservation(@RequestBody RacunReservationRequest noviRacun);

    @GetMapping("/reservation/{reservationId}")
    Racun reservationRacun(@PathVariable Long reservationId);
*/
    /*@GetMapping("racun/{reservationId}/racun")
    Racun findByReservationId(@PathVariable Long reservationId);*/
}