package com.RakhaArgyaZahranJSleepDN;


import com.RakhaArgyaZahranJSleepDN.dbjson.Serializable;

/**
 * Complaint class for the database.
 * @author Rakha Argya Zahran
 * @version 0.1
 */
public class Complaint extends Serializable
{
   public String desc, date;

    /**
     * constructor for the class
     * @param date the date of the complaint
     * @param desc the description of the complaint
     */
   public Complaint(String date, String desc){
        super();
        this.desc = desc;
        this.date = date;
    }

    /**
     * change to string
     * @return the string
     */
    public String toString(){
        return "Desc: " + this.desc + "   Date: " + this.date;
    }
}