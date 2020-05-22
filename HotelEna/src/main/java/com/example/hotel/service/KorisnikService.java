package com.example.hotel.service;

import com.example.hotel.dto.*;
import com.example.hotel.exception.*;
import com.example.hotel.models.*;
import com.example.hotel.repository.*;
import com.example.hotel.rest.*;
import com.example.hotel.validation.*;
import org.springframework.beans.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import javax.validation.*;
import java.util.*;


@Service
public class KorisnikService {
@Autowired
    RacunClient racunClient;
@Autowired
    RezervacijaClient rezervacijaClient;
@Autowired
    RequestValidation requestValidation;

    @Autowired
    KorisnikRepository korisnikRepository;

    public String create(final KorisnikRequest korisnikRequest) throws ConstraintViolationException{
        //requestValidation.validateCreateRequest(korisnikRequest);
        KorisnikEntity korisnikEntity=new KorisnikEntity();
        BeanUtils.copyProperties(korisnikRequest,korisnikEntity);
        //korisnikEntity.setEmployeeInd(false);
        korisnikRepository.save(korisnikEntity);
        return "User successfully created";
    }
    public List<Korisnik> findAll(){
        List<KorisnikEntity> korisnici=korisnikRepository.findAll();
        List<Korisnik> responses=new ArrayList<Korisnik>();
        BeanUtils.copyProperties(korisnici,responses);
        return responses;
    }
    public Korisnik findById(Long id){
        requestValidation.validateId(id);
        KorisnikEntity korisnikEntity=korisnikRepository.findById(id).get();
        Korisnik korisnik=new Korisnik();
        BeanUtils.copyProperties(korisnikEntity,korisnik);
        return korisnik;
    }
public String updateKorisnik( Korisnik korisnikRequest){
        requestValidation.validateId(korisnikRequest.getId());
        KorisnikEntity korisnikEntity=korisnikRepository.findById(korisnikRequest.getId()).get();
        BeanUtils.copyProperties(korisnikRequest,korisnikEntity);
        korisnikRepository.save(korisnikEntity);
        return "Updated successfully";
}
public String deleteById(Long id){
        requestValidation.validateId(id);
        korisnikRepository.deleteById(id);
        return  "User is deleted successfully";
}
    public Racun findByUserId(final long userId) {
        return racunClient.findByUserId(userId);
    }

    public List<RacunEntity> findByUserIdEmployee(final Long userId) {
        return racunClient.getAllCreatedBy(userId);
    }

    public String pay(final List<Long> ids) {
        return racunClient.payBills(ids);
    }

    public Rezervacija allByUserId(Long id) {
        return rezervacijaClient.allByUserId(id);
    }

    public List<Rezervacija> allByCreatedBy(Long id) {
        return rezervacijaClient.allByCreatedBy(id);
    }
}
