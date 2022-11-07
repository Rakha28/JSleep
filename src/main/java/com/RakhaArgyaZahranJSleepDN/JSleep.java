package com.RakhaArgyaZahranJSleepDN;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import org.springframework.boot.SpringApplication;
import  org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication

public class JSleep {
    public static void main(String[] args) {

        SpringApplication.run(JSleep.class, args);
        for(int i = 0; i < 10; i++){


            ThreadingObject thread = new ThreadingObject("Thread " + i);

            thread.start();


        }

        try {
            String filepath = "src//json//account.json";


            JsonTable<Account> tableAccount = new JsonTable<>(Account.class,filepath);


            tableAccount.add(new Account("name","email","password"));


            tableAccount.writeJson();

            tableAccount = new JsonTable<>(Account.class, filepath);

            tableAccount.forEach(account -> System.out.println(account.toString()));

        }catch (Throwable t){
            t.printStackTrace();


        }

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