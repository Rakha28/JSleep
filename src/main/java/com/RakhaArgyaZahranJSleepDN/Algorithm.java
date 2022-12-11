package com.RakhaArgyaZahranJSleepDN;
import java.util.*;

/**
 * A class for the algorithm
 * @author Rakha Argya Zahran
 * @version 0.1
 */
public class Algorithm {
    /**
     * Main method
     */
    private Algorithm() {
    }

    /**
     * Collect the object in the table
     * @param iterable the iterable object
     * @param value the value of the object
     * @return the list of object
     * @param <T> the type of the object
     */
    public static <T> List<T> collect(Iterable<T> iterable, T value) {
        final Iterator<T> it = iterable.iterator();
        return collect(it, value);
    }

    /**
     * collect the object in the table
     * @param iterable the iterable object
     * @param pred the predicate
     * @return the list of object
     * @param <T> the type of the object
     */
    public static <T> List<T> collect(Iterable<T> iterable, Predicate<T> pred) {
        final Iterator<T> it = iterable.iterator();
        return collect(it, pred);
    }

    /**
     * Collect the object in the table
     * @param array the array of the object
     * @param value the value of the object
     * @return the list of object
     * @param <T> the type of the object
     */
    public static <T> List<T> collect(T[] array, T value) {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return collect(it, value);
    }

    /**
     * Collect the object in the table
     * @param iterator the iterator of the object
     * @param value the value of the object
     * @return the list of object
     * @param <T> the type of the object
     */
    public static <T> List<T> collect(Iterator<T> iterator, T value) {
        final Predicate<T> pred = value::equals;
        return collect(iterator, pred);
    }


    /**
     * Collect the object in the table
     * @param array the array of the object
     * @param pred the predicate
     * @return the list of object
     * @param <T> the type of the object
     */
    public static <T> List<T> collect(T[] array, Predicate<T> pred) {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return collect(it, pred);
    }

    /**
     * Collect the object in the table
     * @param iterator  the iterator of the object
     * @param pred the predicate
     * @return the list of object
     * @param <T> the type of the object
     */
    public static <T> List<T> collect(Iterator<T> iterator, Predicate<T> pred) {
        List<T> list = new ArrayList<>();
        while (iterator.hasNext()) {
            T current = iterator.next();
            if (pred.predicate(current))
                list.add(current);
        }
        return list;
    }

    /**
     * count the object in the table
     * @param array the array of the object
     * @param value the value of the object
     * @return the number of object
     * @param <T> the type of the object
     */
    public static <T> int count(T[] array, T value) {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return count(it, value);
    }

    /**
     * count the object in the table
     * @param iterable the iterable object
     * @param value the value of the object
     * @return the number of object
     * @param <T> the type of the object
     */
    public static <T> int count(Iterable<T> iterable, T value) {
        final Iterator<T> it = iterable.iterator();
        return count(it, value);
    }

    /**
     * count the object in the table
     * @param iterator the iterator of the object
     * @param value the value of the object
     * @return  the number of object
     * @param <T> the type of the object
     */
    public static <T> int count(Iterator<T> iterator, T value) {
        final Predicate<T> pred = value::equals;
        return count(iterator, pred);
    }

    /**
     * Count the object in the table
     * @param array the array of the object
     * @param pred the predicate
     * @return the number of object
     * @param <T> the type of the object
     */
    public static <T> int count(T[] array, Predicate<T> pred) {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return count(it, pred);
    }

    /**
     * Count the object in the table
     * @param iterable the iterable object
     * @param pred the predicate
     * @return the number of object
     * @param <T> the type of the object
     */
    public static <T> int count(Iterable<T> iterable, Predicate<T> pred) {
        final Iterator<T> it = iterable.iterator();
        return count(it, pred);
    }

    /**
     * Count the object in the table
     * @param iterator the iterator of the object
     * @param pred the predicate
     * @return the number of object
     * @param <T> the type of the object
     */
    public static <T> int count(Iterator<T> iterator, Predicate<T> pred) {
        int count = 0;
        while (iterator.hasNext()) {
            T current = iterator.next();
            if (pred.predicate(current)) count += 1;
        }
        return count;
    }

    /**
     * exist the object in the table
     * @param array the array of the object
     * @param value the value of the object
     * @return true if the object exist
     * @param <T> the type of the object
     */
    public static <T> boolean exists(T[] array, T value) {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return exists(it, value);
    }

    /**
     * exist the object in the table
     * @param iterable the iterable object
     * @param value the value of the object
     * @return true if the object exist
     * @param <T> the type of the object
     */
    public static <T> boolean exists(Iterable<T> iterable, T value) {
        final Iterator<T> it = iterable.iterator();
        return exists(it, value);
    }

    /**
     * exist the object in the table
     * @param iterator the iterator of the object
     * @param value the value of the object
     * @return true if the object exist
     * @param <T> the type of the object
     */

    public static <T> boolean exists(Iterator<T> iterator, T value) {
        final Predicate<T> pred = value::equals;
        return exists(iterator, pred);
    }

    /**
     * exist the object in the table
     * @param array the array of the object
     * @param pred the predicate
     * @return true if the object exist
     * @param <T> the type of the object
     */
    public static <T> boolean exists(T[] array, Predicate<T> pred) {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return exists(it, pred);
    }

    /**
     * check if the object exist in the table
     * @param iterable the iterable object
     * @param pred the predicate
     * @return true if the object exist
     * @param <T> the type of the object
     */
    public static <T> boolean exists(Iterable<T> iterable, Predicate<T> pred) {
        final Iterator<T> it = iterable.iterator();
        return exists(it, pred);
    }

    /**
     * check if the object exist in the table
     * @param iterator  the iterator of the object
     * @param pred the predicate
     * @return true if the object exist
     * @param <T> the type of the object
     */
    public static <T> boolean exists(Iterator<T> iterator, Predicate<T> pred) {
        while (iterator.hasNext()) {
            T current = iterator.next();
            if (pred.predicate(current))
                return true;
        }
        return false;
    }

    /**
     * find the object in the table
     * @param iterable the iterable object
     * @param value the value of the object
     * @return the object
     * @param <T> the type of the object
     */
    public static <T> T find(Iterable<T> iterable, T value) {
        final Iterator<T> counter = iterable.iterator();
        return find(counter, value);
    }

    /**
     * find the object in the table
     * @param array the array of the object
     * @param value the value of the object
     * @return the object
     * @param <T> the type of the object
     */
    public static <T> T find(T[] array, T value) {
        final Iterator<T> counter = Arrays.stream(array).iterator();
        return find(counter, value);
    }


    /**
     * find the object in the table
     * @param array the array of the object
     * @param pred the predicate
     * @return the object
     * @param <T> the type of the object
     */
    public static <T> T find(T[] array, Predicate<T> pred) {
        final Iterator<T> counter = Arrays.stream(array).iterator();
        return find(counter, pred);
    }

    /**
     * find the object in the table
     * @param iterable the iterable object
     * @param pred the predicate
     * @return the object
     * @param <T> the type of the object
     */
    public static <T> T find(Iterable<T> iterable, Predicate<T> pred) {
        final Iterator<T> counter = iterable.iterator();
        return find(counter, pred);
    }


    /**
     * find the object in the table
     * @param iterator the iterator of the object
     * @param value the value of the object
     * @return the object
     * @param <T> the type of the object
     */
    public static <T> T find(Iterator<T> iterator, T value) {
        final Predicate<T> pred = value::equals;
        return find(iterator, pred);
    }

    /**
     * find the object in the table
     * @param iterator the iterator of the object
     * @param pred the predicate
     * @return the object
     * @param <T> the type of the object
     */
    public static <T> T find(Iterator<T> iterator, Predicate<T> pred) {
        while (iterator.hasNext()) {
            T current = iterator.next();
            if (pred.predicate(current))
                return current;
        }
        return null;
    }


    /**
     * partition the table
     * @param array the array of the object
     * @param page the page
     * @param pageSize the page size
     * @param pred the predicate
     * @return the partition
     * @param <T> the type of the object
     */
    public static <T> List<T> paginate(T[] array, int page, int pageSize, Predicate<T> pred) {
        final Iterator<T> counter = Arrays.stream(array).iterator();
        return paginate(counter, page, pageSize, pred);
    }

    /**
     * partition the table
     * @param iterable the iterable object
     * @param page the page
     * @param pageSize the page size
     * @param pred the predicate
     * @return the partition
     * @param <T> the type of the object
     */
    public static <T> List<T> paginate(Iterable<T> iterable, int page, int pageSize, Predicate<T> pred) {
        final Iterator<T> counter = iterable.iterator();
        return paginate(counter, page, pageSize, pred);
    }

    /**
     * partition the table
     * @param iterator the iterator of the object
     * @param page the page
     * @param pageSize the page size
     * @param pred the predicate
     * @return the partition
     * @param <T> the type of the object
     */
    public static <T> List<T> paginate(Iterator<T> iterator, int page, int pageSize, Predicate<T> pred) {
        List<T> list = new ArrayList<>();
        int tally = 0;
        int size = 0;
        while (iterator.hasNext()) {
            T current = iterator.next();
            if (pred.predicate(current)) {
                if (size == pageSize)
                    break;
                if (tally >= page * pageSize) {
                    list.add(current);
                    size++;
                }
                tally++;
            }
        }
        return list;
    }

}