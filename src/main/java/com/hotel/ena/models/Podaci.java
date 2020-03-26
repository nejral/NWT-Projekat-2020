package com.hotel.ena.models;


import com.hotel.ena.repository.RezervacijaRepository;
import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.boot.context.event.ApplicationReadyEvent;



import org.springframework.context.event.EventListener;
import ba.com.zira.template.dao.model.translation.RezervacijaEntity;


import org.springframework.stereotype.Component;


import java.sql.Date;
import java.util.ArrayList;



import java.util.List;

@Component

public class Podaci {

    private RezervacijaRepository rezervacijaRepozitorij;


    @Autowired
    public Podaci(RezervacijaRepository rezervacijaRepozitorij) {

        this.rezervacijaRepozitorij = rezervacijaRepozitorij;
    }

    @EventListener
    public void dodaj(ApplicationReadyEvent event) {

        dodajRezervacije();
    }


    private void dodajRezervacije() {

        RezervacijaEntity rezervacija = new RezervacijaEntity();

        rezervacija.setCreatedBy((long) 5);     //id usera

        rezervacija.setCreated(new Date(2020, 1, 1));

        rezervacijaRepozitorij.save(rezervacija);

    }
}

      

