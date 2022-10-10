package RakhaArgyaZahranJSleepDN;

public class Account extends Serializable implements FileParser
{
    
    public String name;
    public String email;
    public String password;
    
    public Account (int id, String name, String email, String password){
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
    }
    
    public String toString(){
        return "Name: " + name +
                   "\nEmail: " + email +
                   "\nPassword: " + password;
    }
    
    public Object write(){
        return null;
    }
    public boolean read(String content){
        return false;
    }
}