package com.example.hotel.ena.rest;

import com.example.hotel.ena.dto.Rezervacija;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("rezervacija")
public interface RezervacijaClient {

    @GetMapping("/rezervacija/allByUserId/{id}")
    List<Rezervacija> allByUserId(@PathVariable Long id);

    @GetMapping("/rezervacija/allByCreatedBy/{id}")
    List<Rezervacija> allByCreatedBy(@PathVariable Long id);


}
