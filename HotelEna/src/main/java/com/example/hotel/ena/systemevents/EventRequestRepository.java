package com.example.hotel.ena.systemevents;


import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface EventRequestRepository extends JpaRepository<EventRequest, Long> {
}
