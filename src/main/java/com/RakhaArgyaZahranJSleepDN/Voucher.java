package com.RakhaArgyaZahranJSleepDN;

import com.RakhaArgyaZahranJSleepDN.dbjson.Serializable;
/**
 * Write a description of class Voucher here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Voucher extends Serializable
{
    public Type type;
    public double cut, minimum;
    public String name;
    public int code;
    private boolean used;

    public Voucher(int id, String name, int code, Type type,boolean used, double minimum, double cut){
        this.name = name;
        this.code = code;
        this.type = type;
        this.used = used;
        this.minimum = minimum;
        this.cut = cut;
    }

    public boolean isUsed(){
        return this.used;
    }

    public boolean canApply(double price){
        if(price > this.minimum && this.used == false){
            return true;
        }else{
            return false;
        }
    }

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

    public Object write(){
        return null;
    }

    public boolean read(String FP){
        return false;
    }
}