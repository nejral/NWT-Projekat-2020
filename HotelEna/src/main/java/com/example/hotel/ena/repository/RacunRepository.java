package com.example.hotel.ena.repository;


import com.example.hotel.ena.dto.Racun;
import com.example.hotel.ena.models.RacunEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RacunRepository extends JpaRepository<RacunEntity, Long> {
     //Boolean existsByUsername(String username);
    RacunEntity findByUserId(Long userId);
    List<RacunEntity> findByCreatedBy(Long createdBy);
    RacunEntity findByReservationId(Long reservationId);
}
