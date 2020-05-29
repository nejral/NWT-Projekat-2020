package com.example.hotel.ena.rest;

import com.example.hotel.ena.dto.Racun;
import com.example.hotel.ena.models.RezervacijaEntity;
import com.example.hotel.ena.dto.Rezervacija;
import com.example.hotel.ena.repository.RezervacijaRepository;
import com.example.hotel.ena.service.RezervacijaService;
import com.example.hotel.ena.validation.RequestValidation;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;


import java.sql.Date;
import java.time.*;
import java.util.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;




@AllArgsConstructor
@RestController
@RequestMapping("/rezervacija")
class RezervacijaController {
    private RezervacijaRepository rezervacijaRepository;
    private RequestValidation requestValidation;
    private RezervacijaService rezervacijaService;

    @PostMapping()
    public String create(@RequestBody Rezervacija rezervacija) {

       

        if (requestValidation.validateUserId(rezervacija.getUserId()) == null) {

            RezervacijaEntity rezervacijaEntity = new RezervacijaEntity();
            BeanUtils.copyProperties(rezervacija, rezervacijaEntity);
            rezervacijaEntity.setCreated(LocalDateTime.now().toLocalDate());
            rezervacijaRepository.save(rezervacijaEntity);
            return "Successfully created!";
        }


        return requestValidation.validateUserId(rezervacija.getUserId());

    }

    @PostMapping("/createByUserId/{id}")
    public String createByUserId(@RequestBody Rezervacija rezervacija, @PathVariable Long id) {
        if (requestValidation.validateUserId(id) == null) {
            RezervacijaEntity rezervacijaEntity = new RezervacijaEntity();
            BeanUtils.copyProperties(rezervacija, rezervacijaEntity);
            rezervacijaEntity.setUserId(id);
            rezervacijaRepository.save(rezervacijaEntity);
            return "Successfully created!";
        }
        return requestValidation.validateUserId(rezervacija.getUserId());
    }

    @GetMapping("/all")
    List<RezervacijaEntity> all() {
        return rezervacijaRepository.findAll();
    }

    @GetMapping("/allByUserId/{id}")

    List<Rezervacija> allByUserId(@PathVariable Long id) {
        List<RezervacijaEntity> rezervacije = rezervacijaRepository.findAll();
        List<Rezervacija> pomRezervacije = new ArrayList<>();

        for (RezervacijaEntity rez : rezervacije){
            if (rez.getUserId() == id) {
                Rezervacija pomRez = new Rezervacija();
                BeanUtils.copyProperties(rez, pomRez);
                pomRezervacije.add(pomRez);
            }
        }
        return pomRezervacije;

    }

    @GetMapping("/allByCreatedBy/{id}")
    List<Rezervacija> allByCreatedBy(@PathVariable Long id) {

        List<RezervacijaEntity> lista =rezervacijaRepository.findByCreatedBy(id);
        List<Rezervacija> rezervacije=new ArrayList<Rezervacija>();
for(RezervacijaEntity rezervacijaEntity:lista){
    Rezervacija rezervacija=new Rezervacija();
    BeanUtils.copyProperties(rezervacijaEntity,rezervacija);
    rezervacije.add(rezervacija);
}
        return rezervacije;
            }







    @GetMapping("/checkExpired")
    List<Rezervacija> checkExpired() {
        List<RezervacijaEntity> rezervacije = rezervacijaRepository.findAll();
        List<Rezervacija> pomRezervacije = new ArrayList<>();

        for (RezervacijaEntity rez : rezervacije){
          //  if (rez.getValidTo().compareTo(new Date(System.currentTimeMillis())) <= 0) {
                Rezervacija pomRez = new Rezervacija();
                BeanUtils.copyProperties(rez, pomRez);
                pomRezervacije.add(pomRez);
            }
       // }
        return pomRezervacije;
    }/*
    @GetMapping("racun/reservation/{reservationId}")
    Racun findRacunByReservationId(@PathVariable Long reservationId) {
        return rezervacijaService.findByReservationId(reservationId);
    }*/
    @GetMapping("/{reservationId}")
    Racun reservationRacun(@PathVariable Long reservationId) {
        return rezervacijaService.reservationRacun(reservationId);
    }

    @PostMapping("/reservation/{reservationId}")
    Racun reservationCreateRacun(@PathVariable Long reservationId) {
        return rezervacijaService.reservationCreateRacun(reservationId);
    }

    @PutMapping("/{id}")
    String update(@PathVariable Long id, @RequestBody Rezervacija rezervacija) {
        Optional<RezervacijaEntity> rezervacijaEntity = rezervacijaRepository.findById(id);

        if (rezervacijaEntity == null) {
            return "Rezervacija with id does not exist!";
        } else {
            RezervacijaEntity rezervacijaEntity1=rezervacijaEntity.get();
            Long Id=rezervacijaEntity1.getId();
            BeanUtils.copyProperties(rezervacija, rezervacijaEntity1);
            rezervacijaEntity1.setId(Id);
            rezervacijaRepository.save(rezervacijaEntity.get());
            return "Updated successfully!";
        }

    }



    @DeleteMapping("/{id}")
    String deleteRezervacija(@PathVariable Long id) {
        if(requestValidation.validateId(id) != null)
            return requestValidation.validateId(id);
        rezervacijaRepository.deleteById(id);
        return "Rezervacija is deleted successfully";
    }
@GetMapping("/find/{id}")
    Rezervacija findById(@PathVariable Long id){
       RezervacijaEntity rezervacijaEntity= rezervacijaRepository.findById(id).get();
       Rezervacija rezervacija=new Rezervacija();
    BeanUtils.copyProperties(rezervacijaEntity,rezervacija);
    return rezervacija;
}

}
