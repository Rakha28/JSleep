package RakhaArgyaZahranJSleepDN;
import java.util.Date;
import java.util.ArrayList;


public class Room extends Serializable implements FileParser
{
    public int size;
    public String name, address;
    public Facility facility;
    public Price price;
    public BedType bedType;
    public City city;
    public ArrayList<Date> booked;
    
   public Room(int id, String name, int size, Price price, Facility facility, City city, String address){
       super(id); 
       this.name = name;
       this.size = size;
       this.price = price;
       this.facility = facility;
       this.city = city;
       this.address = address;
       this.bedType = BedType.SINGLE;
       this.booked = new ArrayList<Date>();
    }
    
    public String toString(){
        return "\nName: " + this.name + "\nAddress: " + this.address + "\nSize: " + this.size + "\nFacility: " + this.facility + "\nBed Type: " + this.bedType + "\nCity: " + this.city + "\n" + this.price;    
    }
    
    public Object write(){
        return null;
    }
    public boolean read(String content){
        return false;
    }
   
}