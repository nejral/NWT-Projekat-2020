package com.example.hotel.ena.validation;

import com.example.hotel.ena.dto.Soba;
import com.example.hotel.ena.repository.SobaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class RequestValidationSoba {
    @Autowired
    SobaRepository sobaRepository;

    public String validateSoba(Soba soba){


        return null;
    }

    public String validateId(Long id){
        if(sobaRepository.existsById(id))
            return null;
        else
            return "Soba with id does not exist!";
    }
}