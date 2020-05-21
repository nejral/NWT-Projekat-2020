package com.example.hotel.validation;

import com.example.hotel.dto.*;
import com.example.hotel.exception.*;
import com.example.hotel.models.*;
import com.example.hotel.repository.*;
import lombok.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;

@AllArgsConstructor
@Component
public class RequestValidation {

    KorisnikRepository korisnikRepository;

    public void validateCreateRequest(KorisnikRequest korisnikRequest) {
if(korisnikRepository.existsByUsername(korisnikRequest.getUsername())) {
            throw new BaseException("User with this username already exists in database.Please choose another one.", HttpStatus.BAD_REQUEST);
        }

    }

    public String validateLogin(KorisnikLoginRequest korisnik){
       if((korisnikRepository.existsByUsername(korisnik.getUsername()))){
            KorisnikEntity korisnikEntity=korisnikRepository.findByUsername(korisnik.getUsername());
            if(korisnik.getPassword().equals(korisnikEntity.getPassword())){
                return null;
            }
            else{
                throw new BaseException("Incorrect password!", HttpStatus.BAD_REQUEST);
            }
        }
else
           throw new BaseException("User with this username doesn't exists in database.Please choose another one.", HttpStatus.BAD_REQUEST);

    }
    public void validateId(Long id) {
        if (!korisnikRepository.existsById(id)) {
            throw new EntityNotFoundException(Korisnik.class, "id", id.toString());
        }
    }
    public void validateEmployee(Long id){
        if(!korisnikRepository.findById(id).get().getEmployeeInd()){
            throw new BaseException("Unauthorized access", HttpStatus.FORBIDDEN);
        }
    }
}
