package com.example.hotel.ena;

import com.example.hotel.ena.*;
import com.example.hotel.ena.db.*;
import io.grpc.*;
import io.grpc.stub.*;
import org.apache.logging.log4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.io.*;
import java.sql.*;
import java.time.*;
import java.util.*;

@Qualifier("serviceRezervacija")

@Service
public class EventsServiceImplRacun extends EventsServiceGrpc.EventsServiceImplBase {
    private Logger logger = LogManager.getLogger(getClass());
    @Autowired
    private  final EventRepository eventRepository;

    public EventsServiceImplRacun(
            EventRepository eventRepository
    ) throws IOException {
        this.eventRepository = eventRepository;

        Server server = ServerBuilder.forPort(8088)
                .addService(this)
                .build();

        System.out.println("Starting server...");
        server.start();
        System.out.println("Server started!");
    }


    @Override
    public void hello(
            EventRequest request, StreamObserver<EventResponse> responseObserver
    ) {
        logger.info(String.format(
                "New event received: %s %s %s %s %s %s",
                request.getActionTimestamp(),
                request.getServiceName(),
                request.getUserId(),
                request.getActionType(),
                request.getResourceName(),
                request.getResponseType()
        ));

        EventResponse response = EventResponse.newBuilder()
                .setEventResponseText("OkiDoki")
                .build();

        com.example.hotel.ena.db.entity.Event event = new com.example.hotel.ena.db.entity.Event(
                null,
                Timestamp.from(Instant.ofEpochSecond(request.getActionTimestamp().getSeconds())),
                request.getServiceName(),
                request.getUserId(),
                Optional.ofNullable(request.getActionType()).map(Enum::name).orElse(null),
                request.getResourceName(),
                Optional.ofNullable(request.getResponseType()).map(Enum::name).orElse(null)
        );

        eventRepository.save(event);

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
