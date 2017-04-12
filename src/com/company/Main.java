package com.company;

public class Main {

    public static void main(String[] args) {
        ListOfNumbers listOfNumbers = new ListOfNumbers();

        EverySecond everySecond = new EverySecond(listOfNumbers);
        Thread everySecondThread = new Thread(everySecond);
        everySecondThread.start();

        AnalysOfNumbers analysOfNumbers = new AnalysOfNumbers(listOfNumbers);
        Thread analysOfNumbersThread = new Thread(analysOfNumbers);
        analysOfNumbersThread.start();
    }
}
