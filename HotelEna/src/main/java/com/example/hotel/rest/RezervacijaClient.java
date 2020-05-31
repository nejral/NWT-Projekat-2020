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
//soba controller
    @DeleteMapping("/rezervacija/soba/{id}")
    String deleteSoba(@PathVariable Long id);

    @PutMapping("/rezervacija/soba/{id}")
    String update(@PathVariable Long id, @RequestBody Soba soba);

    @GetMapping("/rezervacija/soba/all")
    List<SobaEntity> all();

    @PostMapping("rezervacija/soba")
    public String create(@RequestBody Soba soba);

    @GetMapping("/rezervacija/soba/{id}")
    Soba findRoomById(@PathVariable Long id);

    @PostMapping("rezervacija/sala")
    public String create(@RequestBody Sala sala);

    @GetMapping("rezervacija/sala/all")
    List<SalaEntity> allHalls();

    @PutMapping("rezervacija/sala/{id}")
    String update(@PathVariable Long id, @RequestBody Sala sala);

    @DeleteMapping("rezervacija/sala/{id}")
    String deleteSala(@PathVariable Long id);

    @GetMapping("rezervacija/sala/{id}")
    Sala findHallById(@PathVariable Long id);

}
