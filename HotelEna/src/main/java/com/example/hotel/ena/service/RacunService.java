package com.example.hotel.ena.service;

import com.example.hotel.ena.dto.*;
import com.example.hotel.ena.exception.BaseException;
import com.example.hotel.ena.models.RacunEntity;
import com.example.hotel.ena.repository.RacunRepository;
import com.example.hotel.ena.rest.RezervacijaClient;
import com.example.hotel.ena.validation.RequestValidation;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

@Service
//@Transactional
//@AllArgsConstructor
public class RacunService {

//    @Autowired
//    RezervacijaClient rezervacijaClient;
    @Autowired
    RacunRepository racunRepository;
    @Autowired
    RequestValidation requestValidation;


    public String create(final RacunRequest racunRequest) throws ConstraintViolationException {

        try {
            requestValidation.validateCreateRequest(racunRequest);
            RacunEntity racunEntity= new RacunEntity();
            BeanUtils.copyProperties(racunRequest,racunEntity);

            //racunEntity.setPaid(false);
            racunEntity.setCreated(LocalDateTime.now());
           // System.out.println(racunEntity);
            racunRepository.save(racunEntity);

        }
        catch(NullPointerException e) {
            // probably don't bother doing clean up
        }catch(BaseException f){
            return f.getMessage();
        }


        return "Bill created successfully";


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

    public List<RacunEntity> findAll(){

     //  try {
          //  assert(racunRepository.count()!=0);
        List<RacunEntity>  racuni = racunRepository.findAll();
        //} catch(NullPointerException e) {
            // probably don't bother doing clean up
       // }
       return racuni;
      }

    public Racun findById(Long id){
        requestValidation.validateId(id);
        Racun racun=new Racun();
        BeanUtils.copyProperties(racunRepository.findById(id).get(), racun);
        return racun;
    }

    public List<RacunEntity> findByCreatedBy(Long createdBy){
      //  requestValidation.validateCreatedBy(createdBy);

        return racunRepository.findByCreatedBy(createdBy);

    }

//moyda treba request
    public String updateRacun( RacunRequest racunRequest, Long id){
        try {
            //requestValidation.validateId(racunRequest.getId());
            RacunEntity racunEntity=racunRepository.findById(id).get();
            LocalDateTime created=racunEntity.getCreated();
            BeanUtils.copyProperties(racunRequest,racunEntity);
            racunEntity.setId(id);
            racunEntity.setCreated(created);
            racunRepository.save(racunEntity);
            //racunMapper.updateEntity(racunRequest,racunRepository.findById(racunRequest.getId()).get());

        }
        catch(NullPointerException e) {
            // probably don't bother doing clean up
        }catch(Exception f){
            return f.getMessage();
        }

        return "Updated successfully!";
    }

    public Racun findByUserId(@PathVariable long userId) {
        Racun racun=new Racun();
        BeanUtils.copyProperties(racunRepository.findByUserId(userId),racun);
        return racun;
    }
    public Racun reservationCreateRacun(@PathVariable Long reservationId) {

        // racunRepository.findByReservationId(reservationId);
        RacunRequest racunRequest = new RacunRequest();
        racunRequest.setReservationId(reservationId);
        RacunEntity racunEntity = new RacunEntity();
        BeanUtils.copyProperties(racunRequest,racunEntity);
        racunEntity.setPaid(false);
        racunRepository.save(racunEntity);
        RacunEntity re=racunRepository.findByReservationId(reservationId);
        Racun racun=new Racun();
        BeanUtils.copyProperties(re,racun);
        return racun;


    }
    public String deleteById(Long id) {
        requestValidation.validateId(id);
        racunRepository.deleteById(id);
        return "Bill is deleted successfully";
    }

    public String pay(List<Long> ids) {
        for (Long id : ids) {
            requestValidation.validateId(id);
            racunRepository.getOne(id).setPaid(true);
        }
        return "Bills payed successfully";
    }
}
