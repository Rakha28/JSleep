package com.RakhaArgyaZahranJSleepDN;

/**
 * Thread class for the database.
 * @author Rakha Argya Zahran
 * @version 0.1
 */
public class ThreadingObject extends Thread{

    /**
     * Constructor for objects of class ThreadingObject
     */

    public ThreadingObject(String name){


        super(name);


    }

    /**
     * run the thread
     */
    public void run(){

        System.out.println(Thread.currentThread().getName() + " is running");


        System.out.println("Id Thread " + Thread.currentThread().getId());



    }
}
