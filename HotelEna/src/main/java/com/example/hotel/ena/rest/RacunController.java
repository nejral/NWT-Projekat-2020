package com.example.hotel.ena.rest;
import com.example.hotel.ena.dto.*;
import com.example.hotel.ena.models.RacunEntity;
import com.example.hotel.ena.repository.RacunRepository;
import com.example.hotel.ena.service.RacunService;
import com.example.hotel.ena.validation.RequestValidation;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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



    @ApiOperation(value = "Create Bill", consumes = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping()
    public String create(@Valid @RequestBody RacunRequest racun) {
        return racunService.create(racun);
    }

    @ApiOperation(value = "Get All Bills", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/all")
    List<Racun> all() {
        return racunService.findAll();
    }

    @ApiOperation(value = "Get Bill By Id", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/{id}")
    Racun findById(@PathVariable Long id) {
        return racunService.findById(id);
    }

    @ApiOperation(value = "Update Bill By Id", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PutMapping()
    String update(@Valid  @RequestBody Racun racun) {
        return racunService.updateRacun( racun);
    }

    @ApiOperation(value = "Delete Bill By Id", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @DeleteMapping("/{id}")
    String deleteRacun(@PathVariable Long id) {
        return racunService.deleteById(id);
    }

    @ApiOperation(value = "Get All Bills made By User with Id ", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/{userId}/bill")
    Racun findByUserId(@PathVariable Long userId) {
        return racunService.findByUserId(userId);
    }

    @ApiOperation(value = "Get All Bills by createdBy", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/{userId}/zaposlenik")
    List<Racun> getAllCreatedBy(@PathVariable Long createdBy) {
        requestValidation.validateCreatedBy(createdBy);
        return racunService.findByCreatedBy(createdBy);
    }

    @ApiOperation(value = "Pay bills with ids", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/pay")
    String payBills(List<Long> ids) {
        return racunService.pay(ids);
    }

    // Single item

    @GetMapping("/{userId}")
    RacunEntity findByUserId(@PathVariable long userId) {
        RacunEntity racunEntity=new RacunEntity();
        return racunRepository.findByUserId(userId);
    }
    @GetMapping("/reservation/{reservationId}")
    Racun reservationRacun(@PathVariable Long reservationId) {
        RacunEntity racunEntity=racunRepository.findByReservationId(reservationId);
        Racun racun=new Racun();
        BeanUtils.copyProperties(racunEntity,racun);
        return racun;
    }


    @GetMapping("/racun")
    public List<RacunEntity> findRacun() {
        return racunRepository.findAll();
    }
    @GetMapping("/not-paid")
    public List<RacunPaidResponse> getAllNotPaid(){
        return racunService.getAllNotPaid();
    }




  /*@GetMapping()
  List<RacunEntity> all() {
            return racunRepository.findAll();
        }
*/
   /*@PostMapping()
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
        }*/

        //nista ne radi
  /* @PostMapping("/reservation")
   String newRacunReservation(@RequestBody RacunReservationRequest noviRacun) {
            RacunEntity racunEntity=new RacunEntity();
             BeanUtils.copyProperties(noviRacun,racunEntity);
            racunRepository.save(racunEntity);
            return "Racun created successfully";
    }*/



   /* @PutMapping("/{id}")
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
        *//*if(requestValidation.validateId(id)!=null)
            return requestValidation.validateId(id);
        racunRepository.deleteById(id);
        return "Korisnik is deleted successfully";*//*

            if(requestValidation.validateDelete(id)==null) {
                racunRepository.deleteById(id);
                return "Racun is deleted successfully";
            }
            else {

                return requestValidation.validateDelete(id);
            }

        }*/



    }



