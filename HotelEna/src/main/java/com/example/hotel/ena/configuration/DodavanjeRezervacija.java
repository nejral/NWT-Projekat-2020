package com.example.hotel.ena.configuration;


import com.example.hotel.ena.dto.*;
import com.example.hotel.ena.models.*;
import com.example.hotel.ena.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.context.event.*;
import org.springframework.context.event.*;
import org.springframework.stereotype.*;

import java.time.*;


@Component

public class DodavanjeRezervacija {

    @Autowired
    private RezervacijaRepository rezervacijaRepozitorij;
    @Autowired
    private SobaRepository sobaRepozitorij;
    @Autowired
    private SalaRepository salaRepozitorij;

    @EventListener

    public void dodaj(ApplicationReadyEvent event) {

        dodajGoste();

    }


    private void dodajGoste() {

        RezervacijaEntity rezervacijaEntity = new RezervacijaEntity();
        rezervacijaEntity.setDone(false);
        //rezervacijaEntity.setCreated(LocalDateTime.now());
rezervacijaEntity.setCreatedBy(Long.valueOf(1));
rezervacijaEntity.setRacunId(Long.valueOf(1));
        rezervacijaRepozitorij.save(rezervacijaEntity);
        SobaEntity soba= new SobaEntity();
        soba.setBusy(true);
        soba.setNumberOfBeds(3);
        sobaRepozitorij.save(soba);
        SalaEntity sala=new SalaEntity();
        sala.setNumberOfPeople(4);
        sala.setUserId(Long.valueOf(1));
        salaRepozitorij.save(sala);
    }


}
