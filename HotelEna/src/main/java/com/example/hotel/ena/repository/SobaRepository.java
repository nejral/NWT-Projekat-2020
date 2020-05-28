package com.example.hotel.ena.repository;


import com.example.hotel.ena.models.SobaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SobaRepository extends JpaRepository<SobaEntity, Long> {
    //Boolean existsByUserId(Long user_id);

    //SobaEntity findByUserId(Long user_id);

}
