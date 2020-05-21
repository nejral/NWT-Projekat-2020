package com.example.hotel.ena.rabbit;


import com.example.hotel.ena.*;
import org.springframework.amqp.rabbit.core.*;
import org.springframework.boot.*;
import org.springframework.stereotype.*;

import java.util.concurrent.*;

@Component
public class Runner implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;
    private final Receiver receiver;

    public Runner(Receiver receiver, RabbitTemplate rabbitTemplate) {
        this.receiver = receiver;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Sending message...");
        //rabbitTemplate.convertAndSend(HotelEnaApplication.topicExchangeName, "foo.bar.baz", "Hello from RabbitMQ!");
        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
    }

}
