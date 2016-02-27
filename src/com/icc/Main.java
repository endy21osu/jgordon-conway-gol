package com.icc;

import com.icc.model.Population;
import com.icc.service.LifeHelper;


public class Main {

    public static void main(String[] args) {

        String fName = "C:\\data\\popState1.txt";
        LifeHelper lf = new LifeHelper();

        Population pop = new Population(fName);
        System.out.println("First pop");
        pop.printPopulation();

        for(int i = 0; i < 10; i++){
            pop = lf.processGeneration(pop);
            System.out.println("pop " + i);
            pop.printPopulation();
            try {
                Thread.sleep(300);                 //1000 milliseconds is one second.
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }

    }
}

