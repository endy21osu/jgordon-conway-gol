package com.icc.model;

import java.util.*;

/**
 * Created by jgordon on 2/26/2016.
 */
public class Neighbors {

    private List<Point> lifeLocations;

    public Neighbors(){
        lifeLocations = new ArrayList<>();
    }

    public List<Point> getNeighborLocations() {
        return lifeLocations;
    }

    public void addNeighbor(Point p){
        lifeLocations.add(p);
    }

    public void clearNeighbors(){
        lifeLocations.clear();
    }

    public int getNumberOfNeighbors(){
        return lifeLocations.size();
    }

}
