package com.example.hotel;

import com.example.hotel.db.*;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Optional;

@Qualifier("serviceLogin")

@Service
public class EventsServiceImplLogin extends EventsServiceGrpc.EventsServiceImplBase {
    private Logger logger = LogManager.getLogger(getClass());
    @Autowired
    private  final EventRepository eventRepository;

    public EventsServiceImplLogin(
            EventRepository eventRepository
    ) throws IOException {
        this.eventRepository = eventRepository;

        Server server = ServerBuilder.forPort(8089)
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
                .setEventResponseText("OkiDoki") // todo nigdje nije definisan odgovor RPCa?
                .build();

        com.example.hotel.db.entity.Event event = new com.example.hotel.db.entity.Event(
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
