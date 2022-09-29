package RakhaArgyaZahranJSleepDN;


/**
 * Write a description of class Complaint here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Complaint extends Serializable
{
   public String desc, date;
   
   public Complaint(int id, String date, String desc){
        super(id);
        this.desc = desc;
        this.date = date;
    }
    
    public String toString(){
        return "Desc: " + this.desc + "   Date: " + this.date;
    }
}