package com.RakhaArgyaZahranJSleepDN;

import java.util.ArrayList;

/**
 * Validate class for the database.
 * @author Rakha Argya Zahran
 * @version 0.1
 */
public class Validate {
    public static ArrayList filter (Price[] list, int value, boolean less){
        ArrayList filteredPrice = new ArrayList();
        if(less == true) {
            for (Price iterator : list) {
                if(iterator.price <= value){
                    filteredPrice.add(iterator.price);
                }
            }
        }
        else{
            for (Price iterator : list) {
                if(iterator.price > value){
                    filteredPrice.add(iterator.price);
                }
            }
        }
        return filteredPrice;
    }
}