package com.company;

import java.util.HashMap;
import java.util.Map;

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
    private Map<Integer, Integer> statistics;


    public EverySecond(ListOfNumbers listOfNumbers) {
        this.listOfNumbers = listOfNumbers;
        this.statistics = new HashMap<>();
    }

    @Override
    public void run() {
        int timeToSleep = 5000;
        while (!listOfNumbers.to_stop){
            listStatistics();
            try {
                Thread.sleep(timeToSleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            check_stop();
        }
    }

    private void check_stop() {
        int whenStop = 5;//по заданию 1
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
