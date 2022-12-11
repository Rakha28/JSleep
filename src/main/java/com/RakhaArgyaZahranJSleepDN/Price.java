package com.RakhaArgyaZahranJSleepDN;


/**
 * Price class for the database.
 * @author Rakha Argya Zahran
 * @version 0.1
 *
 */
public class Price
{
    public double price;
    //public double rebate;
    public double discount;

    /**
     * Constructor for objects of class Price
     * @param price the price of the room
     */
    public Price(double price){
        this.price = price;
        this.discount = 0;
        //this.rebate = 0;
    }

    /**
     * Constructor for objects of class Price
     * @param price the price of the room
     * @param discount the discount of the room
     */
    public Price(double price, double discount){
        this.price = price;
        this.discount = discount;
        //this.rebate = 0;
    }

    /**
     * change to string
     * @return the string
     */
    public String toString(){
        return "Price: " + this.price + "Discount: " + this.discount;
    }

}