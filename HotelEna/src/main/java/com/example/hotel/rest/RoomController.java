package com.example.hotel.rest;

import com.example.hotel.dto.*;
import lombok.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@AllArgsConstructor
@RestController
@RequestMapping("/user/reservation/room")
public class RoomController {
    private ReservationClient reservationClient;

    @DeleteMapping("/{id}")
    String delete(@PathVariable Long id){
        return reservationClient.deleteRoom(id);
    }

    @PutMapping("/{id}")
    String update(@PathVariable Long id, @RequestBody Room room){
        return reservationClient.update(id, room);
    }

    @GetMapping("/all")
    List<RoomEntity> allRooms(){
        return reservationClient.all();
    }

    @PostMapping()
    public String create(@RequestBody Room room){
        return reservationClient.create(room);
    }
    @GetMapping("/{id}")
    Room findRoomById(@PathVariable Long id) {
        return reservationClient.findRoomById(id);
    }
}
