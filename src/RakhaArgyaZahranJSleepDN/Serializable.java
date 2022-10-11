package RakhaArgyaZahranJSleepDN;
import java.util.HashMap;
import java.util.Map;

public class Serializable implements Comparable<Serializable>
{
    public final int id;
    private static Map<Class<?>,Integer> mapCounter = new HashMap();
    protected Serializable(){
        if (mapCounter.get(this.getClass()) == null){
            mapCounter.put(this.getClass(), 0);
            this.id = 0;
        }else{
            Integer counter = mapCounter.get(this.getClass());
            mapCounter.put(this.getClass(), ++counter);
            this.id = counter;
        }
    }

    public int compareTo(Serializable other){
        return Integer.compare(this.id, other.id);
    }

    public boolean equals(Object other) {
        if (other instanceof Serializable) {
            Serializable serializable = (Serializable) other;
            return (serializable.id == this.id);
        } else {
            return false;
        }
    }

    public boolean equals (Serializable other){
        return (this.id == other.id);
    }

    public static <T> int getClosingId(Class<T> cls){
        return mapCounter.get(cls);
    }

    public static <T> int setClosingId(Class<T> cls, int id){
        mapCounter.replace(cls,id);
        return mapCounter.get(cls);
    }

}

