package com.example.hotel.ena.rest;
import com.example.hotel.ena.dto.*;
import com.example.hotel.ena.models.RacunEntity;
import com.example.hotel.ena.repository.RacunRepository;
import com.example.hotel.ena.service.RacunService;
import com.example.hotel.ena.validation.RequestValidation;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@AllArgsConstructor
@RestController
@RequestMapping("/racun")

public class RacunController {

        private RequestValidation requestValidation;
        private static final String template = "Cost: %f";
        private final AtomicLong counter = new AtomicLong();
        private RacunService racunService;
        private  RacunRepository racunRepository;

        // Aggregate root

  @GetMapping()
  List<RacunEntity> all() {
            return racunRepository.findAll();
        }

   @PostMapping()
   String newRacun(@RequestBody RacunEntity noviRacun) {
            if(requestValidation.validateIznos(noviRacun.getCost())==null) {
//                KorisnikEntity korisnikEntity = new KorisnikEntity();
//                BeanUtils.copyProperties(korisnik, korisnikEntity);
//                korisnikRepository.save(korisnikEntity);
//                return "Successfully created!";
                racunRepository.save(noviRacun);
                return "Racun created successfully";
            }
            else {
                return requestValidation.validateIznos(noviRacun.getCost());
            }
        }
        //nista ne radi
   @PostMapping("/reservation")
   String newRacunReservation(@RequestBody RacunReservationRequest noviRacun) {
            RacunEntity racunEntity=new RacunEntity();
             BeanUtils.copyProperties(noviRacun,racunEntity);
            racunRepository.save(racunEntity);
            return "Racun created successfully";


    }
   // Single item

    @GetMapping("/{userId}")
    List<RacunEntity> findByUserId(@PathVariable long userId) {
        List<RacunEntity> racun=new ArrayList<>();
        return racunRepository.findByUserId(userId);
        }

    @PutMapping("/{id}")
    RacunEntity zamijeniRacun(@RequestBody RacunEntity newRacun, @PathVariable Long id) {

            return racunRepository.findById(id)
                    .map(racunEntity -> {
                        racunEntity.setCost(newRacun.getCost());
                        //racunEntity.setId(newRacun.getId());
                        racunEntity.setPaid(newRacun.getPaid());
                        racunEntity.setReservationId(newRacun.getReservationId());
                        racunEntity.setCreated(newRacun.getCreated());
                        racunEntity.setCreatedBy(newRacun.getCreatedBy());
                        racunEntity.setUserId(newRacun.getUserId());
                        return racunRepository.save(racunEntity);
                    })
                    .orElseGet(() -> {
                        //newRacun.setId(id);
                        return racunRepository.save(newRacun);
                    });
        }
    @DeleteMapping("/{id}")
    String deleteRacun(@PathVariable Long id) {
        /*if(requestValidation.validateId(id)!=null)
            return requestValidation.validateId(id);
        racunRepository.deleteById(id);
        return "Korisnik is deleted successfully";*/

            if(requestValidation.validateDelete(id)==null) {
                racunRepository.deleteById(id);
                return "Racun is deleted successfully";
            }
            else {

                return requestValidation.validateDelete(id);
            }

        }
    @GetMapping("/reservation/{reservationId}")
    Racun reservationRacun(@PathVariable Long reservationId) {
            RacunEntity racunEntity=racunRepository.findByReservationId(reservationId);
            Racun racun=new Racun();
            BeanUtils.copyProperties(racunEntity,racun);
            return racun;
    }
    //ne radi nista ovo tu
    @PostMapping("/racun/cost")
    public Racun racun(@RequestParam(value = "cost", defaultValue = "0") double cost) {
            return new Racun(counter.incrementAndGet(), String.format(template, cost));
        }
    @GetMapping("/racun")
    public List<RacunEntity> findRacun() {
            return racunRepository.findAll();
        }
    @GetMapping("/not-paid")
    public List<RacunPaidResponse> getAllNotPaid(){
            return racunService.getAllNotPaid();
}

    /*@GetMapping("/{id}")
    Racun getById(@PathVariable Long id) {
        Racun racun=new Racun();
        Optional<RacunEntity> racunEntity=racunRepository.findById(id);
        BeanUtils.copyProperties(racunEntity.get(),racun);
        return racun;
       // return racunRepozitorij.findById(id);
    }*/

  /*  @PutMapping("/{id}")
    String update(@PathVariable Long id, @RequestBody Racun racun) {
        Optional<RacunEntity> racunEntity = racunRepository.findById(id);
       if (!racunEntity.isPresent()) {
           return "Racun with id does not exist!";
        } else {
           BeanUtils.copyProperties(racun, racunEntity);
           return "Updated successfully!";
     }
  }*/
//
////    @GetMapping("/rezervacija/{id}")
//    List<Rezervacija> getGuestsReservations(@PathVariable Long id) {
//        return racunService.allByUserId(id);
//
//    }
//    @GetMapping("/rezervacija/zaposlenik/{id}")
//    List<Rezervacija> getEmployeeReservations(@PathVariable Long id){
//        return racunService.allByCreatedBy(id);
//    }


    }



