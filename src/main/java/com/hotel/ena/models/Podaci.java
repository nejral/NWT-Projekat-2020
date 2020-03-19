package com.hotel.ena.models;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.context.event.ApplicationReadyEvent;

import org.springframework.context.event.EventListener;

import org.springframework.stereotype.Component;



import java.util.ArrayList;

import java.util.List;



@Component

public class Podaci {



    private GostRepository gostRepozitorij;

    private ZaposlenikRepository zaposlenikRepozitorij;



    @Autowired

    public Podaci(GostRepository gostRepozitorij, ZaposlenikRepository zaposlenikRepozitorij) {

        this.zaposlenikRepozitorij = zaposlenikRepozitorij;

        this.gostRepozitorij = gostRepozitorij;

    }



    @EventListener

    public void dodaj (ApplicationReadyEvent event){

        dodajGoste();
        dodajZaposlenike();

    }



    private void dodajGoste() {

        GostEntity gost = new GostEntity();
        
        gost.setName("Amina");
        gost.setSurname("Fajic");

        gostRepozitorij.save(gost);
        }
        private void dodajZaposlenike(){
ZaposlenikEntity zaposlenik= new ZaposlenikEntity();
zaposlenik.setName("Nejra");
zaposlenik.setLastName("Lacevic");
zaposlenikRepozitorij.save(zaposlenik);

    }

