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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@AllArgsConstructor
@RestController

@RequestMapping("/bill")

public class RacunController {
@Autowired
        private RequestValidation requestValidation;
       // private static final String template = "Cost: %f";
       // private final AtomicLong counter = new AtomicLong();
        private RacunService racunService;
        private  RacunRepository racunRepository;

        // Aggregate root



    @ApiOperation(value = "Create Bill", consumes = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping()
    public String create(@Valid @RequestBody RacunRequest racunRequest) {
        return racunService.create(racunRequest);
    }




    @ApiOperation(value = "Get All Bills", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/all")
    List<RacunEntity> all() {
        return racunService.findAll();
    }

    @ApiOperation(value = "Get Bill By Id", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/{id}")
    Racun findById(@PathVariable Long id) {
        return racunService.findById(id);
    }

    @ApiOperation(value = "Update Bill By Id", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PutMapping("/{id}")
    String update(@Valid  @RequestBody RacunRequest racun, @PathVariable Long id) {
        return racunService.updateRacun( racun, id);
    }

    @ApiOperation(value = "Delete Bill By Id", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @DeleteMapping("/{id}")
    String deleteRacun(@PathVariable Long id) {
        return racunService.deleteById(id);
    }

    @ApiOperation(value = "Get All Bills made By User with Id ", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/guest/{userId}")
    List<Racun> findByUserId(@PathVariable Long userId) {
        return racunService.findByUserId(userId);
    }

    @ApiOperation(value = "Get All Bills by createdBy", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/employee/{createdBy}")
    List<RacunEntity> getAllCreatedBy(@PathVariable Long createdBy) {
        //requestValidation.validateCreatedBy(createdBy);
        return racunService.findByCreatedBy(createdBy);
    }

    @ApiOperation(value = "Pay bills with ids", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/pay")
    String payBills(List<Long> ids) {
        return racunService.pay(ids);
    }

    // Single item

    @GetMapping("/user/{userId}")
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

    @PostMapping("/reservation/{reservationId}")
    Racun reservationCreateRacun(@PathVariable Long reservationId) {

        return racunService.reservationCreateRacun(reservationId);
    }



    @GetMapping("/not-paid")
    public List<RacunPaidResponse> getAllNotPaid(){
        return racunService.getAllNotPaid();
    }



   @PostMapping("/reservation/create/bill")
   String newRacunReservation(@RequestBody RacunReservationRequest noviRacun) {
            RacunEntity racunEntity=new RacunEntity();
             BeanUtils.copyProperties(noviRacun,racunEntity);
             racunEntity.setCreated(LocalDateTime.now());
            racunRepository.save(racunEntity);
            return "Racun created successfully";
    }


    }



