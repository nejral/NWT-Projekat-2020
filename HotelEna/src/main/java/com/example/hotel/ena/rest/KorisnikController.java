package com.example.hotel.ena.rest;

import com.example.hotel.ena.dto.*;
import com.example.hotel.ena.models.KorisnikEntity;
import com.example.hotel.ena.repository.KorisnikRepository;
import com.example.hotel.ena.service.KorisnikService;
import com.example.hotel.ena.validation.RequestValidation;
import com.sun.research.ws.wadl.*;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.security.access.prepost.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;
import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@RestController
@RequestMapping("/korisnik")
public class KorisnikController {


    private RequestValidation requestValidation;

    private KorisnikService korisnikService;

    @ApiOperation(value = "Create User", consumes = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping()
    public String create(@Valid  @RequestBody KorisnikRequest korisnik) {
        return korisnikService.create(korisnik);
    }

    @ApiOperation(value = "Get All Users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/all")
    @PreAuthorize("hasAuthority('PRIVILEGE_ADMIN_READ')")
    List<Korisnik> all() {
        return korisnikService.findAll();
    }

    @ApiOperation(value = "Get User By Id", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/{id}")
    Korisnik findById(@PathVariable Long id) {
        return korisnikService.findById(id);
    }

    @ApiOperation(value = "Update User By Id", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PutMapping()
    String update(@Valid  @RequestBody Korisnik korisnik) {
        return korisnikService.updateKorisnik( korisnik);

    }

    @ApiOperation(value = "Delete User By Id", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @DeleteMapping("/{id}")
    String deleteKorisnik(@PathVariable Long id) {
        return korisnikService.deleteById(id);
    }

    @ApiOperation(value = "Get All Bills made By User with Id ", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/{userId}/bill")
    Racun findRacunByUserId(@PathVariable Long userId) {
        return korisnikService.findByUserId(userId);
    }

    @ApiOperation(value = "Get All Bills created By Employee with Id", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/{userId}/employee/bill")

    List<Racun> findRacunByUserIdEmployee(@PathVariable Long userId) {
        requestValidation.validateId(userId);
        return korisnikService.findByUserIdEmployee(userId);
    }

    @ApiOperation(value = "Pay bills with ids", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/employee/bill/pay")
    String pay(List<Long> ids) {
        return korisnikService.pay(ids);
    }

    @ApiOperation(value = "Get All Reservations by User with Id", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/reservation/{id}")
    Rezervacija getGuestsReservations(@PathVariable Long id) {
        return korisnikService.allByUserId(id);
    }

    @ApiOperation(value = "Get All Reservations created By Employee with Id", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/reservation/employee/{id}")
    Rezervacija getEmployeeReservations(@PathVariable Long id) {
        requestValidation.validateEmployee(id);
        return korisnikService.allByCreatedBy(id);
    }

    @ApiOperation(value = "Login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/login")
    String login(@RequestBody KorisnikLoginRequest korisnikLoginRequest) {
        requestValidation.validateLogin(korisnikLoginRequest);
        return "Successfully logged in!";
    }
}
