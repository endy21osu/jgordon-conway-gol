package com.icc;

import com.icc.model.Population;
import com.icc.service.LifeHelper;

import javax.swing.JOptionPane;

import java.io.*;
import java.net.URL;
import java.util.*;



public class Main {

    public static void main(String[] args) {

//        JOptionPane.showMessageDialog(null, "Results succesfully saved!");

        System.out.println("This is the Start of the Game of Life");

        Console c = System.console();

        if (c == null) {
            System.err.println("No console.");
            System.exit(1);
        }

        String startPopF = new String(),generations = new String();
        while (startPopF.length() == 0){
            startPopF = c.readLine("Enter Starting population file location: ");
            generations = c.readLine("Enter number of generations: ");
        }

        int gen = generations.length() == 0 ? 1 : Integer.valueOf(generations);

        String filePath = new File("").getAbsolutePath();
        filePath = filePath + "\\data\\" + startPopF;

        LifeHelper lf = new LifeHelper() ;
        long startTime, endTime;
        List<Integer> speedOfTest = new ArrayList<>();


        Population pop = new Population(filePath);

        System.out.println("First pop for file : " + startPopF);
        pop.printPopulation();

        for(int testTimes = 1; testTimes > 0; testTimes--) {

            for (int i = 0; i < gen; i++) {
                startTime = System.currentTimeMillis();
                pop = lf.processGeneration(pop);
                endTime = System.currentTimeMillis();
                System.out.println("---------------------------------------------");
                pop.printPopulation();
                System.out.println("---------------------------------------------");
//                lf.printCurrentPopulationIn(pop.getMembers());
//                System.out.println("---------------------------------------------");
            try {
                Thread.sleep(500);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
                speedOfTest.add((int) (long) (endTime-startTime));
                System.out.println("Total execution time: " + (endTime - startTime) + " To creat Population " + (i + 1));
                System.out.println("---------------------------------------------");
                System.out.println();
            }
        }

        int sum = speedOfTest.stream().mapToInt(Integer::intValue).sum();

//        try {
//            PrintWriter writer = new PrintWriter(fName + "." + System.currentTimeMillis() + ".test", "UTF-8");
//            writer.println("For test data set " + fName);
//            writer.println("Total run time for this test is " + sum + " milliseconds");
//            writer.println("Average run time is " + sum/speedOfTest.size() + " milliseconds");
//
//            speedOfTest.stream().forEach((time) -> {
//                writer.println("Speed: " + time + " ms");
//
//            });
//
//
//            writer.close();
//        } catch (IOException ioe) {
//            System.out.println("Failed to write test results to file");
//            System.out.println(ioe.getMessage());
//        }

        System.out.println("");
        System.out.println("**************************************");
        System.out.println("Game of life is over!");
//        speedOfTest.stream().forEach((time) -> {
//            System.out.println("Speed " + time);
//        });
        System.out.println("For test data set " + startPopF);
        System.out.println("Total run time for this test is " + sum + " milliseconds");
        System.out.println("Average run time is " + sum/speedOfTest.size() + " milliseconds");

//        System.out.println("callcountWhoIsAround " + lf.callcountWhoIsAround);
//        System.out.println("callcountprocessGeneration " + lf.callcountprocessGeneration);
//        System.out.println("callcountwhoIsAroundNew " + lf.callcountwhoIsAroundNew);
//        System.out.println("callcountlifeSurvivesAt " + lf.callcountlifeSurvivesAt);
//        System.out.println("callcountlifeCreatesAt " + lf.callcountlifeCreatesAt);


    }
}

