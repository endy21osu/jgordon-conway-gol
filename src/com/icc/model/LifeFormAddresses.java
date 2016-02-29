package com.icc.model;

import java.util.Collections;
import java.util.TreeSet;

/**
 * Created by endocron on 2/25/2016.
 *
 * neighbor array
 *      0 1 2
 *      3 o 4
 *      5 6 7
 *
 */
public class LifeFormAddresses {

    private TreeSet<Integer> addressesOfLifeForms;

    public LifeFormAddresses() {
        this.addressesOfLifeForms = new TreeSet<>();
    }

    public TreeSet<Integer> getLifeForms(){
        return addressesOfLifeForms;
    }

    public Boolean isAliveAt(Integer col) {
        return addressesOfLifeForms.contains(col);
    }

    public void create(Integer col) {
        addressesOfLifeForms.add(col);
    }

    public void kill(Integer col) {
        addressesOfLifeForms.remove(col);
    }

    public Integer getWidth() {
        return Collections.max(addressesOfLifeForms);
    }

}
