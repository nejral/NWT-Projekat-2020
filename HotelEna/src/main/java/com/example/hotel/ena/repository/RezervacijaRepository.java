package com.example.hotel.ena.repository;

import com.example.hotel.ena.models.RezervacijaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RezervacijaRepository extends JpaRepository<RezervacijaEntity, Long> {
     Boolean existsByUser_id(Long user_id);

    RezervacijaEntity findByUser_id(Long user_id);
}
