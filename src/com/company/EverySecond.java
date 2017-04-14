package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*
 * ${Classname}
 * 
 * Version 1.0 
 * 
 * 12.04.2017
 * 
 * Karpikova
 */
public class EverySecond implements Runnable{

    private ListOfNumbers listOfNumbers;

    public EverySecond(ListOfNumbers listOfNumbers) {
        this.listOfNumbers = listOfNumbers;
    }

    @Override
    public void run() {
        Random rand = new Random();
        int currentNumber;
        int timeToSleep = 1000;
        int max = 99;
        while (!listOfNumbers.to_stop){ //хм, я сделала без wait и notify...
            // а с ними бы и не получилось, т.к. поток должен не только ждать условия прекращения,
            // но и продолжать выполняться
            currentNumber = rand.nextInt(max);
            synchronized (listOfNumbers)
            {
                listOfNumbers.numbers.add(currentNumber);
            }
            try {
                Thread.sleep(timeToSleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
