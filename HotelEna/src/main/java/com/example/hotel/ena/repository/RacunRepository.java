package com.example.hotel.ena.repository;


import com.example.hotel.ena.models.RacunEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RacunRepository extends JpaRepository<RacunEntity, Long> {
     //Boolean existsByUsername(String username);
}
