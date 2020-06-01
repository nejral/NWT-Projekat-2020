package com.example.hotel.rest;

import com.example.hotel.dto.*;
import lombok.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@AllArgsConstructor
@RestController
@RequestMapping("/user/reservation/hall")
public class HallController {

    private ReservationClient reservationClient;

    @PostMapping()
    public String create(@RequestBody Hall hall){
        return reservationClient.create(hall);
    }

    @GetMapping("/all")
    List<HallEntity> allHalls(){
        return reservationClient.allHalls();
    }

    @PutMapping("/{id}")
    String update(@PathVariable Long id, @RequestBody Hall hall){
        return reservationClient.update(id, hall);
    }

    @DeleteMapping("/{id}")
    String delete(@PathVariable Long id){
        return reservationClient.deleteHall(id);
    }

    @GetMapping("/{id}")
    Hall findHallById(@PathVariable Long id){
        return reservationClient.findHallById(id);
    }
}
