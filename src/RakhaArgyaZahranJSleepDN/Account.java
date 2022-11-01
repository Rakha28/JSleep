package RakhaArgyaZahranJSleepDN;

public class Account extends Serializable
{
    
    public String name;
    public String email;
    public String password;
    
    public Account (String name, String email, String password){
        super();
        this.name = name;
        this.email = email;
        this.password = password;
    }
    
    public String toString(){
        return "Name: " + name +
                   "\nEmail: " + email +
                   "\nPassword: " + password;
    }
}