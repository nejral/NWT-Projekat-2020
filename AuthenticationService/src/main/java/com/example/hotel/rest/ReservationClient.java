package com.example.hotel.rest;

import com.example.hotel.dto.*;
import org.springframework.cloud.openfeign.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@FeignClient("reservation")
public interface ReservationClient {
    @GetMapping("reservation/all")
    List<ReservationEntity> allReservations();

    @GetMapping("/reservation/allByUserId/{id}")
    List<Reservation> allByUserId(@PathVariable Long id);

    @GetMapping("/reservation/allByCreatedBy/{id}")
    List<Reservation> allByCreatedBy(@PathVariable Long id);

    @PostMapping("/reservation")
     String create(@RequestBody ReservationCreateRequest rezervacija);

    @DeleteMapping("/reservation/{id}")
    String delete(@PathVariable Long id);

    @GetMapping("/reservation/find/{id}")
    Reservation findById(@PathVariable Long id);

    @PutMapping("/reservation/{id}")
    String update(@PathVariable Long id, @RequestBody Reservation rezervacija);
//room controller
    @DeleteMapping("/reservation/room/{id}")
    String deleteRoom(@PathVariable Long id);

    @PutMapping("/reservation/room/{id}")
    String update(@PathVariable Long id, @RequestBody Room room);

    @GetMapping("/reservation/room/all")
    List<RoomEntity> all();

    @PostMapping("reservation/room")
    public String create(@RequestBody Room room);

    @GetMapping("/reservation/room/{id}")
    Room findRoomById(@PathVariable Long id);

    @PostMapping("reservation/hall")
    public String create(@RequestBody Hall hall);

    @GetMapping("reservation/hall/all")
    List<HallEntity> allHalls();

    @PutMapping("reservation/hall/{id}")
    String update(@PathVariable Long id, @RequestBody Hall hall);

    @DeleteMapping("reservation/hall/{id}")
    String deleteHall(@PathVariable Long id);

    @GetMapping("reservation/hall/{id}")
    Hall findHallById(@PathVariable Long id);

}
