package com.RakhaArgyaZahranJSleepDN;



import com.RakhaArgyaZahranJSleepDN.dbjson.JsonDBEngine;
import org.springframework.boot.SpringApplication;
import  org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication

public class JSleep {
    public static void main(String[] args) {
        JsonDBEngine.Run(JSleep.class);
        SpringApplication.run(JSleep.class, args);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> JsonDBEngine.join()));
    }


}