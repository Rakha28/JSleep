package com.RakhaArgyaZahranJSleepDN;

import com.RakhaArgyaZahranJSleepDN.dbjson.Serializable;

/**
 * Voucher class for the database.
 * @author Rakha Argya Zahran
 * @version 0.1
 *
 */
public class Voucher extends Serializable
{
    public Type type;
    public double cut, minimum;
    public String name;
    public int code;
    private boolean used;

    /**
     * Constructor for objects of class Voucher
     * @param id the id of the voucher
     * @param name the name of the voucher
     * @param code the code of the voucher
     * @param type the type of the voucher
     * @param used the used of the voucher
     * @param minimum the minimum of the voucher
     * @param cut the cut of the voucher
     */
    public Voucher(int id, String name, int code, Type type,boolean used, double minimum, double cut){
        this.name = name;
        this.code = code;
        this.type = type;
        this.used = used;
        this.minimum = minimum;
        this.cut = cut;
    }

    /**
     * get the used of the voucher
     * @return the used of the voucher
     */
    public boolean isUsed(){
        return this.used;
    }

    /**
     *  set the used of the voucher
     * @param price the price of the voucher
     * @return the used of the voucher
     */
    public boolean canApply(double price){
        if(price > this.minimum && this.used == false){
            return true;
        }else{
            return false;
        }
    }

    /**
     * set the used of the voucher
     * @param price the price of the voucher
     * @return the used of the voucher
     */
    public double apply(Price price){
        used = true;
        if (this.type == Type.DISCOUNT){
            if (cut > 100){
                cut = 100;
            }
            return price.price * (100 - cut)/100;
        }else{
            if (cut > price.price){
                cut = price.price;
            }
            return price.price - cut;
        }
    }
}