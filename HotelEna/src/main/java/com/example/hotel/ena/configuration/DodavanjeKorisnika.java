package com.example.hotel.ena.configuration;

import com.example.hotel.ena.models.*;
import com.example.hotel.ena.repository.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.context.event.ApplicationReadyEvent;

import org.springframework.context.event.EventListener;

import org.springframework.stereotype.Component;


@Component

public class DodavanjeKorisnika {

    @Autowired
    private KorisnikRepository korisnikRepozitorij;

    @EventListener

    public void dodaj(ApplicationReadyEvent event) {

        dodajGoste();
        dodajZaposlenike();

    }


    private void dodajGoste() {

        KorisnikEntity gost = new KorisnikEntity();
        gost.setName("Amina");
        gost.setSurname("Fajic");
        gost.setUsername("aminaanaan");
        gost.setPassword("something");
        gost.setEmployeeInd(false);
        korisnikRepozitorij.save(gost);
    }

    private void dodajZaposlenike() {
        KorisnikEntity zaposlenik = new KorisnikEntity();
        zaposlenik.setName("Nejra");
        zaposlenik.setSurname("Lacevic");
        zaposlenik.setUsername("nejral");
        zaposlenik.setPassword("something2");
        zaposlenik.setEmployeeInd(true);
        korisnikRepozitorij.save(zaposlenik);
    }
}
