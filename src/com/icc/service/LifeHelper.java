package com.icc.service;

import com.icc.model.*;

/**
 * Created by endocron on 2/25/2016.
 */
public class LifeHelper {

//    public int callcountWhoIsAround = 0;
//    public int callcountprocessGeneration = 0;
//    public int callcountwhoIsAroundNew = 0;
//    public int callcountlifeSurvivesAt = 0;
//    public int callcountlifeCreatesAt = 0;

    public Population processGeneration(Population pop) {
//        callcountprocessGeneration++;
        LifeFormNeighborhoods lfHoods = pop.getMembers();
        LifeFormNeighborhoods newHoods = new LifeFormNeighborhoods();

        lfHoods.getNeighborsHoods().forEach((row,address) ->
                address.getLifeForms().forEach((col) ->
                whoIsAround(new Point(row, col), pop, newHoods)));

        pop.setMembers(newHoods);

        return pop;
    }

    private void whoIsAround(Point p, Population pop, LifeFormNeighborhoods newHoods) {
//        callcountWhoIsAround++;
        int scope = 1, row = p.getRow(), col = p.getColumn(), neighbors = 0;
//        int width = pop.getWidth(), height = pop.getHeight();
        LifeFormNeighborhoods lfHoods = pop.getMembers();
        Point nP;

        for(int rA = -scope; rA <= scope; rA++){
            for(int cA = -scope; cA <= scope; cA++){
                if(!(cA == 0 && rA == 0)) {
                    int nRow = row + rA;
                    int nCol = col + cA;
//                    if(nRow >= 0 && nCol >= 0 && nCol <= width && nRow <= height) {
                        nP = new Point(nRow, nCol);
                        if (lfHoods.isAliveAt(nP)) {
                            neighbors++;
                        } else {
                            newHoods = whoIsAroundNew(nP, pop, newHoods);
                        }
//                    }
                }
            }
        }

        lifeSurvivesAt(p, newHoods, neighbors);


    }

    private void lifeSurvivesAt(Point p, LifeFormNeighborhoods lfHoods, Integer numberOfNeighbors){

        if(2 == numberOfNeighbors || 3 == numberOfNeighbors)
            lfHoods.createLifeAt(p);

    }

    private LifeFormNeighborhoods whoIsAroundNew(Point p, Population pop, LifeFormNeighborhoods newHoods) {
//        callcountwhoIsAroundNew++;
        int scope = 1, row = p.getRow(), col = p.getColumn(), neighbors = 0;
//        int width = pop.getWidth(), height = pop.getHeight();
        LifeFormNeighborhoods lfHoods = pop.getMembers();
        Point nP;

        for(int rA = -scope; rA <= scope; rA++){
            for(int cA = -scope; cA <= scope; cA++){
                if(!(cA == 0 && rA == 0)) {
                    int nRow = row + rA;
                    int nCol = col + cA;
//                    if(nRow >= 0 && nCol >= 0 && nCol <= width && nRow <= height) {
                        nP = new Point(nRow, nCol);
                        if (lfHoods.isAliveAt(nP))
                            neighbors++;
//                    }
                }
            }
        }

        newHoods = lifeIsCreatedAt(p, newHoods, neighbors);

        return newHoods;

    }

    private LifeFormNeighborhoods lifeIsCreatedAt(Point p, LifeFormNeighborhoods lfHoods, Integer numberOfNeighbors){
//        callcountlifeCreatesAt++;
        if(numberOfNeighbors == 3)
            lfHoods.createLifeAt(p);

        return lfHoods;

    }

    public void printCurrentPopulationIn(LifeFormNeighborhoods lifeFormHoods){
        System.out.print("Current Pop is: \n");
        lifeFormHoods.getNeighborsHoods().forEach((row, lfHoods) -> {
            lfHoods.getLifeForms().forEach((col) ->
                System.out.print("[" + row + ", " + col + "], "));
            System.out.print("\n");
        });
        System.out.print("\n");
    }

}
