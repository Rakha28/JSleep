package com.RakhaArgyaZahranJSleepDN;


import java.util.List;

import com.RakhaArgyaZahranJSleepDN.dbjson.JsonDBEngine;
import com.RakhaArgyaZahranJSleepDN.dbjson.JsonTable;
import org.springframework.boot.SpringApplication;
import  org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication

public class JSleep {
    public static void main(String[] args) {
        JsonDBEngine.Run(JSleep.class);
        SpringApplication.run(JSleep.class, args);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> JsonDBEngine.join()));


    }

    public static List<Room> filterByAccountId(List<Room> list, int accountId, int page, int pageSize){

        return Algorithm.<Room>paginate(list,page,pageSize,room -> room.accountId == accountId);
    }

    public static List<Room> filterByPrice(List<Room> list, double min, double max){
        return Algorithm.<Room>collect(list,room -> room.price.price >= min && room.price.price <= max);
    }

    public static List<Room> filterByCity(List<Room> list, String search, int page, int pageSize){
        return Algorithm.paginate(list, page, pageSize, room -> room.city.toString().toLowerCase().contains(search.toLowerCase()));
    }


}