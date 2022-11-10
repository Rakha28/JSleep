package com.RakhaArgyaZahranJSleepDN;
import com.RakhaArgyaZahranJSleepDN.dbjson.Serializable;

public class Invoice extends Serializable
{
    public enum RoomRating { NONE, BAD, NEUTRAL, GOOD};
    public enum PaymentStatus { FAILED, WAITING, SUCCESS};
    public int buyerId;
    public int renterId;
    public PaymentStatus status;
    public RoomRating rating;

    protected Invoice(int buyerId, int renterId)
    {
        super();
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.status = PaymentStatus.WAITING;
        this.rating = RoomRating.NONE;
        
    }

    public Invoice(Account buyer, Renter renter){
        super();
        this.buyerId = buyer.id;
        this.renterId = renter.id;
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }
    
    public String print(){
        return "Id : " + super.id +
                       "\nBuyer Id : " + buyerId +
                       "\nRenter Id : " + renterId;
    }
    
    
}