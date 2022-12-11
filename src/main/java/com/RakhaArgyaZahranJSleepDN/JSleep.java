package com.RakhaArgyaZahranJSleepDN;



import com.RakhaArgyaZahranJSleepDN.dbjson.JsonDBEngine;
import org.springframework.boot.SpringApplication;
import  org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication

/**
 * Main class for the database.
 * @author Rakha Argya Zahran
 * @version 0.1
 */
public class JSleep {
    /**
     * main method
     * @param args the arguments
     */
    public static void main(String[] args) {
        JsonDBEngine.Run(JSleep.class);
        SpringApplication.run(JSleep.class, args);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> JsonDBEngine.join()));
    }


}