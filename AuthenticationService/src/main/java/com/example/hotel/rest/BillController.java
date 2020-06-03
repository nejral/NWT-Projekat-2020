package com.example.hotel.rest;

import com.example.hotel.dto.*;
import com.example.hotel.service.*;
import io.swagger.annotations.*;
import lombok.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;
import java.util.*;

@AllArgsConstructor
@RestController
@RequestMapping("/user/bill")
public class BillController {
    private BillClient billClient;

    private UserService korisnikService;
    @GetMapping("/{id}")
    Bill findById(@PathVariable Long id){
        return billClient.findById(id);
    }

    @PutMapping("/{id}")
    String update(@Valid @RequestBody BillRequest racun, @PathVariable Long id){
        return billClient.update(racun,id);
    }
    @DeleteMapping("/{id}")
    String delete(@PathVariable Long id){
        return billClient.deleteRacun(id);
    }

    @GetMapping("/all")
    List<BillEntity> allBills(){
        return billClient.all();
    }
    @PostMapping()
    String  create( @RequestBody BillRequest billRequest) {
        return  billClient.create(billRequest);
    }

    @ApiOperation(value = "Get All Bills made By User with Id ", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/{userId}/guest")
    List<Bill> findByUserId(@PathVariable Long userId) {
        return korisnikService.findByUserId(userId);
    }

    @ApiOperation(value = "Get All Bills created By Employee with Id", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/{userId}/employee")
    List<BillEntity> findByUserIdEmployee(@PathVariable Long userId) {
        //requestValidation.validateId(userId);
        return korisnikService.findByUserIdEmployee(userId);
    }
}
