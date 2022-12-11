package com.RakhaArgyaZahranJSleepDN;
import java.util.Calendar;
import java.util.Date;

/**
 * Payment class for the database.
 * @author Rakha Argya Zahran
 * @version 0.1
 */
public class Payment extends Invoice
{
    public Date to;
    public Date from;
    private int roomId;

    /**
     * constructor for the class
     * @param from the date of the check in
     * @param to the date of the check out
     * @param roomId the id of the room
     */
    public Payment(int buyerId, int renterId, int roomId, Date from, Date to)
    {
        super(buyerId, renterId);
        this.to = to;
        this.from = from;
        this.roomId = roomId;
    }

    /**
     * constructor for the class
     * @param buyer the buyer
     * @param renter the renter
     * @param roomId the id of the room
     * @param from the date of the check in
     * @param to the date of the check out
     */
    public Payment(Account buyer, Renter renter, int roomId, Date from, Date to)
    {
        super(buyer, renter);
        this.to = to;
        this.from = from;
        this.roomId = roomId;
    }


    /**
     * check availability
     * @param from the date of the check in
     * @param to the date of the check out
     * @param room the room
     * @return true if available
     */
    public static boolean availability(Date from, Date to, Room room){
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

    /**
     * get room
     * @return the room
     */
    public int getRoomId(){
        return this.roomId;
    }


    /**
     * make booking
     * @param from the date of the check in
     * @param to the date of the check out
     * @param room the room
     * @return true if success
     */
    public static boolean makeBooking(Date from,Date to,Room room){
        if (availability(from, to, room)){
            Calendar start = Calendar.getInstance();
            start.setTime(from);
            Calendar end = Calendar.getInstance();
            end.setTime(to);
            for (Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
                room.booked.add(date);
            }
            return true;
        }
        return false;
    }

    public static boolean removeBooking(Date from,Date to,Room room){
        if (availability(from, to, room)){
            Calendar start = Calendar.getInstance();
            start.setTime(from);
            Calendar end = Calendar.getInstance();
            end.setTime(to);
            for (Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
                room.booked.remove(date);
            }
            return true;
        }
        return false;
    }


    /**
     * change to string
     * @return the string
     */
    public String toString(){
        return "Room ID: " + this.roomId + "\n"+ "Payment from: " + this.from + "\n" + "Payment to: " + this.to + "\n";
    }
}