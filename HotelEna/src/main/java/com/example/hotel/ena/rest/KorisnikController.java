package com.example.hotel.ena.rest;

import com.example.hotel.ena.models.KorisnikEntity;
import com.example.hotel.ena.dto.Korisnik;
import com.example.hotel.ena.repository.KorisnikRepository;
import com.example.hotel.ena.validation.RequestValidation;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@AllArgsConstructor
@RestController
@RequestMapping("/korisnik")
public class KorisnikController {
    private KorisnikRepository korisnikRepository;
    private RequestValidation requestValidation;
@PostMapping()
    public String create(@RequestBody Korisnik korisnik){
    if(requestValidation.validateUsername(korisnik.getUsername())==null){
        KorisnikEntity korisnikEntity=new KorisnikEntity();
        BeanUtils.copyProperties(korisnik,korisnikEntity);
        korisnikRepository.save(korisnikEntity);
        return "Successfully created!";
    }

    return requestValidation.validateUsername(korisnik.getUsername());

}
}
