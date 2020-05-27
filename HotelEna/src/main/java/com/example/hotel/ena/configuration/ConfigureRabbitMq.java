package com.example.hotel.ena.configuration;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.*;
import org.springframework.amqp.rabbit.listener.*;
import org.springframework.context.annotation.*;

@Configuration
public class ConfigureRabbitMq {

    public static final String EXCHANGE_NAME = "racunexchange";
    public static final String QUEUE_NAME = "racunqueue";


    @Bean
    Queue createQueue() {
        return new Queue(QUEUE_NAME, true, false, false);
    }

    @Bean
    TopicExchange exchange(){
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    Binding binding(Queue q, TopicExchange exchange){
        return BindingBuilder.bind(q).to(exchange).with("racun.#");
    }

    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory
            ){
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(QUEUE_NAME);
        //container.setMessageListener(messageListenerAdapter);
        return container;
    }





}
