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

RezervacijaRepository rezervacijaRepository;
    @Autowired
RabbitTemplate rabbitTemplate;
    public static final String topicExchangeName = "spring-boot-exchange";
    public void receiveMessage(Long messageBody) {
        log.info("HandleMessage!!!");

            try {
                RezervacijaEntity rezervacijaEntity = rezervacijaRepository.findByRacunId(messageBody).get();
                rezervacijaEntity.setDone(true);
                rezervacijaRepository.save(rezervacijaEntity);
            } catch (Exception e) {
                log.info("Failed");
                log.info(e.getMessage());
                rabbitTemplate.convertAndSend(topicExchangeName,
                        "foo.bar.baz","failed " + messageBody);
            }
        }

public void receiveMessage(String failMessage){
    log.info("Handle Fail Message!!!");
     log.info(failMessage);
     log.info(failMessage.substring(7));
    RezervacijaEntity rezervacijaEntity=rezervacijaRepository.findByRacunId(Long.valueOf(failMessage.substring(7))).get();
      rezervacijaEntity.setDone(false);
      rezervacijaRepository.save(rezervacijaEntity);
}
}
