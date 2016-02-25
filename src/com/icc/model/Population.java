package com.icc.model;



/**
 * Created by endocron on 2/25/2016.
 */
public class Population {

    private LifeForm[][] members;

    public Population (int row, int col){
        this.members = new LifeForm[row][col];
    }

    public void processGeneration() {
          discoverNeighbors(members);
//        makeNewLife(members);

    }

    private void discoverNeighbors(LifeForm[][] members) {
        for(int row = 0; row < members.length; row++) {
            for(int col = 0; col < members[row].length; col++) {
                LifeForm lifeForm = members[row][col];
                lifeForm.getNeighbors()[0] = members[row - 1][col -1].isAlive();
                lifeForm.getNeighbors()[1] = members[row - 1][col].isAlive();
                lifeForm.getNeighbors()[2] = members[row - 1][col + 1].isAlive();
                lifeForm.getNeighbors()[3] = members[row][col -1].isAlive();
                lifeForm.getNeighbors()[4] = members[row][col +1].isAlive();
                lifeForm.getNeighbors()[5] = members[row + 1][col -1].isAlive();
                lifeForm.getNeighbors()[6] = members[row + 1][col].isAlive();
                lifeForm.getNeighbors()[7] = members[row + 1][col + 1].isAlive();
            }
            System.out.print('\n');
        }
    }

    public void addMember(LifeForm lifeForm) {
        System.out.println("Life Form added at row " + lifeForm.getLocation().getRow() + " col " + lifeForm.getLocation().getColumn() );
        members[lifeForm.getLocation().getRow()][lifeForm.getLocation().getColumn()] = lifeForm;
    }

    public LifeForm[][] getMembers() {
        return members;
    }

    public void setMembers(LifeForm[][] members) {
        this.members = members;
    }

    public void printPopulation(){
        System.out.println("The population model is: \n");
        for(int row = 0; row < members.length; row++) {
            for(int col = 0; col < members[row].length; col++) {
                System.out.print(members[row][col].isAlive() ? 'o' : '.');
            }
            System.out.print('\n');
        }
    }



}
