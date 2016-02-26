package com.icc.model

/**
 * Created by jgordon on 2/25/2016.
 */
class PopulationTest extends GroovyTestCase {

    private String fName = "C:\\data\\popState1.txt";
    private final static Point p = new Point(3,4);
    private Population rcPop;
    private Population fPop;

    private LifeForm lifeForm = new LifeForm(false, p);

    void setUp() {
        super.setUp();
        rcPop = new Population(5, 5);
        fPop = new Population(fName);

    }

    void testProcessGeneration() {
        String f2Name = "C:\\data\\popState2.txt";
        Population expectPop = new Population(f2Name);
        Population nextGen = fPop.processGeneration();

        assertArrayEquals(expectPop.members, nextGen.members);
    }

    void testGetMembers() {

        LifeForm[][] tempMembres = fPop.getMembers();

        assert tempMembres[0][1].isAlive();

    }

    void testAddMember() {

        fPop.addMember(lifeForm);

        assert !fPop.members[3][4].isAlive();
    }

    void testSetMembers() {
        rcPop.setMembers(new LifeForm[2][2]);

        assert rcPop.members[0].length == 2;
        assert rcPop.members.length == 2;
    }

    void testPrintPopulation() {

    }
}
