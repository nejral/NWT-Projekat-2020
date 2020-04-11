package com.example.hotel.ena.service;

import com.example.hotel.ena.dto.Racun;
import com.example.hotel.ena.dto.RacunPaidResponse;
import com.example.hotel.ena.dto.Rezervacija;
import com.example.hotel.ena.models.RacunEntity;
import com.example.hotel.ena.repository.RacunRepository;

import com.example.hotel.ena.rest.RezervacijaClient;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class RacunService {

//    @Autowired
//    RezervacijaClient rezervacijaClient;
    @Autowired
    RacunRepository racunRepository;

    public List<RacunPaidResponse> getAllNotPaid(){
        List<RacunPaidResponse> lista=new ArrayList<>();
        List<RacunEntity> entities=racunRepository.findAll();
        for(RacunEntity racun:entities){
                if(!racun.getPaid()){
                RacunPaidResponse racundto= new RacunPaidResponse();
                BeanUtils.copyProperties(racun,racundto);
                lista.add(racundto);
            }
        }
        return lista;
    }

//    public   List<Rezervacija> allByUserId(Long id){
//        return rezervacijaClient.allByUserId(id);
//    }
//    public List<Rezervacija> allByCreatedBy( Long id){
//        return rezervacijaClient.allByCreatedBy(id);
//    }
}
