package com.preference.utils;

/**
 * Created by Ali Esa Assadi on 30/11/2018.
 */
public class WrongValueException extends IllegalArgumentException{
    public WrongValueException(Object value) {
        super("you have used {" + value + "} value");
    }
}
