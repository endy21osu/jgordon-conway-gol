package com.icc.service

import com.icc.model.*

/**
 * Created by jgordon on 2/27/2016.
 */
class LifeHelperTest extends GroovyTestCase {

    private final static String fName = "C:\\data\\popState1.txt"
    private LifeHelper lifeHelper
    private Population fPop = new Population(fName)


    void setUp() {
        super.setUp()
        lifeHelper = new LifeHelper()

    }

    void tearDown() {

    }

    void testProcessGeneration() {
        fPop =lifeHelper.processGeneration(fPop)

        assert fPop.getMembers().isAliveAt(new Point(0,1))
    }

    void testPrintCurrentPopulationIn() {
        lifeHelper.printCurrentPopulationIn(fPop.getMembers());

        assert true
    }
}
