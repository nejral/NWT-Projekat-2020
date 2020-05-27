package com.example.hotel.ena.repository;

import com.example.hotel.ena.dto.*;
import com.example.hotel.ena.models.RezervacijaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface RezervacijaRepository extends JpaRepository<RezervacijaEntity, Long> {
     Boolean existsByUserId(Long user_id);

    RezervacijaEntity findByUserId(Long user_id);

    List<RezervacijaEntity> findByCreatedBy(Long createdBy);

    Optional<RezervacijaEntity> findByRacunId(Long racunId);

}
