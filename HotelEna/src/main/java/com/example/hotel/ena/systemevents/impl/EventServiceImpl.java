package com.example.hotel.ena.systemevents.impl;

import com.example.hotel.ena.systemevents.*;
import io.grpc.*;
import io.grpc.stub.*;
import org.apache.logging.log4j.*;
import org.springframework.stereotype.*;

import java.io.*;
import java.sql.*;
import java.time.*;
import java.util.*;


@Service
public class EventsServiceImpl extends EventsServiceGrpc.EventsServiceImplBase {
    private Logger logger = LogManager.getLogger(getClass());

    private final EventRequestRepository eventRequestRepository;

    public EventsServiceImpl(
            EventRequestRepository eventRequestRepository
    ) throws IOException {
        this.eventRequestRepository = eventRequestRepository;

        Server server = ServerBuilder.forPort(8081)
                .addService(this)
                .build();

        System.out.println("Starting server...");
        server.start();
        System.out.println("Server started!");
    }


    @Override
    public void hello(
            EventRequest eventRequest, StreamObserver<EventResponse> responseObserver
    ) {
        logger.info(String.format(
                "New event received: %s %s %s %s %s %s",
                eventRequest.getActionTimestamp(),
                eventRequest.getServiceName(),
                eventRequest.getUserId(),
                eventRequest.getActionType(),
                eventRequest.getResourceName(),
                eventRequest.getResponseType()
        ));

        EventResponse response = EventResponse.newBuilder()
                .setEventResponseText("OkiDoki") // todo nigdje nije definisan odgovor RPCa?
                .build();

        EventRequest eventRequest1 = new EventRequest(
                null,
                Timestamp.from(Instant.ofEpochSecond(eventRequest.getActionTimestamp().getSeconds())),
                eventRequest.getServiceName(),
                eventRequest.getUserId(),
                Optional.ofNullable(eventRequest.getActionType()).map(Enum::name).orElse(null),
                eventRequest.getResourceName(),
                Optional.ofNullable(eventRequest.getResponseType()).map(Enum::name).orElse(null)
        );

        eventRequestRepository.save(eventRequest);

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
