package com.clarity.websocket.dto;

import com.clarity.websocket.enums.AlarmFieldEnum;
import com.clarity.websocket.model.Alarm;
import lombok.Getter;

import java.util.Map;

/**
 * used for sending data to client
 */
@Getter
public class MessageContainerDTO {


    private final String sessionId;
    private final String topic;
    private final String endPoint;
    private Alarm alarm;
    Map<AlarmFieldEnum, String> alarmEnumMap;

    public MessageContainerDTO(String sessionId, String topic, String endPoint) {
        this.sessionId = sessionId;
        this.topic = topic;
        this.endPoint = endPoint;
    }


    public MessageContainerDTO setAlarmMap(Map<AlarmFieldEnum, String> alarmEnumMap) {
        this.alarmEnumMap = alarmEnumMap;
        return this;
    }


    public MessageContainerDTO setAlarm(Alarm alarm) {
        this.alarm = alarm;
        return this;
    }
}
