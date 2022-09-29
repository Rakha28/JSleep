package RakhaArgyaZahranJSleepDN;


/**
 * Write a description of class Price here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Price
{
    public double price;
    //public double rebate;
    public double discount;
    
    public Price(double price){
        this.price = price;
        this.discount = 0;
        //this.rebate = 0;
    }
    
    public Price(double price, double discount){
        this.price = price;
        this.discount = discount;
        //this.rebate = 0;
    }
    
    public String toString(){
        return "Price: " + this.price + "Discount: " + this.discount;
    }

}