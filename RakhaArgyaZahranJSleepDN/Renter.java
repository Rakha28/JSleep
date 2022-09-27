package RakhaArgyaZahranJSleepDN;


/**
 * Write a description of class Renter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Renter extends Serializable
{
    String address, username;
    int phoneNumber = 0;
    public Renter(int id, String username)
    {
        super(id);
        this.username = username;
    }
    
    public Renter(int id, String username, String address)
    {
        super(id);
        this.username = username;
        this.address = address;
    }
    public Renter(int id, String username, int phoneNumber)
    {
        super(id);
        this.username = username;
        this.phoneNumber = phoneNumber;
    }
    public Renter(int id, String username, int phoneNumber, String address)
    {
        super(id);
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}
