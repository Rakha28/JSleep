package RakhaArgyaZahranJSleepDN;


/**
 * Write a description of class Invoice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Invoice extends Serializable
{
    public enum RoomRating{
        NONE, BAD, NEUTRAL, GOOD
    };
    
    public enum PaymentStatus{ 
        FAILED, WAITING, SUCCESS
    };
    
    public PaymentStatus status;
    public RoomRating rating;
    public int buyerId, renterId;
    public String time;
    
    protected Invoice(int id, int buyerId, int renterId, String time){
        super(id);
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.time = time;
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }
    
    public Invoice(int id, Account buyer, Renter renter, String time){
        super(id);
        this.buyerId = buyer.id;
        this.renterId = renter.id;
        this.time = time;
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }
    
    public String print(){
        return "BuyerId = " + this.buyerId + "  RenterId = " + this.renterId + "   Time = " + this.time;
    }
}