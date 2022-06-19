package com.clarity.websocket.utils;

import com.clarity.websocket.service.DataHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.socket.messaging.SessionConnectEvent;


import java.util.Objects;


/**
 * check client connected
 */
@Component
@Slf4j
public class StompConnectEvent implements ApplicationListener<SessionConnectEvent> {

    private final DataHandler dataHandler;


    public StompConnectEvent(DataHandler dataHandler) {
        this.dataHandler = dataHandler;
    }

    /**
     * call when client successfully connected
     *
     * @param event information of connected client
     */
    public void onApplicationEvent(SessionConnectEvent event) {
        StompHeaderAccessor sha = StompHeaderAccessor.wrap(event.getMessage());
        log.info("Connect event [sessionId: " + sha.getSessionId());
        String token = Objects.requireNonNull(sha.getNativeHeader("Authorization"), "Authorization must not be null").get(0);
        dataHandler.addClient(sha.getSessionId(), token);
    }
}
