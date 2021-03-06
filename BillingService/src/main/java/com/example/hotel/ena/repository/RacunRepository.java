package com.example.hotel.ena.repository;


import com.example.hotel.ena.dto.Racun;
import com.example.hotel.ena.models.RacunEntity;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface RacunRepository extends JpaRepository<RacunEntity, Long> {
     //Boolean existsById(Long id);
    //String validateId(Long id);
    RacunEntity findByUserId(Long userId);
    Boolean existsByCreatedBy(Long createdBy);
    //List<RacunEntity> findByUserId(Long userId);
   List<RacunEntity> findByCreatedBy(Long createdBy);
    RacunEntity findByReservationId(Long reservationId);
    //RacunEntity findByCreatedBy(Long createdBy);
}
