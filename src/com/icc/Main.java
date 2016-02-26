package com.icc;

import com.icc.model.Population;


public class Main {

    public static void main(String[] args) {

        String fName = "C:\\data\\popState1.txt";

        Population pop = new Population(fName);
        System.out.println(pop.printPopulation());

    }
}

