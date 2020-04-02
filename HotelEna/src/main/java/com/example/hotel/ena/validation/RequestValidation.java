package com.example.hotel.ena.validation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RequestValidation {
   /* @Autowired
    Repository korisnikRepository;*/
    public String validateIznos(Double iznos){
        if(iznos<0 || iznos==0){
            return "Iznos is not valid!";
        }
        return null;
    }
/*
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
    }*/
}
