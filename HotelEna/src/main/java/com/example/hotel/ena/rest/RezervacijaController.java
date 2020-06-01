package com.example.hotel.ena.rest;

import com.example.hotel.ena.dto.*;
import com.example.hotel.ena.models.ReservationEntity;
import com.example.hotel.ena.repository.RezervacijaRepository;
import com.example.hotel.ena.service.RezervacijaService;
import com.example.hotel.ena.validation.RequestValidation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.*;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;


import java.time.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;




@AllArgsConstructor
@Slf4j
@RestController
@RequestMapping("/reservation")
class RezervacijaController {
    private RezervacijaRepository rezervacijaRepository;
    private RequestValidation requestValidation;
    private RezervacijaService rezervacijaService;
    private RacunClient racunClient;

    @PostMapping()
    public String create(@RequestBody ReservationCreateRequest rezervacija) {

       requestValidation.validateRezervacijaCreateRequest(rezervacija);

        if (requestValidation.validateUserId(rezervacija.getUserId()) == null) {

            ReservationEntity reservationEntity = new ReservationEntity();
            BeanUtils.copyProperties(rezervacija, reservationEntity);
            reservationEntity.setCreated(LocalDateTime.now().toLocalDate());
            ReservationEntity reservationEntity1 =rezervacijaRepository.save(reservationEntity);
            BillReservationRequest billReservationRequest =new BillReservationRequest();
            billReservationRequest.setCost(rezervacija.getCost());
            billReservationRequest.setReservationId(reservationEntity1.getId());
            billReservationRequest.setUserId(rezervacija.getUserId());
            billReservationRequest.setCreatedBy(rezervacija.getCreatedBy());
            racunClient.newRacunReservation(billReservationRequest);

            return "Successfully created!";
        }


        return requestValidation.validateUserId(rezervacija.getUserId());

    }

    @PostMapping("/createByUserId/{id}")
    public String createByUserId(@RequestBody Reservation reservation, @PathVariable Long id) {
        if (requestValidation.validateUserId(id) == null) {
            ReservationEntity reservationEntity = new ReservationEntity();
            BeanUtils.copyProperties(reservation, reservationEntity);
            reservationEntity.setUserId(id);
            rezervacijaRepository.save(reservationEntity);
            return "Successfully created!";
        }
        return requestValidation.validateUserId(reservation.getUserId());
    }

    @GetMapping("/all")
    List<ReservationEntity> all() {
        return rezervacijaRepository.findAll();
    }

    @GetMapping("/allByUserId/{id}")

    List<Reservation> allByUserId(@PathVariable Long id) {
        List<ReservationEntity> rezervacije = rezervacijaRepository.findAll();
        List<Reservation> pomRezervacije = new ArrayList<>();

        for (ReservationEntity rez : rezervacije){
            if (rez.getUserId() == id) {
                Reservation pomRez = new Reservation();
                BeanUtils.copyProperties(rez, pomRez);
                pomRezervacije.add(pomRez);
            }
        }
        return pomRezervacije;

    }

    @GetMapping("/allByCreatedBy/{id}")
    List<Reservation> allByCreatedBy(@PathVariable Long id) {

        List<ReservationEntity> lista =rezervacijaRepository.findByCreatedBy(id);
        List<Reservation> rezervacije=new ArrayList<Reservation>();
for(ReservationEntity reservationEntity :lista){
    Reservation reservation =new Reservation();
    BeanUtils.copyProperties(reservationEntity, reservation);
    rezervacije.add(reservation);
}
        return rezervacije;
            }







    @GetMapping("/checkExpired")
    List<Reservation> checkExpired() {
        List<ReservationEntity> rezervacije = rezervacijaRepository.findAll();
        List<Reservation> pomRezervacije = new ArrayList<>();

        for (ReservationEntity rez : rezervacije){
          //  if (rez.getValidTo().compareTo(new Date(System.currentTimeMillis())) <= 0) {
                Reservation pomRez = new Reservation();
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
    Bill reservationRacun(@PathVariable Long reservationId) {
        return rezervacijaService.reservationRacun(reservationId);
    }

    @PostMapping("/reservation/{reservationId}")
    Bill reservationCreateRacun(@PathVariable Long reservationId) {
        return rezervacijaService.reservationCreateRacun(reservationId);
    }

    @PutMapping("/{id}")
    String update(@PathVariable Long id, @RequestBody Reservation reservation) {
        Optional<ReservationEntity> rezervacijaEntity = rezervacijaRepository.findById(id);

        if (rezervacijaEntity == null) {
            return "Rezervacija with id does not exist!";
        } else {
            ReservationEntity reservationEntity1 =rezervacijaEntity.get();
            Long Id= reservationEntity1.getId();
            LocalDate created= reservationEntity1.getCreated();
            BeanUtils.copyProperties(reservation, reservationEntity1);
            reservationEntity1.setId(Id);
            reservationEntity1.setCreated(created);
            rezervacijaRepository.save(reservationEntity1);
            return "Updated successfully!";
        }

    }



    @DeleteMapping("/{id}")
    String delete(@PathVariable Long id) {
        if(requestValidation.validateId(id) != null)
            return requestValidation.validateId(id);
        rezervacijaRepository.deleteById(id);
        return "Rezervacija is deleted successfully";
    }
@GetMapping("/find/{id}")
Reservation findById(@PathVariable Long id){
       ReservationEntity reservationEntity = rezervacijaRepository.findById(id).get();
       Reservation reservation =new Reservation();
    BeanUtils.copyProperties(reservationEntity, reservation);
    return reservation;
}

}
