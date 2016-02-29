package com.icc.model

import com.icc.service.LifeHelper

/**
 * Created by jgordon on 2/25/2016.
 */
class PopulationTest extends GroovyTestCase {

    private String fName = "C:\\data\\popState1.txt"
    private String fName2 = "C:\\data\\popState2.txt"
    private LifeHelper lf = new LifeHelper();
    private final static Point p = new Point(3,4)
    private Population rcPop
    private Population fPop

    private LifeFormNeighborhoods lifeForm = new LifeFormNeighborhoods();

    void setUp() {
        super.setUp()
        rcPop = new Population(fName2);
        fPop = new Population(fName)

    }

    void testGetWidth() {
        int w = fPop.getWidth()

        assert w == 8
    }

    void testGetHeight() {
        int h = fPop.getHeight()

        assert h == 6;
    }

    void testGetMembers() {

        LifeFormNeighborhoods tempMembres = fPop.getMembers()

        assert tempMembres.isAliveAt(new Point(0,6))

    }

    void testAddMember() {
        Point p = new Point(0,0)
        fPop.addMember(p)

        assert fPop.getMembers().isAliveAt(p)
    }

    void testSetMembers() {
        rcPop.setMembers(fPop.getMembers())

        assert rcPop.getMembers().isAliveAt(new Point(1,0))
    }

    void testPrintPopulation() {
        fPop.printPopulation()

        assert true

        fPop.printPopulation(fPop.getMembers())

        assert true
    }
}
