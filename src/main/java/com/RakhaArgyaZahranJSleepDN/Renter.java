package com.RakhaArgyaZahranJSleepDN;
import com.RakhaArgyaZahranJSleepDN.dbjson.Serializable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Renter class for the database.
 * @author Rakha Argya Zahran
 * @version 0.1
 */
public class Renter extends Serializable
{
    public String username;
    public String address;
    public String phoneNumber;

    public double balance;

    public static final String REGEX_PHONE = "[0-9]{9,12}";
    public static final String REGEX_NAME = "^[A-Z][a-z0-9_][^/s]{4,20}$";

    public Renter(String username, String address, String phoneNumber){
        this.username = username;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }

    public boolean validate(){
        Pattern patternPhone = Pattern.compile(REGEX_PHONE);
        Matcher matcherPhone = patternPhone.matcher(this.phoneNumber);
        boolean matchFoundPhone = matcherPhone.find();

        Pattern patternName = Pattern.compile(REGEX_NAME);
        Matcher matcherName = patternName.matcher(this.username);
        boolean matchFoundName = matcherName.find();

        return matchFoundPhone && matchFoundName;
    }

}
