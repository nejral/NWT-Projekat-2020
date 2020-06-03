package com.example.hotel.ena.service;

import com.example.hotel.ena.dto.Bill;
import com.example.hotel.ena.rest.RacunClient;
import com.example.hotel.ena.validation.RequestValidation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class RezervacijaService {

    RacunClient racunClient;
    RequestValidation requestValidation;

    public Bill reservationRacun(final Long reservationId) {
        return racunClient.reservationRacun(reservationId);
    }
    public Bill reservationCreateRacun(final Long reservationId) {
        return racunClient.reservationCreateRacun(reservationId);
    }
/*
    public Racun findByReservationId(final Long reservationId) {
        return racunClient.reservationRacun(reservationId);
    }*/
    /*public Racun findByReservationId(final long reservationId){
        return racunClient.findByReservationId(reservationId);
    }*/
}
//one to many anotacija