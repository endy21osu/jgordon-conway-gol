package com.icc.model

import com.icc.service.LifeHelper

/**
 * Created by jgordon on 2/25/2016.
 */
class PopulationTest extends GroovyTestCase {

    private String fName = "C:\\data\\popState1.txt"
    private LifeHelper lf = new LifeHelper();
    private final static Point p = new Point(3,4)
    private Population rcPop
    private Population fPop

    private LifeFormNeighborhoods lifeForm = new LifeFormNeighborhoods(false, p)

    void setUp() {
        super.setUp()
        rcPop = new Population(5, 5)
        fPop = new Population(fName)

    }

    void testProcessGeneration() {

        Population nextGen = lf.processGeneration(fPop)

        assert nextGen.getMembers()[0][1].isAlive();
    }

    void testGetMembers() {

        LifeFormNeighborhoods[][] tempMembres = fPop.getMembers()

        assert tempMembres[1][0].isAlive()

    }

    void testAddMember() {

        fPop.addMember(lifeForm)

        assert !fPop.members[3][4].isAlive()
    }

    void testSetMembers() {
        rcPop.setMembers(new LifeFormNeighborhoods[2][2])

        assert rcPop.members[0].length == 2
        assert rcPop.members.length == 2
    }

    void testPrintPopulation() {
        fPop.printPopulation()

        assert true

        fPop.printPopulation(fPop.getMembers())

        assert true
    }
}
