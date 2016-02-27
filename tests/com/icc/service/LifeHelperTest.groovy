package com.icc.service

import com.icc.model.Population

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

    void testCountLines() {
        int lines = lifeHelper.countLines(fName)

        assert lines == 6
    }

    void testProcessGeneration() {
        fPop =lifeHelper.processGeneration(fPop)

        assert fPop.getMembers()[0][1].isAlive()
    }
}
