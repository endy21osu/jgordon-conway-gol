package com.icc.model;

import com.icc.service.LifeHelper;

import java.io.*;

/**
 * Created by endocron on 2/25/2016.
 */
public class Population {

    private LifeForm[][] members;

    public Population(Population oldPop){
        this.members = oldPop.getMembers();
    }


    public Population (int row, int col){
        this.members = new LifeForm[row][col];
    }

    public Population(String fName) {
        LifeHelper lh = new LifeHelper();
        LifeForm lifeForm;
        BufferedReader br = null;
        int rows,cols;

        try {
            rows = lh.countLines(fName);

            String currentLine;
            br = new BufferedReader(new FileReader(fName));
            currentLine = br.readLine();

            cols = currentLine.length();

            this.members = new LifeForm[rows][cols];

            for(int row = 0; row < rows; row++) {
                for (int col = 0; col < currentLine.length(); col++) {
                    lifeForm = new LifeForm(currentLine.charAt(col) != '.', new Point(row, col));
                    this.addMember(lifeForm);
                }
                currentLine = br.readLine();
            }

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

    public void addMember(LifeForm lifeForm) {
        members[lifeForm.getLocation().getRow()][lifeForm.getLocation().getColumn()] = lifeForm;
    }

    public LifeForm[][] getMembers() {
        return members;
    }

    public void setMembers(LifeForm[][] members) {
        this.members = members;
    }

    public void printPopulation(){
        printPopulation(members);
    }

    public void printPopulation(LifeForm[][] members){
        System.out.println("The population model is: \n");
        for(int row = 0; row < members.length; row++) {
            for(int col = 0; col < members[row].length; col++) {
                if(members[row][col] != null)
                    System.out.print(members[row][col].isAlive() ? 'o' : '.');
            }
            System.out.print('\n');
        }
    }

}
