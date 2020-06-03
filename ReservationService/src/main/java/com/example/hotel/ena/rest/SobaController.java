package com.example.hotel.ena.rest;

import com.example.hotel.ena.dto.*;
import com.example.hotel.ena.models.*;
import com.example.hotel.ena.repository.*;
import lombok.*;
import org.springframework.beans.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@AllArgsConstructor
@RestController
@RequestMapping("/reservation/room")
public class SobaController {
SobaRepository sobaRepository;
    @PostMapping()
    public String create(@RequestBody Room room) {

            RoomEntity roomEntity = new RoomEntity();
            BeanUtils.copyProperties(room, roomEntity);
            roomEntity.setNumberOfBeds(room.getNumOfBeds());
            sobaRepository.save(roomEntity);
            return "Successfully created!";
        }


    @GetMapping("/all")
    List<RoomEntity> all() {
        return sobaRepository.findAll();
    }
    @PutMapping("/{id}")
    String update(@PathVariable Long id, @RequestBody Room room) {
        Optional<RoomEntity> sobaEntity = sobaRepository.findById(id);

        if (sobaEntity == null) {
            return "Reservation with id does not exist!";
        } else {
            RoomEntity rezervacijaEntity1=sobaEntity.get();
            Long Id=rezervacijaEntity1.getId();
            BeanUtils.copyProperties(room,rezervacijaEntity1);
            rezervacijaEntity1.setNumberOfBeds(room.getNumOfBeds());
            rezervacijaEntity1.setId(Id);
            sobaRepository.save(rezervacijaEntity1);
            return "Updated successfully!";
        }

    }
    @DeleteMapping("/{id}")
    String deleteSoba(@PathVariable Long id) {
       // if(requestValidation.validateId(id) != null)
           // return requestValidation.validateId(id);
        sobaRepository.deleteById(id);
        return "Room is deleted successfully";
    }
    @GetMapping("/{id}")
    Room findRoomById(@PathVariable Long id) {
        RoomEntity roomEntity = sobaRepository.findById(id).get();
        Room room =new Room();
        BeanUtils.copyProperties(roomEntity, room);
        room.setNumOfBeds(roomEntity.getNumberOfBeds());
        return room;
    }
}
