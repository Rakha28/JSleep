package com.RakhaArgyaZahranJSleepDN.controller;

import com.RakhaArgyaZahranJSleepDN.*;
import com.RakhaArgyaZahranJSleepDN.dbjson.JsonAutowired;
import com.RakhaArgyaZahranJSleepDN.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Rakha Argya Zahran
 * class for handling room
 */
@RestController
@RequestMapping("/room")
public class RoomController implements BasicGetController{
    @JsonAutowired(value = Room.class, filepath = "C:\\Users\\RakhaArgya\\OneDrive\\Dokumen\\Argy\\PRAKTIKUM OOP\\JSleep\\lib\\Room.json")
    public static JsonTable<Room> roomTable;

    /**
     * get the room table
     * @return the room table
     */
    @Override
    public JsonTable getJsonTable() {
        return roomTable;
    }



    /**
     * get the room by id renter
     * @param id the id of the renter
     * @return the room
     */
    @GetMapping("/{id}/renter")
    List<Room> getRoomByRenter(@PathVariable int id, @RequestParam int page, @RequestParam int pageSize) {
        return Algorithm.<Room>paginate(getJsonTable(), page, pageSize, pred-> pred.id == id);
    }

    /**
     * get all room
     * @param page the page
     * @param pageSize the page size
     * @return
     */
    @GetMapping("/getAllRoom")
    List<Room> getAllRoom(@RequestParam int page, @RequestParam int pageSize) {
        return Algorithm.<Room>paginate(getJsonTable(), page, pageSize, pred-> true);
    }

    /**
     * create room
     * @param accountId the id of the account
     * @param name the name of the room
     * @param size the size of the room
     * @param price the price of the room
     * @param facility the facility of the room
     * @param City the city of the room
     * @param address the address of the room
     * @param bedType  the bed type of the room
     * @return the room
     */
    @PostMapping("/create")
    Room create (@RequestParam int accountId,
                    @RequestParam String name,
                    @RequestParam int size,
                    @RequestParam double price,
                    @RequestParam Facility[] facility,
                    @RequestParam City City,
                    @RequestParam String address,
                    @RequestParam BedType bedType
                 )
    {
        Price price1 = new Price(price);
        Room room = new Room(accountId, name, size, price1, facility, City, address, bedType);
        roomTable.add(room);
        return room;
    }
}
