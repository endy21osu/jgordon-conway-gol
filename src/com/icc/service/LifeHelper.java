package com.icc.service;

import com.icc.model.*;

import java.io.*;

/**
 * Created by endocron on 2/25/2016.
 */
public class LifeHelper {

    public static int countLines(String filename) throws IOException {
        InputStream is = new BufferedInputStream(new FileInputStream(filename));
        try {
            byte[] c = new byte[1024];
            int count = 0;
            int readChars = 0;
            boolean empty = true;
            while ((readChars = is.read(c)) != -1) {
                empty = false;
                for (int i = 0; i < readChars; ++i) {
                    if (c[i] == '\n') {
                        ++count;
                    }
                }
            }
            return (count == 0 && !empty) ? 1 : count;
        } finally {
            is.close();
        }
    }

    public Population processGeneration(Population pop) {
        discoverNeighbors(pop.getMembers());
        return makeNewLife(pop);

    }

    private void discoverNeighbors(LifeForm[][] members) {
        for(int row = 0; row < members.length; row++) {
            for(int col = 0; col < members[row].length; col++) {
                members[row][col] = whoIsAround(members[row][col], members);
            }
        }
    }

    private LifeForm whoIsAround(LifeForm lifeForm, LifeForm[][] members) {
        int scope = 1; int row = lifeForm.getLocation().getRow(); int col = lifeForm.getLocation().getColumn();

        for(int rA = -scope; rA <= scope; rA++){
            for(int cA = -scope; cA <= scope; cA++){
                if(!(cA == 0 && rA == 0)) {
                    int nRow = row + rA;
                    int nCol = col + cA;

                    if (nRow >= 0 && nCol >= 0 && nRow < members.length && nCol < members[0].length)
                        if (members[nRow][nCol].isAlive())
                            lifeForm.setNeighbor(new Point(nRow, nCol));

                }
            }
        }

        return lifeForm;
    }

    private Population makeNewLife(Population pop){
        LifeForm[][] members = pop.getMembers();
        Population newPop = new Population(pop.getMembers().length, pop.getMembers()[0].length);
        LifeForm[][] newMembers = newPop.getMembers();

        LifeForm tempLifeForm;

        for(int row = 0; row < members.length; row++) {
            for(int col = 0; col < members[row].length; col++) {

                tempLifeForm = members[row][col];

                int numberOfNeighbors = tempLifeForm.getNumberOfneighbors();

                if(tempLifeForm.isAlive())
                    if(2 == numberOfNeighbors || 3 == numberOfNeighbors)
                        tempLifeForm.create();
                    else
                        tempLifeForm.kill();
                else
                if(numberOfNeighbors == 3)
                    tempLifeForm.create();
                else
                    tempLifeForm.kill();

                newMembers[row][col] = tempLifeForm;


            }
        }

        return newPop;
    }
}
