package com.hotel.ena.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hotel.ena.models.GostEntity;


@Repository
public interface GostRepository extends JpaRepository<GostEntity, Long> {

}
