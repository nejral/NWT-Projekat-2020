package com.example.hotel.interceptor;

import com.google.protobuf.*;
import com.system.systemevents.*;
import io.grpc.*;
import org.apache.logging.log4j.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.web.servlet.handler.*;

import javax.servlet.http.*;
import java.time.*;

@Component
public class EventInterceptor extends HandlerInterceptorAdapter {
    private final EventsServiceGrpc.EventsServiceBlockingStub eventsService;

    private final Logger logger = LogManager.getLogger(getClass());

    public EventInterceptor(
            @Value("${grpc.host}") String grpcHost,
            @Value("${grpc.port}") Integer grpcPort
    ) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(grpcHost, grpcPort)
                .usePlaintext()
                .build();

        eventsService = EventsServiceGrpc.newBlockingStub(channel);
    }
    
    // before sending request to controller
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception exception) {

        HttpMethod httpMethod = HttpMethod.valueOf(request.getMethod().toUpperCase());
        EventRequest.ActionType actionType;
        switch (httpMethod) {
            case GET:
                actionType = EventRequest.ActionType.GET;
                break;
            case HEAD:
                actionType = EventRequest.ActionType.HEAD;
                break;
            case POST:
                actionType = EventRequest.ActionType.POST;
                break;
            case PUT:
                actionType = EventRequest.ActionType.PUT;
                break;
            case PATCH:
                actionType = EventRequest.ActionType.PATCH;
                break;
            case DELETE:
                actionType = EventRequest.ActionType.DELETE;
                break;
            case OPTIONS:
                actionType = EventRequest.ActionType.OPTIONS;
                break;
            case TRACE:
                actionType = EventRequest.ActionType.TRACE;
                break;
            default:
                logger.error("Unknown http method! " + httpMethod);
                actionType = null;
        }

        int status = response.getStatus();
        EventRequest.ResponseType responseType = status >= 200 && status < 400
                ? EventRequest.ResponseType.Success
                : EventRequest.ResponseType.Failure;

        String resourceName = request.getRequestURI();

        EventResponse res = eventsService.hello(
                EventRequest.newBuilder()
                        .setServiceName("racun")
                        .setActionTimestamp(Timestamp.newBuilder().setSeconds(Instant.now().getEpochSecond()).build())
                        .setUserId(0) 
                        .setActionType(actionType)
                        .setResourceName(resourceName)
                        .setResponseType(responseType)
                        .build()
        );
        
        System.out.println(actionType.toString() + " " + resourceName.toString() + " " + responseType.toString());
    }
}
