package RakhaArgyaZahranJSleepDN;


/**
 * Write a description of class Rating here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Rating
{
    // instance variables - replace the example below with your own
    private long total;
    private long count;

    /**
     * Constructor for objects of class Rating
     */
    public Rating()
    {
        total = 0;
        count = 0;
    }
    
    public void insert(int rating)
    {
        total += rating;
        count++;
    }
    
    public double getAverage()
    {
        if (count == 0){
            return 0.0d;
        }
        return (double) total/count;
    }
    
    public long getCount()
    {
        return count;
    }
    
    public long getTotal()
    {
        return total;
    }

}
