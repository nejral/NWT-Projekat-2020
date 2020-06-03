package com.example.hotel.ena.db;


import com.example.hotel.ena.db.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
}