package com.example.hotel.ena.configuration;

import com.example.hotel.ena.models.*;
import com.example.hotel.ena.repository.*;
import lombok.extern.slf4j.*;
import org.springframework.amqp.rabbit.core.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
@Slf4j
public class ReceiveMessageHandler {
@Autowired
RezervacijaRepository rezervacijaRepository;
    @Autowired
RabbitTemplate rabbitTemplate;
    @Autowired
    SobaRepository sobaRepository;
    @Autowired
    SalaRepository salaRepository;
    public static final String topicExchangeName = "spring-boot-exchange";
    public void receiveMessage(Long messageBody) {
        log.info("HandleMessage!!!");

            try {
                ReservationEntity reservationEntity = rezervacijaRepository.findById(messageBody).get();
                reservationEntity.setDone(true);
                rezervacijaRepository.save(reservationEntity);
                RoomEntity roomEntity =sobaRepository.findById(reservationEntity.getRoomId()).get();
                if(roomEntity !=null) {
                    roomEntity.setBusy(false);
                    sobaRepository.save(roomEntity);
                }
                SalaEntity salaEntity=salaRepository.findById(reservationEntity.getHallId()).get();
                if(salaEntity!=null) {
                    salaEntity.setBusy(false);
                    salaRepository.save(salaEntity);
                }
            } catch (Exception e) {
                log.info("Failed");
                log.info(e.getMessage());
                rezervacijaRepository.findById(messageBody).get().setDone(false);
                salaRepository.findById( rezervacijaRepository.findById(messageBody).get().getHallId()).get().setBusy(true);
                sobaRepository.findById( rezervacijaRepository.findById(messageBody).get().getRoomId()).get().setBusy(true);
                rabbitTemplate.convertAndSend(topicExchangeName,
                        "foo.bar.baz","failed " + messageBody);
            }
        }

public void receiveMessage(String failMessage){
    log.info("Handle Fail Message!!!");
     log.info(failMessage);
     log.info(failMessage.substring(7));
    ReservationEntity reservationEntity =rezervacijaRepository.findById(Long.valueOf(failMessage.substring(7))).get();
      reservationEntity.setDone(false);
      rezervacijaRepository.save(reservationEntity);
      return;
}
}
