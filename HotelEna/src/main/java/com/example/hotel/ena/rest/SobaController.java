package com.example.hotel.ena.rest;

import com.example.hotel.ena.dto.*;
import com.example.hotel.ena.models.*;
import com.example.hotel.ena.repository.*;
import lombok.*;
import org.springframework.beans.*;
import org.springframework.context.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.time.*;
import java.util.*;

@AllArgsConstructor
@RestController
@RequestMapping("/rezervacija/soba")
public class SobaController {
SobaRepository sobaRepository;
    @PostMapping()
    public String create(@RequestBody Soba soba) {

            SobaEntity sobaEntity = new SobaEntity();
            BeanUtils.copyProperties(soba, sobaEntity);
            sobaEntity.setNumberOfBeds(soba.getNumOfBeds());
            sobaRepository.save(sobaEntity);
            return "Successfully created!";
        }


    @GetMapping("/all")
    List<SobaEntity> all() {
        return sobaRepository.findAll();
    }
    @PutMapping("/{id}")
    String update(@PathVariable Long id, @RequestBody Soba soba) {
        Optional<SobaEntity> sobaEntity = sobaRepository.findById(id);

        if (sobaEntity == null) {
            return "Rezervacija with id does not exist!";
        } else {
            SobaEntity rezervacijaEntity1=sobaEntity.get();
            Long Id=rezervacijaEntity1.getId();
            BeanUtils.copyProperties(soba ,rezervacijaEntity1);
            rezervacijaEntity1.setNumberOfBeds(soba.getNumOfBeds());
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
        return "Soba is deleted successfully";
    }
    @GetMapping("/{id}")
    Soba findRoomById(@PathVariable Long id) {
        SobaEntity sobaEntity= sobaRepository.findById(id).get();
        Soba soba=new Soba();
        BeanUtils.copyProperties(sobaEntity,soba);
        soba.setNumOfBeds(sobaEntity.getNumberOfBeds());
        return soba;
    }
}
