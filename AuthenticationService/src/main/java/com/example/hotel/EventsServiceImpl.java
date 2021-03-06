package com.example.hotel;




import com.example.hotel.repository.*;
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

        Server server = ServerBuilder.forPort(8089)
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
                .setEventResponseText("OkiDoki")
                .build();

        com.example.hotel.models.EventRequest dbEntity = new com.example.hotel.models.EventRequest(
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
