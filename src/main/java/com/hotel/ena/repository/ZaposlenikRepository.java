package com.hotel.ena.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.ena.models.ZaposlenikEntity;
@Repository
public interface ZaposlenikRepository extends JpaRepository<ZaposlenikEntity, Long> {
}
