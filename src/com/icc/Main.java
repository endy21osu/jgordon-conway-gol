package com.icc;

import com.icc.model.Population;
import com.icc.service.LifeHelper;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        String fName = "C:\\workspace\\jgordon-conway-gol\\data\\popState9.txt";
        LifeHelper lf = new LifeHelper() ;
        long startTime, endTime;
        List<Integer> speedOfTest = new ArrayList<>();
        System.out.println(" args " + args.length);

        if( args.length > 1 ){
            System.out.println(" file " + args[0]);
            fName = args[0];
        }

        Population pop = new Population(fName);

        System.out.println("First pop");
        pop.printPopulation();

        for(int testTimes = 100; testTimes > 0; testTimes--) {
            startTime = System.currentTimeMillis();
            for (int i = 0; i < 200; i++) {

                pop = lf.processGeneration(pop);

//                pop.printPopulation();
//            try {
//                Thread.sleep(700);
//            } catch(InterruptedException ex) {
//                Thread.currentThread().interrupt();
//            }
            }
            endTime = System.currentTimeMillis();
//            pop.printPopulation();
            speedOfTest.add((int) (long) (endTime-startTime));
            System.out.println("Total execution time: " + (endTime - startTime));
        }

        int sum = speedOfTest.stream().mapToInt(Integer::intValue).sum();

        try {
            PrintWriter writer = new PrintWriter(fName + "." + System.currentTimeMillis() + ".test", "UTF-8");
            writer.println("For test data set " + fName);
            writer.println("Total run time for this test is " + sum + " milliseconds");
            writer.println("Average run time is " + sum/speedOfTest.size() + " milliseconds");

            speedOfTest.stream().forEach((time) -> {
                writer.println("Speed: " + time + " ms");

            });


            writer.close();
        } catch (IOException ioe) {
            System.out.println("Failed to write test results to file");
            System.out.println(ioe.getMessage());
        }

        speedOfTest.stream().forEach((time) -> {
            System.out.println("Speed " + time);
        });
        System.out.println("For test data set " + fName);
        System.out.println("Total run time for this test is " + sum + " milliseconds");
        System.out.println("Average run time is " + sum/speedOfTest.size() + " milliseconds");

//        System.out.println("callcountWhoIsAround " + lf.callcountWhoIsAround);
//        System.out.println("callcountprocessGeneration " + lf.callcountprocessGeneration);
//        System.out.println("callcountwhoIsAroundNew " + lf.callcountwhoIsAroundNew);
//        System.out.println("callcountlifeSurvivesAt " + lf.callcountlifeSurvivesAt);
//        System.out.println("callcountlifeCreatesAt " + lf.callcountlifeCreatesAt);


    }
}

