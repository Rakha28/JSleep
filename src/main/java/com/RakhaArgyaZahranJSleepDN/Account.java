package com.RakhaArgyaZahranJSleepDN;

import com.RakhaArgyaZahranJSleepDN.dbjson.Serializable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Account extends Serializable
{
    
    public String name;
    public String email;
    public String password;

    public static final String REGEX_EMAIL = "^[A-Z0-9._%+-]@[A-Za-z.-]\\.[a-z]$";


    public static final String REGEX_PASSWORD = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])*[a-zA-Z\\d]{8,}$";
    public double balance;
    public Renter renter;


    public Account (String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
        this.renter = null;
    }
    public boolean validate(){
        Pattern patternEmail = Pattern.compile(this.REGEX_EMAIL);

        Matcher matcherEmail = patternEmail.matcher(this.email);


        boolean matchFoundEmail = matcherEmail.find();

        Pattern patternPassword = Pattern.compile(this.REGEX_PASSWORD);

        Matcher matcherPassword = patternPassword.matcher(this.name);


        boolean matchFoundPassword = matcherPassword.find();

        return matchFoundEmail && matchFoundPassword;






    }
    public String toString(){
        return "Account{name='"+name+"', email='"+email+"', password='"+password+"', id='"+id+"'}";




    }
}