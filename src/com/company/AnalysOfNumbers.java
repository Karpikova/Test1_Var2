package com.company;

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
public class AnalysOfNumbers implements Runnable{

    private ListOfNumbers listOfNumbers;

    public AnalysOfNumbers(ListOfNumbers listOfNumbers) {
        this.listOfNumbers = listOfNumbers;
    }

    @Override
    public void run() {
        Random rand = new Random();
        int currentNumber;
        int timeToSleep = 1000;
        int max = 99;
        while (!listOfNumbers.to_stop){ //хм, я сделала без wait и notify...
            currentNumber = rand.nextInt(max);
            listOfNumbers.numbers.add(currentNumber);
            try {
                Thread.sleep(timeToSleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
