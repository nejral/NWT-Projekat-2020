package com.example.hotel.ena.service;

import com.example.hotel.ena.dto.Racun;
import com.example.hotel.ena.dto.RacunPaidResponse;
import com.example.hotel.ena.models.RacunEntity;
import com.example.hotel.ena.repository.RacunRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RacunService {
    @Autowired
    RacunRepository racunRepository;
    public List<RacunPaidResponse> getAllNotPaid(){
        List<RacunPaidResponse> lista=null;
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
}
