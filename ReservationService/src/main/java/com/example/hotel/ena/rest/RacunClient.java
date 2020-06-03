package com.example.hotel.ena.rest;

import com.example.hotel.ena.dto.Bill;
import com.example.hotel.ena.dto.BillReservationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

//@AllArgsConstructor
@FeignClient("billing")
public interface RacunClient {

    @GetMapping("/bill/{reservationId}")
    Bill reservationRacun(@PathVariable("reservationId") Long reservationId);

    @GetMapping("/bill/{reservationId}")
    Bill reservationCreateRacun(@PathVariable("reservationId") Long reservationId);

    @PostMapping("/bill/reservation/create/bill")
    String newRacunReservation(@RequestBody BillReservationRequest noviRacun);

}