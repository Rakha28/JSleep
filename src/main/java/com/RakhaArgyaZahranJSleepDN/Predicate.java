package com.RakhaArgyaZahranJSleepDN;


/**
 * Predicate class for the database.
 * @param <T> the type of the predicate
 * @author Rakha Argya Zahran
 * @version 0.1
 */
public interface Predicate<T> {
    public abstract boolean predicate(T arg);
}
