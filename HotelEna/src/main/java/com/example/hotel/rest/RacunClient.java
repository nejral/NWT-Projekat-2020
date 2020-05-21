package com.example.hotel.rest;

import com.example.hotel.dto.*;
import com.example.hotel.models.*;
import org.springframework.cloud.openfeign.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@FeignClient("racun")
public interface RacunClient {

    @GetMapping("racun/{userId}/bill")
    Racun findByUserId(@PathVariable Long userId);

    @GetMapping("racun/{createdBy}/zaposlenik")
     List<RacunEntity> getAllCreatedBy(@PathVariable Long createdBy);

    @PostMapping("racun/pay")
    public String payBills(List<Long> ids);

}