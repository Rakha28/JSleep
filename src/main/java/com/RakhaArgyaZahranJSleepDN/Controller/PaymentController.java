package com.RakhaArgyaZahranJSleepDN.Controller;

import com.RakhaArgyaZahranJSleepDN.*;
import com.RakhaArgyaZahranJSleepDN.dbjson.JsonAutowired;
import com.RakhaArgyaZahranJSleepDN.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    @PostMapping("/create")
    Payment create (@RequestParam int buyerId, @RequestParam int renterId, @RequestParam int roomId, @RequestParam String from, @RequestParam String to) throws ParseException {
        Account buyer = Algorithm.<Account>find(new AccountController().getJsonTable(), account -> account.id == buyerId);
        Account renter = Algorithm.<Account>find(new AccountController().getJsonTable(), account -> account.id == renterId);
        Room room = RoomController.roomTable.get(roomId);
        if (buyer == null || renter == null || room == null)
            return null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fromDate = sdf.parse(from);
        Date toDate = sdf.parse(to);
        Payment payment = new Payment(buyerId, renterId, roomId, fromDate, toDate);

        double total = (room.price) * (toDate.getTime() - fromDate.getTime()) / (1000 * 60 * 60 * 24);
        boolean lebihbesar = buyer.balance >= total;

        if (lebihbesar) {
            buyer.balance -= total;
            payment.status = Payment.PaymentStatus.WAITING;
            paymentTable.add(payment);
            payment.makeBooking(fromDate, toDate, room);
            return payment;
        }
        else {
            return null;
        }

    }

    @PostMapping("/{id}/accept")
    boolean accept (@PathVariable int id) {
        Payment payment = Algorithm.<Payment>find(paymentTable, predicate -> predicate.id == id);
        if (payment == null)
            return false;
        payment.status = Payment.PaymentStatus.SUCCESS;
        return true;
    }

    @PostMapping("/{id}/cancel")
    boolean cancel (@PathVariable int id) {
        Payment payment = Algorithm.<Payment>find(paymentTable, predicate -> predicate.id == predicate.buyerId);
        Room room = Algorithm.<Room>find(RoomController.roomTable, predicate -> predicate.id == payment.getRoomId());
        if (payment == null)
            return false;
        Account buyer = Algorithm.<Account>find(new AccountController().getJsonTable(), account -> account.id == payment.buyerId);
        buyer.balance += room.price;
        payment.status = Payment.PaymentStatus.FAILED;


        return true;
    }





}
