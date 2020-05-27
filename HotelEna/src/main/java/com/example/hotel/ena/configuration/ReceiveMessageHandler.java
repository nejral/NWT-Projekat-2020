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
    public static final String topicExchangeName = "spring-boot-exchange";
    @Autowired
RacunRepository racunRepository;
    @Autowired
RabbitTemplate rabbitTemplate;
    public void receiveMessage(Long messageBody) {
        log.info("HandleMessage!!!");

            try {
                RacunEntity racunEntity = racunRepository.findById(messageBody).get();
                log.info(racunEntity.toString());
                racunEntity.setPaid(true);
                racunRepository.save(racunEntity);
            } catch (Exception e) {
                log.info(e.getMessage());
              rabbitTemplate.convertAndSend(topicExchangeName,
                      "foo.bar.baz","failed " + messageBody);
            }
    }
    public void receiveMessage(String failMessage){
        log.info("Handle Fail Message!!!");
        log.info(failMessage);
        log.info(failMessage.substring(7));
        RacunEntity racunEntity=racunRepository.findById(Long.valueOf(failMessage.substring(7))).get();
        racunEntity.setPaid(false);
        racunRepository.save(racunEntity);
    }
}
