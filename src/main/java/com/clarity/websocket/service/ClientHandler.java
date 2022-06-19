package com.clarity.websocket.service;

import com.clarity.websocket.enums.AlarmFieldEnum;
import com.clarity.websocket.model.Alarm;
import com.clarity.websocket.websocket.WebSocketSender;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * client handler, receive new change, filter, buffering, and send data to websocket
 */
@Slf4j
@Data
public class ClientHandler {
    private static final int QUEUE_CAPACITY = 20000;
    private final String sessionId;
    private final String token;
    private final WebSocketSender webSocketSender;
    private final AtomicBoolean faultRunning = new AtomicBoolean(false);


    private final BlockingQueue<Map<String, String>> faultBuffer = new LinkedBlockingQueue<>(QUEUE_CAPACITY);

    ClientHandler(String sessionId, String token, WebSocketSender webSocketSender) {
        this.sessionId = sessionId;
        this.token = token;
        this.webSocketSender = webSocketSender;
    }

    public String getSessionId() {
        return sessionId;
    }

    /**
     * pause/resume sending fault data
     * when client pause receiving data all new data store in the buffer
     */
    void pauseFault() {
        faultRunning.set(!faultRunning.get());
    }

    /**
     * Start sending fault data to client
     */
    void startFault() {
        faultRunning.set(true);
    }

    /**
     * Check client pause/resume receiving data
     *
     * @return true if running, false if paused
     */
    private boolean isRunningFault() {
        return faultRunning.get();
    }

    public void receiveData( Map<AlarmFieldEnum, String> alarmEnumMap) {
        webSocketSender.send(sessionId, "/alarm/", "create", alarmEnumMap);
    }
}
