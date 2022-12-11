package com.RakhaArgyaZahranJSleepDN.dbjson;

import java.util.HashMap;

/**
 * The class for the database engine.
 * @author Rakha Argya Zahran
 * @version 0.1
 */
public class Serializable implements Comparable<Serializable>{
    public final int id;
    private static HashMap<Class<?>, Integer> mapCounter = new HashMap<Class<?>, Integer>();

    /**
     * constructor for the class
     */
    protected Serializable() {
        Integer counter = mapCounter.get(getClass());
        if (counter == null){
            counter =  0;
        }
        else{
            counter +=1;
        }
        mapCounter.put(getClass(), counter);
        this.id = counter;
    }

    /**
     * closing the database
     * @param clazz the class of the object
     * @param id the id of the object
     * @return the object with the id
     * @param <T> the type of the object
     */
    public static <T extends Serializable> Integer setClosingId(Class<T> clazz, int id) { return mapCounter.put(clazz, id); }

    /**
     * closing the database
     * @param clazz the class of the object
     * @return the object with the id
     * @param <T> the type of the object
     */
    public static <T extends Serializable> Integer getClosingId(Class<T> clazz) { return mapCounter.get(clazz); }

    /**
     * equals method
     * @param other the other object
     * @return true if the object is equal
     */
    public boolean equals(Object other)
    {
        return other instanceof Serializable && ((Serializable) other).id == id;
    }

    /**
     * equals method
     * @param other the other object
     * @return true if the object is equal
     */
    public boolean equals(Serializable other)
    {
        return other.id == id;
    }

    /**
     * compare method
     * @param other the other object
     * @return the result of the comparison
     */
    public int compareTo(Serializable other)
    {
        return Integer.compare(this.id, other.id);
    }
}