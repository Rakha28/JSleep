package com.RakhaArgyaZahranJSleepDN;


/**
 * Rating class for the database.
 * @author Rakha Argya Zahran
 * @version 0.1
 */
public class Rating
{
    private long total, count;

    /**
     * Constructor for objects of class Rating
     */
    public Rating(){
        this.total = 0;
        this.count = 0;
    }

    /**
     * Constructor for objects of class Rating
     * @param rating the rating of the room
     */
    public void insert(int rating){
        this.total += rating;
        this.count++;
    }

    /**
     * get the rating average
     * @return the rating average
     */
    public double getAvegare(){
        if(this.total == 0){
            return 0;
        }else{
            return this.total/this.count;
        }    
    }

    /**
     * count the rating
     * @return the rating count
     */
    public long getCount(){
        return this.count;
    }

    /**
     * total the rating
     * @return the rating total
     */
    public long getTotal(){
        return this.total;
    }

    /**
     * change to string
     * @return the string
     */
    public String toString(){
        return "Count: " + this.count + "   Total: " + this.total;
    }
}