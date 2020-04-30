package com.example.hotel.ena.systemevents;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRequestRepository extends JpaRepository<EventRequest, Long> {
}
