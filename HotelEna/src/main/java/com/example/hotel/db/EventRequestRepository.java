package com.example.hotel.db;


import com.example.hotel.db.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface EventRequestRepository extends JpaRepository<EventRequest, Long> {
}
