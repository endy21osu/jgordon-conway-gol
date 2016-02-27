package com.icc.model;

import java.util.*;

/**
 * Created by endocron on 2/25/2016.
 *
 * neighbor array
 *      0 1 2
 *      3 o 4
 *      5 6 7
 *
 */
public class LifeForm {

    private Point location;
    private Boolean alive;
    private Neighbors neighbors;

    public LifeForm(Boolean alive, Point loc) {
        this.alive = alive;
        this.location = loc;
        this.neighbors = new Neighbors();
    }

    public LifeForm() {
        alive = false;
        this.neighbors = new Neighbors();
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public Boolean isAlive() {
        return alive;
    }

    public int getNumberOfneighbors() {
        return neighbors.getNumberOfNeighbors();
    }

    public void setNeighbor(Point p) {
        neighbors.addNeighbor(p);
    }



    public void create() {
        neighbors.clearNeighbors();
        this.alive = true;
    }

    public void kill() {
        neighbors.clearNeighbors(); this.alive = false;
    }


}
