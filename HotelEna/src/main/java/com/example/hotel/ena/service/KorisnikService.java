package com.example.hotel.ena.service;

import com.example.hotel.ena.dto.Racun;
import com.example.hotel.ena.dto.Rezervacija;
import com.example.hotel.ena.rest.RacunClient;
import com.example.hotel.ena.rest.RezervacijaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class KorisnikService {
     @Autowired
     RacunClient racunClient;

    @Autowired
    RezervacijaClient rezervacijaClient;

     public Racun findByUserId(final long userId){
         return racunClient.findByUserId(userId);
     }
    public List<Racun> findByUserIdEmployee(final long userId){
        return racunClient.getAllCreatedBy(userId);
    }
    public String pay(final List<Long> ids){
         return racunClient.payBills(ids);
    }

    public   List<Rezervacija> allByUserId(Long id){
         return rezervacijaClient.allByUserId(id);
    }
    public List<Rezervacija> allByCreatedBy( Long id){
         return rezervacijaClient.allByCreatedBy(id);
    }
}
