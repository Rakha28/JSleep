package RakhaArgyaZahranJSleepDN;


/**
 * Write a description of class Rating here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Rating
{
    private long total, count;
    
    public Rating(){
        this.total = 0;
        this.count = 0;
    }
    
    public void insert(int rating){
        this.total += rating;
        this.count++;
    }
    
    public double getAvegare(){
        if(this.total == 0){
            return 0;
        }else{
            return this.total/this.count;
        }    
    }
    
    public long getCount(){
        return this.count;
    }
    
    public long getTotal(){
        return this.total;
    }
    
    public String toString(){
        return "Count: " + this.count + "   Total: " + this.total;
    }
}