package com.clarity.websocket;

import com.clarity.websocket.service.DataHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@EnableScheduling
@RequiredArgsConstructor
@EnableAsync
public class WebsocketApplication {


    public static void main(String[] args) {
        SpringApplication.run(WebsocketApplication.class, args);
    }



}
