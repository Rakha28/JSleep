package com.RakhaArgyaZahranJSleepDN.controller;

import com.RakhaArgyaZahranJSleepDN.Algorithm;
import com.RakhaArgyaZahranJSleepDN.City;
import com.RakhaArgyaZahranJSleepDN.Facility;
import com.RakhaArgyaZahranJSleepDN.Room;
import com.RakhaArgyaZahranJSleepDN.dbjson.JsonAutowired;
import com.RakhaArgyaZahranJSleepDN.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController implements BasicGetController{
    @JsonAutowired(value = Room.class, filepath = "C:\\Users\\RakhaArgya\\OneDrive\\Dokumen\\Argy\\PRAKTIKUM OOP\\JSleep\\lib\\Room.json")
    public static JsonTable<Room> roomTable;

    @Override
    public JsonTable getJsonTable() {
        return roomTable;
    }

    @GetMapping("/{id}/renter")
    List<Room> getRoomByRenter(@PathVariable int id, @RequestParam int page, @RequestParam int pageSize) {
        return Algorithm.<Room>paginate(getJsonTable(), page, pageSize, pred-> pred.id == id);
    }

    @PostMapping("/create")
    Room create (@RequestParam int accountId,
                    @RequestParam String name,
                    @RequestParam int size,
                    @RequestParam int price,
                    @RequestParam Facility facility,
                    @RequestParam City City,
                    @RequestParam String address
                 ){
        return new Room(accountId, name, size, price, facility, City, address);




    }
}
