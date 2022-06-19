package com.clarity.websocket.service;


import com.clarity.websocket.enums.AlarmFieldEnum;
import com.clarity.websocket.model.Alarm;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumer {

    private final Gson gson;
    private final DataHandler dataHandler;

    @org.springframework.kafka.annotation.KafkaListener(topicPartitions = @org.springframework.kafka.annotation.TopicPartition(topic = "${RMS.kafka.topic}",
            partitionOffsets = {@PartitionOffset(partition = "0", initialOffset = "-1")}))
    void listener(String data) {
        Map<AlarmFieldEnum , String> alarmFieldEnumsMap = gson.fromJson(data, Map.class);
        log.info("Start Listener From Topic Alarm : {}" ,alarmFieldEnumsMap );
        System.out.println("\n " + alarmFieldEnumsMap + "\n");
        try {
            dataHandler.clients.values().forEach(clientHandler -> {
                clientHandler.receiveData(alarmFieldEnumsMap);
            });
        } catch (Exception e) {
            System.out.println(e.getCause() + "  " + e.getMessage());
        }
    }


}