package RakhaArgyaZahranJSleepDN;
import java.util.Date;

public class Invoice extends Serializable
{
    public enum RoomRating { NONE, BAD, NEUTRAL, GOOD};
    public enum PaymentStatus { FAILED, WAITING, SUCCESS};
    public int buyerId;
    public int renterId;
    public PaymentStatus status;
    public RoomRating rating;
    Date time;
    
    protected Invoice(int id, int buyerId, int renterId)
    {
        super();
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.time = new Date();
        this.status = PaymentStatus.WAITING;
        this.rating = RoomRating.NONE;
        
    }

    public Invoice(Account buyer, Renter renter){
        super();
        this.buyerId = buyer.id;
        this.renterId = renter.id;
        this.time = new Date();
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }
    
    public String print(){
        return "Id : " + super.id +
                       "\nBuyer Id : " + buyerId +
                       "\nRenter Id : " + renterId +
                       "\ntime : " + time;
    }
    
    
}