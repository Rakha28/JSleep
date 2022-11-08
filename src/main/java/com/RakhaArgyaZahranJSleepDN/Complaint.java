package com.RakhaArgyaZahranJSleepDN;


import com.RakhaArgyaZahranJSleepDN.dbjson.Serializable;

/**
 * Write a description of class Complaint here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Complaint extends Serializable
{
   public String desc, date;
   
   public Complaint(String date, String desc){
        super();
        this.desc = desc;
        this.date = date;
    }
    
    public String toString(){
        return "Desc: " + this.desc + "   Date: " + this.date;
    }
}