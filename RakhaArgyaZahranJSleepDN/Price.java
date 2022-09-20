package RakhaArgyaZahranJSleepDN;


/**
 * Write a description of class Price here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Price
{
    public double rebate;
    
    public double price;
    
    public int discount;
    
    public Price(double price)
    {
        this.price = price;
        this.discount = 0;
        this.rebate = 0.0d;
    }
    
    public Price(double price, int discount)
    {
        this.price = price;
        this.discount = discount;
        this.rebate = 0.0d;
    }
    
    public Price(double price, double rebate)
    {
        this.price = price;
        this.rebate = rebate;
        this.discount = 0;
    }
    private double getDiscountedPrice(){
        if (discount > 100){
            discount = 100;
        }
        if (discount == 100){
            return 0.0d;
        }else{
            return (price * (1 - discount/100.0));
        }
    }
    
    private double getRebatedPrice()
    {
       if (rebate > price){
           return price;
       } else {
           return getDiscountedPrice() * rebate;
       }
       
    }
}
