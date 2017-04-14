package com.company;

import java.util.ArrayList;
import java.util.List;

/*
 * ${Classname}
 * 
 * Version 1.0 
 * 
 * 12.04.2017
 * 
 * Karpikova
 */
public class ListOfNumbers {
    static List<Integer> numbers;
    static volatile boolean to_stop;

    static {
        numbers = new ArrayList<>();
        to_stop = false;
    }

    public static void setTo_stop(boolean to_stop) {
        ListOfNumbers.to_stop = to_stop;
    }
}
