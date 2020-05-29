package com.example.hotel.rest;

import com.example.hotel.dto.*;
import org.springframework.cloud.openfeign.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@FeignClient("rezervacija")
public interface RezervacijaClient {

    @GetMapping("/rezervacija/allByUserId/{id}")
    List<Rezervacija> allByUserId(@PathVariable Long id);

    @GetMapping("/rezervacija/allByCreatedBy/{id}")
    List<Rezervacija> allByCreatedBy(@PathVariable Long id);

    @PostMapping("/rezervacija")
    public String create(@RequestBody Rezervacija rezervacija);

    @DeleteMapping("/rezervacija/{id}")
    String deleteRezervacija(@PathVariable Long id);

    @GetMapping("/rezervacija/find/{id}")
    Rezervacija findById(@PathVariable Long id);

    @PutMapping("/rezervacija/{id}")
    String update(@PathVariable Long id, @RequestBody Rezervacija rezervacija);
}
