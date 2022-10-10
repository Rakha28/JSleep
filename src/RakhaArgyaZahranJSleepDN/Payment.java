package RakhaArgyaZahranJSleepDN;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar; 

public class Payment extends Invoice
{
    public Date to;
    public Date from;
    private int roomId;
    
    public Payment(int id, Account buyer, Renter renter, int roomId, Date from, Date to)
    {
        super(id, buyer, renter);
        this.from = from;
        this.to = to;
        this.roomId = roomId;
    }

    public Payment(int id, int buyerId, int renterId, int roomId, Date from, Date to)
    {
        super(id, buyerId, renterId);
        this.from = from;
        this.to = to;
        this.roomId = roomId;
    }
    
    public String getTime()
    {
        SimpleDateFormat SDFormat = new SimpleDateFormat("'Formatted Date = 'dd MMMM yyyy");
        return SDFormat.format(from.getTime());
    }
    
    public String print()
    {
        return ("Room ID: " + this.roomId + "\n"+ "Payment from: " + this.from + "\n" + "Payment to: " + this.to + "\n");
    }
    
    public int getRoomId()
    {
        return roomId;
    }
    
    public static boolean availability(Date from, Date to, Room room)
    {
        if(room.booked.isEmpty()){
            return true;
        }
        if(to.before(from))
            return false;
        for(Date i : room.booked){
            if(i.after(from) && i.before(to) || i.equals(from)){
                return false;
            }
        }
        return true;
    }
    
    public static boolean makeBooking(Date from, Date to, Room room)
    {
        SimpleDateFormat SDFormat = new SimpleDateFormat("dd MMMM yyyy");
        String formattedFrom = SDFormat.format(from.getTime());
        String formattedTo = SDFormat.format(to.getTime());
        Calendar c = Calendar.getInstance();
        
        if(availability(from, to, room)){
            while(from.before(to)){
                room.booked.add(from);
                c.setTime(from);
                c.add(Calendar.DATE, 1);
                from = c.getTime();
            }
            return true;
        }else{
            return false;
        }
    }

}