package com.RakhaArgyaZahranJSleepDN.controller;

import com.RakhaArgyaZahranJSleepDN.*;
import com.RakhaArgyaZahranJSleepDN.dbjson.JsonAutowired;
import com.RakhaArgyaZahranJSleepDN.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.RakhaArgyaZahranJSleepDN.controller.AccountController.accountTable;
import static com.RakhaArgyaZahranJSleepDN.controller.RoomController.roomTable;


/**
 * @author Rakha Argya Zahran
 * class for handling payment
 */
@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment>{
    @JsonAutowired(value= Payment.class,
            filepath="C:\\Users\\RakhaArgya\\OneDrive\\Dokumen\\Argy\\PRAKTIKUM OOP\\JSleep\\lib\\payments.json")

    public static JsonTable<Payment> paymentTable;


    /**
     * get the payment table
     * @return the payment table
     */
    @Override
    public JsonTable<Payment> getJsonTable() {
        return paymentTable;
    }


    /**
     * accept payment
     * @param id the id of the payment
     * @return the payment
     */
    @PostMapping("/{id}/confirm")
    public boolean accept (@PathVariable int id) {
        Payment payment = Algorithm.<Payment>find(getJsonTable(),pred -> pred.id == id);

        if(payment.status ==  Invoice.PaymentStatus.WAITING){
            Room findroom = Algorithm.<Room>find(roomTable,pred -> pred.id == payment.getRoomId());
            Account account = Algorithm.<Account>find(accountTable, pred -> pred.id == payment.buyerId);
            payment.status =  Invoice.PaymentStatus.SUCCESS;
            account.balance -= findroom.price.price;
            Payment.makeBooking(payment.from, payment.to, findroom);
            return true;
        }
        return false;
    }


    /**
     * reject payment
     * @param id the id of the payment
     * @return the payment
     */
    @PostMapping("/{id}/cancel")
    public boolean cancel (@PathVariable int id) {
        Payment payment = Algorithm.<Payment>find(getJsonTable(),pred -> pred.id == id);
        if(payment.status ==  Invoice.PaymentStatus.WAITING){
            Account findAccount = Algorithm.<Account>find(accountTable, pred -> pred.id == payment.buyerId);
            Room findRoom = Algorithm.<Room>find(roomTable, pred -> pred.id == payment.getRoomId());
            payment.status =  Invoice.PaymentStatus.FAILED;
            findAccount.balance += findRoom.price.price;
            Payment.removeBooking(payment.from, payment.to, findRoom);
            paymentTable.remove(payment);
            return true;
        }
        return false;
    }


    /**
     * create payment
     * @param buyerId the id of the buyer
     * @param renterId the id of the renter
     * @param roomId the id of the room
     * @param from the start date
     * @param to the end date
     * @return the payment
     * @throws ParseException
     */
    @PostMapping("/create")
    public Payment create
    (
            @RequestParam int buyerId,
            @RequestParam int renterId,
            @RequestParam int roomId,
            @RequestParam String from,
            @RequestParam String to
    )
            throws ParseException
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fromDate = sdf.parse(from);
        Date toDate = sdf.parse(to);
        Account findAccount = Algorithm.<Account>find(accountTable, pred -> pred.id == buyerId);
        Room findRoom = Algorithm.<Room>find(roomTable, pred -> pred.id == roomId);
        if (findAccount != null && findRoom != null){
            double totalPrice = findRoom.price.price;
            if (findAccount.balance >= totalPrice && Payment.availability(fromDate, toDate, findRoom)){
                Payment currentPayment = new Payment(buyerId, renterId, roomId, fromDate, toDate);
                currentPayment.status = Invoice.PaymentStatus.WAITING;
                paymentTable.add(currentPayment);
                return currentPayment;
            } else {
                return null;
            }
        }
        return null;
    }

    /**
     * get the payment by id
     * @param buyerId the id of the buyer
     * @param renterId the id of the renter
     * @param roomId the id of the room
     * @return the payment
     */
    @GetMapping("/get")
    public Payment get(@RequestParam int buyerId,
                       @RequestParam int renterId,
                       @RequestParam int roomId) {
        int buyerId1 = Integer.parseInt(String.valueOf(buyerId));
        int renterId1 = Integer.parseInt(String.valueOf(renterId));
        int roomId1 = Integer.parseInt(String.valueOf(roomId));
        return Algorithm.<Payment>find(paymentTable, pred -> pred.buyerId == buyerId1 && pred.renterId == renterId1 && pred.getRoomId() == roomId1);
    }
}
