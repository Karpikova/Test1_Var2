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
public class AnalysOfNumbers implements Runnable{

    private ListOfNumbers listOfNumbers;
    private Map<Integer, Integer> statistics;


    public AnalysOfNumbers(ListOfNumbers listOfNumbers) {
        this.listOfNumbers = listOfNumbers;
        this.statistics = new HashMap<>();
    }

    @Override
    public void run() {
        int timeToSleep = 5000;
        while (!listOfNumbers.to_stop){
            try {
                Thread.sleep(timeToSleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            listStatistics();
            check_stop();
        }
    }

    private void check_stop() {
        Integer whenStop = 3;
        for (Map.Entry<Integer, Integer> element : statistics.entrySet())
        {
            if (element.getValue() >= whenStop){
                listOfNumbers.setTo_stop(true);
            }
        }
    }

    private void listStatistics() {
        clearStatistic();
        int cur_num;
        int cur_quan;
        for(int i = 0; i < listOfNumbers.numbers.size(); i++) {
            cur_num = listOfNumbers.numbers.get(i);
            cur_quan = statistics.get(cur_num);
            statistics.put(cur_num, cur_quan+1);
        }
        System.out.println(statistics);
    }

    private void clearStatistic() {
        for (int i = 0; i < 100; i++){
            statistics.put(i, 0);
        }
    }
}
