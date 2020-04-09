package com.example.hotel.ena.validation;

import com.example.hotel.ena.dto.Rezervacija;
import com.example.hotel.ena.models.RezervacijaEntity;
import com.example.hotel.ena.repository.RezervacijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RequestValidation {
    @Autowired
    RezervacijaRepository rezervacijaRepository;
    public String validateUserId(Long user_id){
        if(user_id == null || user_id.toString().isEmpty()){
            return "User_id required";
        }
        return null;
    }

    public String validateRezervacija(Rezervacija rezervacija){
        if(rezervacija.getUserId()==null || rezervacija.getUserId().toString().isEmpty()){
            return "User_id required";
        }   else if(rezervacija.getCreatedBy().toString().isEmpty() || rezervacija.getCreatedBy() == null){
            return "CreatedBy required";
        }
        else if((rezervacijaRepository.existsByUserId(rezervacija.getUserId()))){
            RezervacijaEntity rezervacijaEntity=rezervacijaRepository.findByUserId(rezervacija.getUserId());
            if(rezervacija.getCreatedBy().equals(rezervacijaEntity.getCreatedBy())){
                return null;
            }
            else{
                return "Incorrect CreatedBy";
            }
        }

        return null;
    }
    public String validateId(Long id){
        if(rezervacijaRepository.existsById(id))
            return null;
        else
            return "Rezervacija with id does not exist!";
    }
}
