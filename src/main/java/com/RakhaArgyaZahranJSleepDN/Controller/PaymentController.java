package com.RakhaArgyaZahranJSleepDN.Controller;

import com.RakhaArgyaZahranJSleepDN.*;
import com.RakhaArgyaZahranJSleepDN.dbjson.JsonAutowired;
import com.RakhaArgyaZahranJSleepDN.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment> {

    @JsonAutowired(value = Account.class,filepath ="\"C:\\Users\\RakhaArgya\\OneDrive\\Dokumen\\Argy\\PRAKTIKUM OOP\\JSleep\\lib\\payment.json\"" )
    public static JsonTable<Payment> paymentTable;

    @GetMapping
    public JsonTable getJsonTable(){
        return paymentTable;
    }

    @PostMapping("/{id}/accept")
    boolean accept (@PathVariable int id){

        return false;
    }

    @PostMapping("/{id}/cancel")
    boolean cancel (@PathVariable int id){

        return false;
    }

    @PostMapping("/{id}/create")
    Payment create (@RequestParam int buyerId, @RequestParam int renterId, @RequestParam int roomId, @RequestParam String from, @RequestParam String to){

        return null;
    }
}
