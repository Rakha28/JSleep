package RakhaArgyaZahranJSleepDN;


public class Voucher extends Serializable implements FileParser
{
    public Type type;
    public double cut;
    public String name;
    public int code;
    public double minimum;
    private boolean used;
    
    
    
    public Voucher(int id,String name,int code,Type type , boolean used, double minimum ,double cut){
        super(id);
        this.name = name;
        this.code = code;   
        this.type = type;
        this.used = used;
        this.minimum = minimum;
        this.cut = cut;
    }
    
    public boolean canApply(Price price ){
        return price.price > this.minimum && !this.used;
    }
    
    public boolean isUsed(){
        return this.used;
    }
    
    public double apply(Price price){
        if(this.type == Type.DISCOUNT){
               if(cut > 100){
                   cut = 100;
               }
               return price.price * (100-cut)/100;
        }
        
        else {
            if(cut > price.price){
                cut = price.price;
            }
            return price.price - cut;
        }
    }
    public Object write(){
        return null;
    }
    public boolean read(String content){
        return false;
    }
    
}
