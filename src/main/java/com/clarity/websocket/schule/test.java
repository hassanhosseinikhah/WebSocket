//package com.clarity.websocket.schule;
//
//import com.clarity.websocket.service.DataHandler;
//import lombok.RequiredArgsConstructor;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//
//@RequiredArgsConstructor
//@Component
//public class test {
//
//    private final DataHandler dataHandler;
//
//
//    @Scheduled(fixedDelay = 1000 , initialDelay = 2000)
//    public void sendData() {
//        String myStr = "parham";
//        try {
//            dataHandler.clients.values().forEach(clientHandler -> {
//                clientHandler.receiveData(myStr);
//            });
//        } catch (Exception e) {
//            e.getStackTrace();
//        }
//    }
//}
