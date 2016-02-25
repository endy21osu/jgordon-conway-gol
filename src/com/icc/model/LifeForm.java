package com.icc.model;

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
    private Boolean[] neighbors;

    public LifeForm(Boolean alive, Point loc) {
        this.alive = alive;
        this.location = loc;
        this.neighbors = new Boolean[8];
    }

    public LifeForm() {
        alive = false;
    }

    public Boolean[] getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(Boolean[] neighbors) {
        this.neighbors = neighbors;
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

    public void create() {
        this.alive = true;
    }

    public void kill() {
        this.alive = false;
    }


}
