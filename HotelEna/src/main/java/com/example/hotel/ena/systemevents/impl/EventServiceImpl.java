package com.example.hotel.ena.systemevents.impl;

import com.example.hotel.ena.systemevents.EventRequest;
import com.example.hotel.ena.systemevents.EventRequestRepository;
import com.example.hotel.ena.systemevents.EventResponse;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Optional;


@Service
public class EventServiceImpl extends EventsServiceGrpc.EventsServiceImplBase {
    private Logger logger = LogManager.getLogger(getClass());

    private final EventRequestRepository eventRequestRepository;

    public EventServiceImpl(
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