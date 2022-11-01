package RakhaArgyaZahranJSleepDN;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;

public class JSleep {
    public static void main(String[] args) {
        try{
            String filepath = "src\\json\\randomRoomList.json";

            JsonTable<Room> tableRoom = new JsonTable<>(Room.class, filepath);
            List<Room> filterTableRoom = filterByAccountId(tableRoom, 11, 0, 5);
            filterTableRoom.forEach(room -> System.out.println(room.toString()));
        }

        catch(IOException t) {
            t.printStackTrace();
        }
    }

    public static List<Room> filterByAccountId(List<Room> list, int accountId, int page, int pageSize){

        return Algorithm.<Room>paginate(list,page,pageSize,room -> room.accountId == accountId);
    }

    public static List<Room> filterByPrice(List<Room> list, double min, double max){
        return Algorithm.<Room>collect(list,room -> room.price.price >= min && room.price.price <= max);
    }

    public static List<Room> filterByCity(List<Room> list, String search, int page, int pageSize){
        return Algorithm.<Room>paginate(list,page,pageSize,room -> room.name.toLowerCase().contains(search.toLowerCase()));
    }


}