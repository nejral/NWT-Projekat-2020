package com.example.hotel.ena.validation;

import com.example.hotel.ena.dto.Korisnik;
import com.example.hotel.ena.models.KorisnikEntity;
import com.example.hotel.ena.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RequestValidation {
    @Autowired
    KorisnikRepository korisnikRepository;
    public String validateUsername(String username){
        if(username.isEmpty() || username==null){
            return "Username required";
        }
        return null;
    }

    public String validateKorisnik(Korisnik korisnik){
        if(korisnik.getUsername().isEmpty() || korisnik.getUsername()==null){
            return "Username required";
        }   else if(korisnik.getPassword().isEmpty() || korisnik.getPassword()==null){
            return "Password required";
        }
        else if((korisnikRepository.existsByUsername(korisnik.getUsername())){
            KorisnikEntity korisnikEntity=korisnikRepository.findByUsername(korisnik.getUsername());
            if(korisnik.getPassword().equals(korisnikEntity.getPassword())){
                return null;
            }
            else{
                return "Incorrect password";
            }
        }
        return null;
    }
}
