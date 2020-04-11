package com.example.hotel.ena.validation;


import com.example.hotel.ena.dto.Korisnik;
import com.example.hotel.ena.dto.Racun;
import com.example.hotel.ena.models.RacunEntity;
import com.example.hotel.ena.repository.RacunRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Component
public class RequestValidation {
    @Autowired
    RacunRepository racunRepository;
    public String validateIznos(Double iznos){
        if(iznos<0 || iznos==0){
            return "Iznos is not valid!";
        }
        return null;
    }

    public String validateDelete(Long id){
        if(!racunRepository.existsById(id)){
            return "Racun not deleted successfully";
        }
        return null;
    }
  /*  public String validateId(Long id){
        if(racunRepository.existsById(id))
            return null;
        else
            return "Racun with id does not exist!";
    }u controlleru u delete*/

   /* public String validateRacun(Racun racun){
        if(racun.getId().toString().isEmpty() || racun.getId()==null){
            return "Id required";
        }
        else if(racun.getCost() == 0){
            return "Cost required";
        }
        else if((racunRepository.existsById(racun.getId()))){
            Optional<RacunEntity> racunEntity=racunRepository.findById(racun.getId());
            if(racun.getCost()==(racunEntity.get().getCost())){
                return null;
            }
            else{
                return "Incorrect cost";
            }
        }
        return null;
    }*/
}
