package com.example.hotel.ena.rest;

import com.example.hotel.ena.dto.Racun;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("korisnik")
public interface KorisnikClient {

    @GetMapping("racun/{userId}")
    Racun findByUserId(@PathVariable Long userId);

//    @GetMapping("racun/{userId}")
//    Racun findByUserId(@PathVariable Long userId);
//
//    @GetMapping("racun/{userId}/zaposlenik")
//    public List<Racun> getAllCreatedBy(Long createdBy);
//
//    @PostMapping("racun/pay")
//    public String payBills(List<Long> ids);


}