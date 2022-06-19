package com.clarity.websocket.websocket;


import com.clarity.websocket.dto.MessageContainerDTO;
import com.clarity.websocket.enums.AlarmFieldEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

@Component
@Slf4j
public class WebSocketSender {
    private final SimpMessagingTemplate messagingTemplate;
    private final BlockingDeque<MessageContainerDTO> alarmBlockingQueue = new LinkedBlockingDeque<>();

    public WebSocketSender(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    /**
     * Set data to the blocking queue for sending to clients
     *
     * @param sessionId session ID
     * @param topic     topic for send to client
     */
    public void send(String sessionId, String topic, String endPoint, Map<AlarmFieldEnum, String> alarmEnumMap) {
        this.alarmBlockingQueue.add(new MessageContainerDTO(sessionId, topic, endPoint).setAlarmMap(alarmEnumMap));
    }

    /**
     * Thread that always checks blocking queue, And sends data with web socket
     */
    @Async
    public void sender() {
            while (true) {
                try {
                    MessageContainerDTO message = this.alarmBlockingQueue.takeLast();
                    log.info("sending... to session='{}'", message.getSessionId());
                    this.messagingTemplate.convertAndSend("/topic" + message.getTopic() + message.getEndPoint(), message.getAlarmEnumMap());
                } catch (Exception e) {
                    log.error(e.getMessage());
                    Thread.currentThread().interrupt();
                }
            }
    }


    /**
     * sends kill client handler to client
     *
     * @param sessionId session ID
     */
    void killWebSocket(String sessionId) {
        this.messagingTemplate.convertAndSendToUser(sessionId, "/general/kill", "kill");

    }
}
