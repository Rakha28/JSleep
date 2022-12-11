package com.RakhaArgyaZahranJSleepDN;
import com.RakhaArgyaZahranJSleepDN.dbjson.Serializable;

/**
 * Invoice class for the database.
 * @author Rakha Argya Zahran
 * @version 0.1
 */
public class Invoice extends Serializable
{
    public enum RoomRating { NONE, BAD, NEUTRAL, GOOD};
    public enum PaymentStatus { FAILED, WAITING, SUCCESS};
    public int buyerId;
    public int renterId;
    public PaymentStatus status;
    public RoomRating rating;

    /**
     * constructor for the class
     * @param buyerId the id of the buyer
     * @param renterId the id of the renter
     */
    protected Invoice(int buyerId, int renterId)
    {
        super();
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.status = PaymentStatus.WAITING;
        this.rating = RoomRating.NONE;
        
    }

    /**
     * Contructor for the class
     * @param buyer the buyer
     * @param renter the renter
     */
    public Invoice(Account buyer, Renter renter){
        super();
        this.buyerId = buyer.id;
        this.renterId = renter.id;
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }

    /**
     * change to string
     * @return the string
     */
    public String print(){
        return "Id : " + super.id +
                       "\nBuyer Id : " + buyerId +
                       "\nRenter Id : " + renterId;
    }
    
    
}