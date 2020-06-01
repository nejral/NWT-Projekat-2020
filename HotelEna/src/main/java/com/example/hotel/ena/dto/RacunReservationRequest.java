package com.example.hotel.ena.dto;

import lombok.Data;

@Data
public class RacunReservationRequest {
      private Long reservationId;
    private Long createdBy;
    private Long userId;
    private double cost;

}
