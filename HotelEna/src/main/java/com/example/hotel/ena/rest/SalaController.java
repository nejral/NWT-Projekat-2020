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
@RequestMapping("/reservation/hall")
public class SalaController {

    SalaRepository salaRepository;
    @PostMapping()
    public String create(@RequestBody Hall sala) {

        SalaEntity sobaEntity = new SalaEntity();
        BeanUtils.copyProperties(sala, sobaEntity);
      //  sobaEntity.setNumberOfPeople(soba.getNumOfBeds());
        salaRepository.save(sobaEntity);
        return "Successfully created!";
    }


    @GetMapping("/all")
    List<SalaEntity> all() {
        return salaRepository.findAll();
    }
    @PutMapping("/{id}")
    String update(@PathVariable Long id, @RequestBody Hall sala) {
        Optional<SalaEntity> sobaEntity = salaRepository.findById(id);

        if (sobaEntity == null) {
            return "Sala with id does not exist!";
        } else {
            SalaEntity rezervacijaEntity1=sobaEntity.get();
            Long Id=rezervacijaEntity1.getId();
            BeanUtils.copyProperties(sala ,rezervacijaEntity1);
          //  rezervacijaEntity1.setNumberOfBeds(soba.getNumOfBeds());
            rezervacijaEntity1.setId(Id);
            salaRepository.save(rezervacijaEntity1);
            return "Updated successfully!";
        }

    }
    @DeleteMapping("/{id}")
    String deleteSala(@PathVariable Long id) {
        // if(requestValidation.validateId(id) != null)
        // return requestValidation.validateId(id);
        salaRepository.deleteById(id);
        return "Sala is deleted successfully";
    }
    @GetMapping("/{id}")
    Hall findHallById(@PathVariable Long id) {
        SalaEntity sobaEntity= salaRepository.findById(id).get();
        Hall soba=new Hall();
        BeanUtils.copyProperties(sobaEntity,soba);
        //soba.setNumOfBeds(sobaEntity.getNumberOfBeds());
        return soba;
    }
}
