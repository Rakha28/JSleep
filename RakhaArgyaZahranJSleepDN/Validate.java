package RakhaArgyaZahranJSleepDN;

import java.util.ArrayList;



public class Validate
{
    public static ArrayList filter(Price[] list, int value, boolean less){
        ArrayList arrList = new ArrayList<>();
        
        for(Price LP : list){
            if((less == true && LP.price <= value)){
                arrList.add(LP.price);
            }else if(less == false && LP.price > value){
                arrList.add(LP.price);
            }
        }
        return arrList;
    }
}