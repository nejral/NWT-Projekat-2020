package com.example.hotel.ena.systemevents.impl;



import com.example.hotel.ena.db.*;
import com.system.systemevents.*;
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

        Server server = ServerBuilder.forPort(8088)
                .addService(this)
                .build();

        System.out.println("Starting server...");
        server.start();
        System.out.println("Server started!");
    }


    @Override
    public void hello(
            com.system.systemevents.EventRequest request, StreamObserver<EventResponse> responseObserver
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
                .setEventResponseText("Okej") // todo nigdje nije definisan odgovor RPCa?
                .build();

        com.example.hotel.ena.db.entity.EventRequest dbEntity = new com.example.hotel.ena.db.entity.EventRequest(
                null,
                Timestamp.from(Instant.ofEpochSecond(request.getActionTimestamp().getSeconds())),
                request.getServiceName(),
                request.getUserId(),
                Optional.ofNullable(request.getActionType()).map(Enum::name).orElse(null),
                request.getResourceName(),
                Optional.ofNullable(request.getResponseType()).map(Enum::name).orElse(null)
        );

        eventRequestRepository.save(dbEntity);

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}