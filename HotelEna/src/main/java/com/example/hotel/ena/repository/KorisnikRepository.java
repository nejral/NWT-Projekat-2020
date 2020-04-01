package com.example.hotel.ena.repository;

import com.example.hotel.ena.models.KorisnikEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KorisnikRepository extends JpaRepository<KorisnikEntity, Long> {
     Boolean existsByUsername(String username);
}
