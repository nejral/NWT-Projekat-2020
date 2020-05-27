package com.example.hotel.ena.validation;


import com.example.hotel.ena.dto.Korisnik;
import com.example.hotel.ena.dto.Racun;
import com.example.hotel.ena.dto.RacunRequest;
import com.example.hotel.ena.exception.BaseException;
import com.example.hotel.ena.exception.EntityNotFoundException;
import com.example.hotel.ena.models.RacunEntity;
import com.example.hotel.ena.repository.RacunRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@AllArgsConstructor
@Component
public class RequestValidation {
    //@Autowired
    RacunRepository racunRepository;

    public void validateCreateRequest(RacunRequest racunRequest) {

       if(racunRequest.getCost()<=0) {
            throw new BaseException("Cost is not valid!", HttpStatus.BAD_REQUEST);
        }

    }

    public void validateId(Long id) {
        if (!racunRepository.existsById(id)) {
            throw new EntityNotFoundException(Racun.class, "id", id.toString());
        }
    }

    public void validateCreatedBy(Long createdBy) {
        if (!racunRepository.existsByCreatedBy(createdBy)) {
            throw new EntityNotFoundException(Racun.class, "createdBy", createdBy.toString());
        }
    }


}
