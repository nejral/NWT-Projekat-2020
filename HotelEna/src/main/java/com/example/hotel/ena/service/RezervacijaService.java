package com.example.hotel.ena.service;

import com.example.hotel.ena.dto.Racun;
import com.example.hotel.ena.rest.RacunClient;
import com.example.hotel.ena.validation.RequestValidation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@AllArgsConstructor
@Service
public class RezervacijaService {

    RacunClient racunClient;
    RequestValidation requestValidation;
/*
    public Racun findByReservationId(final Long reservationId) {
        return racunClient.reservationRacun(reservationId);
    }*/
    /*public Racun findByReservationId(final long reservationId){
        return racunClient.findByReservationId(reservationId);
    }*/
}
//one to many anotacija