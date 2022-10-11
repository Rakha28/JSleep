package RakhaArgyaZahranJSleepDN;
import java.util.*;
import java.util.function.Predicate;

public class Algorithm {
    private Algorithm(){
    }

    public static <T> int count(Iterator<T> iterator, T value){
        int count = 0;
        while(iterator.hasNext()){
            if(iterator.next().equals(value)){
                count++;
            }
        }
        return count;
    }
    public static <T> int count(T[] array, T value){
        int count = 0;
        for(T t : array){
            if(t.equals(value)){
                count++;
            }
        }
        return count;
    }
    public static <T> int count(Iterable<T> iterable, Predicate<T> predicate){
        int count = 0;
        for(T t : iterable){
            if(predicate.test(t)){
                count++;
            }
        }
        return count;
    }

    public static <T> int count(T[] array, Predicate<T> predicate){
        int count = 0;
        for(T t : array){
            if(predicate.test(t)){
                count++;
            }
        }
        return count;
    }

    public static <T> int count(Iterator<T> iterator, Predicate<T> predicate){
        int count = 0;
        while(iterator.hasNext()){
            if(predicate.test(iterator.next())){
                count++;
            }
        }
        return count;
    }

    public static <T> int count(Iterable<T> iterable, T value){
        int count = 0;
        for(T t : iterable){
            if(t.equals(value)){
                count++;
            }
        }
        return count;
    }

    public static <T> boolean exists(T[] array, T value){
        final Iterator<T> it = Arrays.stream(array).iterator();
        return exists(it, value);
    }
    public static <T> boolean exists(Iterable<T> iterable, T value){
        final Iterator<T> it = iterable.iterator();
        return exists(it, value);
    }
    public static <T> boolean exists(Iterator<T> iterator, T value){
        final Predicate<T> pred = value::equals;
        return exists(iterator, pred);
    }
    public static <T> boolean exists(T [] array, Predicate<T> pred){
        final Iterator<T> it = Arrays.stream(array).iterator();
        return exists(it, pred);
    }
    public static <T> boolean exists(Iterable<T> iterable, Predicate<T> pred){
        final Iterator<T> it = iterable.iterator();
        return exists(it, pred);
    }
    public static <T> boolean exists(Iterator<T> iterator, Predicate<T> pred){
        while (iterator.hasNext()){
            if (pred.test(iterator.next())){
                return true;
            }
        }
        return false;
    }

    public static <T> T find(T[] array, Predicate<T> pred){
        final Iterator<T> it = Arrays.stream(array).iterator();
            return find(it, pred);
    }

    public static <T> T find(Iterable<T> iterable, Predicate<T> pred){
        final Iterator<T> it = iterable.iterator();
        return find(it, pred);
    }

    public static <T> T find(T[] array, T value){
        final Iterator<T> it = Arrays.stream(array).iterator();
        return find(it, value);
    }

    public static <T> T find(Iterable<T> iterable, T value){
        final Iterator<T> it = iterable.iterator();
        return find(it, value);
    }

    public static <T> T find(Iterator<T> iterator, T value){
        final Predicate<T> pred = value::equals;
        return find(iterator, pred);
    }

    public static <T> T find(Iterator<T> iterator, Predicate<T> pred){
        while (iterator.hasNext()){
            T t = iterator.next();
            if (pred.test(t)){
                return t;
            }
        }
        return null;
    }
}