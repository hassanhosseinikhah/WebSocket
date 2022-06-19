package com.clarity.websocket.service;

import com.clarity.websocket.websocket.WebSocketSender;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * handle clients, all changed data
 */
@Component
@Slf4j
public class DataHandler {

    private final WebSocketSender webSocketSender;
    public Map<String, ClientHandler> clients = new ConcurrentHashMap<>();


    @Autowired
    public DataHandler(WebSocketSender webSocketSender) {
        this.webSocketSender = webSocketSender;

    }

    /**
     * Add new client
     *
     * @param session session ID for each client
     * @param token   information of user
     */
    public void addClient(String session, String token) {
        if (clients.containsKey(session))
            return;
        ClientHandler clientHandler = new ClientHandler(session, token, this.webSocketSender);
        clients.put(session, clientHandler);
    }

    /**
     * Set fault configuration(filters) for new client
     *
     * @param sessionId              session ID
     * @param clientConfigurationDTO configuration for filtering data {@link FilterDTO}
     */


    /**
     * Start sending fault changes to the client
     *
     * @param sessionId session ID
     */
    public void startFault(String sessionId) {
        if (clients.containsKey(sessionId)) {
            clients.get(sessionId).startFault();
            log.info("Fault started for : " + sessionId);
        }
    }

    /**
     * pause/resume sending fault changes to the client
     *
     * @param sessionId session ID
     */
    public void pauseFault(String sessionId) {
        if (clients.containsKey(sessionId)) {
            clients.get(sessionId).pauseFault();
            log.info("Fault paused for : " + sessionId);
        }
    }


    /**
     * Stop sending data to the client for ever
     *
     * @param sessionId id of client
     */
    public void stop(String sessionId) {
        clients.remove(sessionId);
    }
}
