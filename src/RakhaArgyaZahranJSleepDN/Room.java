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
    
   public Room(String name, int size, Price price, Facility facility, City city, String address){
       super();
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
        return "\nName: " + name + "\nAddress: " + address + "\nSize: " + size + "\nFacility: " + facility + "\nBed " +
                "Type: " + bedType + "\nCity: " + city + "\n" + price + "\n" + "Id: " + id;
    }
    
    public Object write(){
        return null;
    }
    public boolean read(String content){
        return false;
    }
   
}