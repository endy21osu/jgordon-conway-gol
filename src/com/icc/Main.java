package com.icc;

import com.icc.model.LifeForm;
import com.icc.model.Point;
import com.icc.model.Population;
import com.icc.service.LifeHelper;

import java.io.*;


public class Main {

    public static void main(String[] args) {

        LifeHelper lh = new LifeHelper();
        LifeForm lifeForm;
        String fName = "C:\\data\\popState1.txt";

        BufferedReader br = null;

        try {
            int rows,cols;
            rows = lh.countLines(fName);

            String currentLine;
            br = new BufferedReader(new FileReader(fName));
            currentLine = br.readLine();

            cols = currentLine.length();
            System.out.println("The number of rows are " + rows);
            System.out.println("The number of cols are " + cols);

            Population pop = new Population(rows, cols);
            for(int row = 0; row < rows; row++) {
                System.out.println(currentLine);
                for(int col = 0; col < currentLine.length(); col++) {
                    lifeForm = new LifeForm( currentLine.charAt(col) != '.' ? true : false, new Point(row, col));
                    pop.addMember(lifeForm);
                }
                currentLine = br.readLine();
            }

            pop.printPopulation();


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
}

