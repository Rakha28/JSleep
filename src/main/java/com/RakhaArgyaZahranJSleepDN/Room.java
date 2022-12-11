package com.RakhaArgyaZahranJSleepDN;
import com.RakhaArgyaZahranJSleepDN.dbjson.Serializable;

import java.util.Date;
import java.util.ArrayList;

/**
 * Room class for the database.
 * @author Rakha Argya Zahran
 * @version 0.1
 */
public class Room extends Serializable
{

    public String address;
    public City city;
    public ArrayList<Date> booked = new ArrayList<Date>();
    public int size;
    public Price price;
    public BedType bedType;
    public Facility[] facility;
    public String name;
    public int accountId;


    /**
     * constructor for room
     * @param accountId the id of the account
     * @param name the name of the room
     * @param size the size of the room
     * @param price the price of the room
     * @param facility the facility of the room
     * @param city the city of the room
     * @param address the address of the room
     * @param bedType the bed type of the room
     */
    public Room(int accountId, String name, int size, Price price, Facility[] facility, City city, String address, BedType bedType)
    {
        this.name = name;
        this.size = size;
        this.price = price;
        this.facility = new Facility[facility.length];
        for(int i = 0; i < facility.length; i++){
            this.facility[i] = facility[i];
        }
        this.city = city;
        this.address = address;
        this.bedType = bedType;
        this.accountId = accountId;
    }
    /*
    public String toString(){
        return "Room ID: " + super.id + "\nName: " + this.name + "\nSize: " + this.size +"\nPrice: " + this.price.price + "\nDiscount: " + this.price.discount +"\nFacility: " + this.facility + "\nCity: " + this.city + "\nAddress: " + this.address;
    }

    public Object write(){
        return null;
    }
    public boolean read(String content){
        return false;
    }
    */
}