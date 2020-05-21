package com.example.hotel.configuration;


import com.example.hotel.models.*;
import com.example.hotel.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.context.event.*;
import org.springframework.context.event.*;
import org.springframework.stereotype.*;


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
        gost.setRole("USER");
        gost.setEmail("aminafajic879@gmail.com");
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
