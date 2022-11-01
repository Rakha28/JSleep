package RakhaArgyaZahranJSleepDN;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Write a description of class Renter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Renter extends Serializable
{
    public String username;
    public String address;
    public String phoneNumber;
    public static final String REGEX_PHONE = "[0-9]{9,12}";
    public static final String REGEX_NAME = "^[A-Z][a-z0-9_][^/s]{4,20}$";

    public Renter(String username, String phoneNumber, String address){
        super();
        this.username = username;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public boolean validate(){
        Pattern patternPhone = Pattern.compile(REGEX_PHONE);
        Matcher matcherPhone = patternPhone.matcher(this.phoneNumber);
        boolean matchFoundPhone = matcherPhone.find();

        Pattern patternName = Pattern.compile(REGEX_NAME);
        Matcher matcherName = patternName.matcher(this.username);
        boolean matchFoundName = matcherName.find();

        return matchFoundPhone && matchFoundName;
    }

}
