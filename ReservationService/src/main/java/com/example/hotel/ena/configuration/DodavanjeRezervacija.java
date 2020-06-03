package com.example.hotel.ena.configuration;


import com.example.hotel.ena.models.*;
import com.example.hotel.ena.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.context.event.*;
import org.springframework.context.event.*;
import org.springframework.stereotype.*;


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

        ReservationEntity reservationEntity = new ReservationEntity();
        reservationEntity.setDone(false);
        //rezervacijaEntity.setCreated(LocalDateTime.now());
reservationEntity.setCreatedBy(Long.valueOf(1));
        rezervacijaRepozitorij.save(reservationEntity);
        RoomEntity soba= new RoomEntity();
        soba.setBusy(true);
        soba.setNumberOfBeds(Long.valueOf(3));
        sobaRepozitorij.save(soba);
        SalaEntity sala=new SalaEntity();
        sala.setNumberOfPeople(Long.valueOf(4));
       // sala.setUserId(Long.valueOf(1));
        salaRepozitorij.save(sala);
    }


}
