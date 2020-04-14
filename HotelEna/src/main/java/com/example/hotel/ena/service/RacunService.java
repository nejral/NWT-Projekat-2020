package com.example.hotel.ena.service;

import com.example.hotel.ena.dto.*;
import com.example.hotel.ena.mapper.RacunMapper;
import com.example.hotel.ena.models.RacunEntity;
import com.example.hotel.ena.repository.RacunRepository;
import com.example.hotel.ena.rest.RezervacijaClient;
import com.example.hotel.ena.validation.RequestValidation;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@Service
//@AllArgsConstructor
public class RacunService {

//    @Autowired
//    RezervacijaClient rezervacijaClient;
    @Autowired
    RacunRepository racunRepository;
    RequestValidation requestValidation;
    RacunMapper racunMapper;

    public String create(final RacunRequest racunRequest) throws ConstraintViolationException {
        requestValidation.validateCreateRequest(racunRequest);
        RacunEntity racunEntity = racunMapper.dtoToEntity(racunRequest);
        racunEntity.setPaid(false);
        racunRepository.save(racunEntity);
        return "Bill successfully created";
    }

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

    public List<Racun> findAll(){
        List<Racun> racuni=racunMapper.entitiesToDtos(racunRepository.findAll());
        return racuni;
    }

    public Racun findById(Long id){
        requestValidation.validateId(id);
        return racunMapper.entityToDto(racunRepository.findById(id).get());
    }
    public List<Racun> findByCreatedBy(Long createdBy){
        requestValidation.validateCreatedBy(createdBy);
        List<Racun> racun=new ArrayList<>();
        return racunMapper.entitiesToDtos(racunRepository.findByCreatedBy(createdBy));
    }

//moyda treba request
    public String updateRacun( Racun racunRequest){
        requestValidation.validateId(racunRequest.getId());
        racunMapper.updateEntity(racunRequest,racunRepository.findById(racunRequest.getId()).get());
        return "Updated successfully";
    }

    public Racun findByUserId(@PathVariable long userId) {
        Racun racun=new Racun();
        return racunMapper.entityToDto(racunRepository.findByUserId(userId));
    }

    public String deleteById(Long id) {
        requestValidation.validateId(id);
        racunRepository.deleteById(id);
        return "Bill is deleted successfully";
    }

    public String pay(List<Long> ids) {
        for (int i = 0; i < ids.size(); i++) {
            requestValidation.validateId(ids.get(i));
            racunRepository.getOne(ids.get(i)).setPaid(true);
          }
        return "Bills payed successfully";
    }
}
