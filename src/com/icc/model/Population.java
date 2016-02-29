package com.icc.model;

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
        int maxHeight = lifeFormHoods.getMaxHeight() + 1, maxWidth = lifeFormHoods.getMaxWidth() + 1;
        int minHeight = lifeFormHoods.getMinHeight() < 0 ? lifeFormHoods.getMinHeight() : 0, minWidth = lifeFormHoods.getMinWidth() < 0 ? lifeFormHoods.getMinWidth() : 0;
        
        System.out.println("The population model for height: " + (maxHeight - minHeight) + " width: " + (maxWidth - minWidth) + " is: \n");
        System.out.println();
        for(int row = minHeight; row < maxHeight; row++) {
            for(int col = minWidth; col <  maxWidth; col++) {
                    System.out.print(lifeFormHoods.isAliveAt(new Point(row, col)) ? 'o' : '.');
            }
            System.out.print('\n');
        }
    }

}
