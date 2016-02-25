package com.icc.model;

/**
 * Created by endocron on 2/25/2016.
 */
public class Point {

    private int row;
    private int column;

    public Point (int row, int col){
        this.row = row;
        this.column = col;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }



}
