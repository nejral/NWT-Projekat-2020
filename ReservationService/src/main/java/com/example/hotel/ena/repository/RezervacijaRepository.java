package com.example.hotel.ena.repository;

import com.example.hotel.ena.models.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface RezervacijaRepository extends JpaRepository<ReservationEntity, Long> {
     Boolean existsByUserId(Long user_id);

    ReservationEntity findByUserId(Long user_id);

    List<ReservationEntity> findByCreatedBy(Long createdBy);



}
