package com.RakhaArgyaZahranJSleepDN;

import com.RakhaArgyaZahranJSleepDN.dbjson.Serializable;

import java.util.regex.*;

/**
 * The Account for the database.
 * @author Rakha Argya Zahran
 * @version 0.1
 */
public class Account extends Serializable
{
    public String name;
    public double balance;
    public Renter renter;
    public String password;
    public String email;
    final public static String REGEX_EMAIL = "^[A-Za-z0-9.%+-]@[A-Za-z.-]\\.[A-Za-z]$";
    final public static String REGEX_PASSWORD = "^[A-Z][A-Za-z0-9_-]{8,}$";

    /**
     * Constructor for Account.
     * @param name the name of the account.
     * @param email the email of the account.
     * @param password the password of the account.
     */
    public Account(String name, String email, String password){
        super();
        this.balance = 0;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    /**
     * change to string
     * @return string
     */
    public String toString(){
        return "===ACCOUNT===\n" + "Name\t\t: " + name + "\nE-mail\t\t: " + email +
                "\nPassword\t: " + password + "\nId\t\t\t: " + id;
    }

    /**
     * validate account
     * @return true if valid
     */
    public boolean validate(){
        Pattern email = Pattern.compile(REGEX_EMAIL);
        Pattern password = Pattern.compile(REGEX_PASSWORD);

        Matcher matchEmail = email.matcher(this.email);
        Matcher matchPassword = password.matcher(this.password);

        if (this.email == null || this.password == null){
            return false;
        }
        return matchEmail.find() && matchPassword.find();
    }

}