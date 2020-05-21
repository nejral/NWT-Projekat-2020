package com.example.hotel.rest;

import com.example.hotel.dto.*;
import org.springframework.cloud.openfeign.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@FeignClient("rezervacija")
public interface RezervacijaClient {

    @GetMapping("/rezervacija/allByUserId/{id}")
    Rezervacija allByUserId(@PathVariable Long id);

    @GetMapping("/rezervacija/allByCreatedBy/{id}")
    List<Rezervacija> allByCreatedBy(@PathVariable Long id);

    @PostMapping("/rezervacija")
    public String create(@RequestBody Rezervacija rezervacija);
}
