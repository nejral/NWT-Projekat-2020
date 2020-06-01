package com.example.hotel.rest;

import com.example.hotel.dto.*;
import com.example.hotel.service.*;
import com.example.hotel.validation.*;
import io.swagger.annotations.*;
import lombok.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@AllArgsConstructor
@RestController
@RequestMapping("/user/reservation")
public class ReservationController {

    private ReservationClient reservationClient;
    private UserService userService;
private RequestValidation requestValidation;

    @ApiOperation(value = "Create Reservation", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/{userId}")
    String createReservation(@PathVariable Long userId,@RequestBody ReservationCreateRequest reservationCreateRequest) {
        requestValidation.validateId(userId);
        requestValidation.validateId(reservationCreateRequest.getUserId());
        reservationCreateRequest.setCreatedBy(userId);
        reservationClient.create(reservationCreateRequest);
        return "Successfully created Reservation!";
    }
    @ApiOperation(value = "Delete Reservation with id", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @DeleteMapping("/{id}")
    String delete(@PathVariable Long id) {
        return reservationClient.delete(id);
    }

    @GetMapping("/{id}")
    Reservation get(@PathVariable Long id) {
        return reservationClient.findById(id);
    }
    @PutMapping("/{id}")
    String update(@PathVariable Long id, @RequestBody Reservation rezervacija) {
        return reservationClient.update(id,rezervacija);
    }
    @ApiOperation(value = "Get All Reservations by User with Id", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/guest/{id}")
    List<Reservation> getGuestsReservations(@PathVariable Long id) {
        return userService.allByUserId(id);
    }

    @ApiOperation(value = "Get All Reservations created By Employee with Id", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/employee/{id}")
    List<Reservation> getEmployeeReservations(@PathVariable Long id) {
        //requestValidation.validateEmployee(id);
        return userService.allByCreatedBy(id);
    }
    @ApiOperation(value = "Get All Reservations", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/all")
    List<ReservationEntity> getReservations() {
        //requestValidation.validateEmployee(id);
        return reservationClient.allReservations();
    }


}
