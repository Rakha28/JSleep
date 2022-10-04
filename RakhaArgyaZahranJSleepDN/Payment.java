package RakhaArgyaZahranJSleepDN;


import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Payment extends Invoice
{
   private int roomId;
   Calendar to, from;
   public Payment(int id, int buyerId, int renterId, int roomId){
        super(id, buyerId, renterId);
        this.from = Calendar.getInstance();
        this.to = Calendar.getInstance();
        to.add(Calendar.DATE,2);
    }
    
    public Payment(int id, Account buyer, Renter renter, int roomId){
        super(id, buyer, renter);
        this.from = Calendar.getInstance();
        this.to = Calendar.getInstance();
        to.add(Calendar.DATE,2);
        this.roomId = roomId;
    }
    public String getTime(){
        SimpleDateFormat SDFormat = new SimpleDateFormat("dd MMMM yyyy");
        return "Formatted Date: " + SDFormat.format(time.getTime());
    }
    
    public String getDuration(){
        SimpleDateFormat SDFormat = new SimpleDateFormat("dd MMMM yyyy");
        this.from = Calendar.getInstance();
        this.to = Calendar.getInstance();
        to.add(Calendar.DATE,2);
        return SDFormat.format(from.getTime()) +" - "+ SDFormat.format(to.getTime());
    }
    
    public String print(){
        return "From = " + this.from + "   To = " + this.to + "  RoomId = " + this.roomId;
    }
    
    public int getRoomId(){
        return this.roomId;
    }
}
 