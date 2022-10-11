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
    public Renter(String username)
    {
        super();
        this.username = username;
    }
    
    public Renter(String username, String address)
    {
        super();
        this.username = username;
        this.address = address;
    }
    public Renter(String username, int phoneNumber)
    {
        super();
        this.username = username;
        this.phoneNumber = phoneNumber;
    }
    public Renter(String username, int phoneNumber, String address)
    {
        super();
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}
