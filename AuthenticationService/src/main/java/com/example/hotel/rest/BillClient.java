package com.example.hotel.rest;

import com.example.hotel.dto.*;
import org.springframework.cloud.openfeign.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;
import java.util.*;

@FeignClient("billing")
public interface BillClient {

    @GetMapping("bill/guest/{userId}")
    List<Bill> findByUserId(@PathVariable Long userId);

    @GetMapping("/bill/employee/{createdBy}")
     List<BillEntity> getAllCreatedBy(@PathVariable Long createdBy);

    @PostMapping("bill/pay")
    public String payBills(List<Long> ids);

    @GetMapping("bill/all")
    List<BillEntity> all();

    @PostMapping("/bill")
    public String create(@Valid @RequestBody BillRequest billRequest);

    @DeleteMapping("/bill/{id}")
    String deleteRacun(@PathVariable Long id);


    @GetMapping("/bill/{id}")
    Bill findById(@PathVariable Long id);

    @PutMapping("/bill/{id}")
    String update(@Valid  @RequestBody BillRequest racun, @PathVariable Long id);


}