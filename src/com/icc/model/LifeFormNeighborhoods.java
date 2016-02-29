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
public class LifeFormNeighborhoods {

    private HashMap<Integer,LifeFormAddresses> neighborsHoodOfLifeForms;

    public LifeFormNeighborhoods() {
        this.neighborsHoodOfLifeForms = new HashMap<>();
    }

    public HashMap<Integer, LifeFormAddresses> getNeighborsHoods(){
        return neighborsHoodOfLifeForms;
    }

    public Boolean isAliveAt(Point p) {
        if(neighborsHoodOfLifeForms.containsKey(p.getRow())){
            LifeFormAddresses lfCol = neighborsHoodOfLifeForms.get(p.getRow());
            return lfCol.isAliveAt(p.getColumn());
        }
        return false;
    }

    public void createLifeAt(Point p) {
        if(neighborsHoodOfLifeForms.containsKey(p.getRow())){
            LifeFormAddresses lfCol = neighborsHoodOfLifeForms.get(p.getRow());
            if(!lfCol.isAliveAt(p.getColumn())){
                lfCol.create(p.getColumn());
            }
        } else {
            LifeFormAddresses lfCol = new LifeFormAddresses();
            lfCol.create(p.getColumn());
            neighborsHoodOfLifeForms.put(p.getRow(), lfCol);
        }

    }

    public int getMaxHeight() {
        return neighborsHoodOfLifeForms.size() > 0 ? Collections.max(neighborsHoodOfLifeForms.keySet()) : 0;
    }

    public int getMaxWidth() {
        Set<Integer> widths = new HashSet<>();
        neighborsHoodOfLifeForms.entrySet().stream().forEach(add -> widths.add(add.getValue().getWidth()));
        return widths.size() > 0 ? Collections.max(widths) : 0;
    }

    public int getMinHeight() {
        return neighborsHoodOfLifeForms.size() > 0 ? Collections.min(neighborsHoodOfLifeForms.keySet()) : 0;
    }

    public int getMinWidth() {
        Set<Integer> widths = new HashSet<>();
        neighborsHoodOfLifeForms.entrySet().stream().forEach(add -> widths.add(add.getValue().getWidth()));
        return widths.size() > 0 ? Collections.min(widths) : 0;
    }

}
