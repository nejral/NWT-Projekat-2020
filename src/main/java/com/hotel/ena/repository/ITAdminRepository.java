package com.hotel.ena.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ba.com.zira.template.dao.model.translation.RezervacijaEntity;


@Repository
public interface ITAdminRepository extends JpaRepository<ba.com.zira.template.dao.model.translation.ITAdminEntity, Long> {

}
