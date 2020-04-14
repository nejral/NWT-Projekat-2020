package com.example.hotel.ena.service;

import com.example.hotel.ena.dto.*;
import com.example.hotel.ena.exception.*;
import com.example.hotel.ena.mapper.*;
import com.example.hotel.ena.models.*;
import com.example.hotel.ena.repository.*;
import com.example.hotel.ena.rest.RacunClient;
import com.example.hotel.ena.rest.RezervacijaClient;
import com.example.hotel.ena.validation.RequestValidation;
import lombok.AllArgsConstructor;
import org.springframework.beans.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.*;
import java.util.List;

@AllArgsConstructor
@Service
public class KorisnikService {

    RacunClient racunClient;
    RezervacijaClient rezervacijaClient;
    RequestValidation requestValidation;
    KorisnikMapper korisnikMapper;
    KorisnikRepository korisnikRepository;

    public String create(final KorisnikRequest korisnikRequest) throws ConstraintViolationException{
        requestValidation.validateCreateRequest(korisnikRequest);
        KorisnikEntity korisnikEntity = korisnikMapper.dtoToEntity(korisnikRequest);
        korisnikEntity.setEmployeeInd(false);
        korisnikRepository.save(korisnikEntity);
        return "User successfully created";
    }
    public List<Korisnik> findAll(){
        List<Korisnik> korisnici=korisnikMapper.entitiesToDtos(korisnikRepository.findAll());
        return korisnici;
    }
public Korisnik findById(Long id){
        requestValidation.validateId(id);
        return korisnikMapper.entityToDto(korisnikRepository.findById(id).get());
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

    public List<Racun> findByUserIdEmployee(final Long userId) {
        return racunClient.getAllCreatedBy(userId);
    }

    public String pay(final List<Long> ids) {
        return racunClient.payBills(ids);
    }

    public Rezervacija allByUserId(Long id) {
        return rezervacijaClient.allByUserId(id);
    }

    public Rezervacija allByCreatedBy(Long id) {
        return rezervacijaClient.allByCreatedBy(id);
    }
}
