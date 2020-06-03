package com.example.hotel.ena.configuration;


import com.example.hotel.ena.models.*;
import com.example.hotel.ena.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.context.event.*;
import org.springframework.context.event.*;
import org.springframework.stereotype.*;

import java.time.*;


@Component

public class DodavanjeKorisnika {

    @Autowired
    private RacunRepository racunRepozitorij;

    @EventListener

    public void dodaj(ApplicationReadyEvent event) {

        dodajRacun();


    }


    private void dodajRacun() {

        RacunEntity racun = new RacunEntity();
       racun.setPaid(false);
       //racun.setCost(120);
       racun.setUserId(Long.valueOf(1));
       racun.setReservationId(Long.valueOf(1));
       racun.setCreatedBy(Long.valueOf(1));
     // racun.setCreated("");
        racunRepozitorij.save(racun);
    }


}
