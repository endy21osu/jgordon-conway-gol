package com.icc.model;

import com.icc.service.LifeHelper;

import java.io.*;

/**
 * Created by endocron on 2/25/2016.
 */
public class Population {

    private LifeFormNeighborhoods lifeFormHoods;
    private int height;
    private int width;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Population(Population oldPop){
        this.lifeFormHoods = oldPop.getMembers();
    }

    public Population (){
        this.lifeFormHoods = new LifeFormNeighborhoods();
    }

    public Population(String fName) {
        BufferedReader br = null;
        int cols;

        try {
            String currentLine;
            br = new BufferedReader(new FileReader(fName));
            currentLine = br.readLine();
            width = currentLine.length();
            this.lifeFormHoods = new LifeFormNeighborhoods();

            int row = 0;
            do {
                cols = currentLine.length();
                for (int col = 0; col < cols; col++) {
                    char c = currentLine.charAt(col);
                    if (c != '.') {
                        this.lifeFormHoods.createLifeAt(new Point(row, col));
                    }
                }

                currentLine = br.readLine();

                row++;
            }while (currentLine != null);
            height = row++;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

    public void addMember(Point p) {
        lifeFormHoods.createLifeAt(p);
    }

    public LifeFormNeighborhoods getMembers() {
        return lifeFormHoods;
    }

    public void setMembers(LifeFormNeighborhoods lifeFormHoods) {
        this.lifeFormHoods = lifeFormHoods;
    }

    public void printPopulation(){
        printPopulation(lifeFormHoods);
    }

    public void printPopulation(LifeFormNeighborhoods lifeFormHoods){
//        int height = lifeFormHoods.getHeight() + 1, width = lifeFormHoods.getWidth() + 1;
        System.out.println("height: " + height + " width: " + width);
        System.out.println("The population model is: hello\n");

        System.out.println();
        for(int row = 0; row < height; row++) {
            for(int col = 0; col <  width; col++) {
                    System.out.print(lifeFormHoods.isAliveAt(new Point(row, col)) ? 'o' : '.');
            }
            System.out.print('\n');
        }
    }

}
