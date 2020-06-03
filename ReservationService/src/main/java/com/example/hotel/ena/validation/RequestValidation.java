package com.example.hotel.ena.validation;

import com.example.hotel.ena.dto.*;
import com.example.hotel.ena.exception.*;
import com.example.hotel.ena.models.ReservationEntity;
import com.example.hotel.ena.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;

@Component
public class RequestValidation {
    @Autowired
    RezervacijaRepository rezervacijaRepository;
    @Autowired
    SobaRepository sobaRepository;
    @Autowired
    SalaRepository salaRepository;
    public String validateUserId(Long user_id){
        if(user_id == null || user_id.toString().isEmpty()){
            return "User_id required";
        }
        return null;
    }

    public String validateRezervacija(Reservation reservation){
        if(reservation.getUserId()==null || reservation.getUserId().toString().isEmpty()){
            return "User_id required";
        }   else if(reservation.getCreatedBy().toString().isEmpty() || reservation.getCreatedBy() == null){
            return "CreatedBy required";
        }
        else if((rezervacijaRepository.existsByUserId(reservation.getUserId()))){
            ReservationEntity reservationEntity =rezervacijaRepository.findByUserId(reservation.getUserId());
            if(reservation.getCreatedBy().equals(reservationEntity.getCreatedBy())){
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

    public void validateRezervacijaCreateRequest(ReservationCreateRequest reservationCreateRequest){
        Long salaId= reservationCreateRequest.getHallId();
        Long sobaId= reservationCreateRequest.getRoomId();
        if(reservationCreateRequest.getValidFrom().isAfter(reservationCreateRequest.getValidTo())){
            throw new BaseException("ValidFrom is not before Valid To!", HttpStatus.BAD_REQUEST);
        }
        if(!salaRepository.existsById(salaId)){
            throw new BaseException("Hall with this id doesn't exists in database.Please choose another one.", HttpStatus.BAD_REQUEST);

        }
        else if(!sobaRepository.existsById(sobaId)){
            throw new BaseException("Room with this id doesn't exists in database.Please choose another one.", HttpStatus.BAD_REQUEST);
        }
    }
}
