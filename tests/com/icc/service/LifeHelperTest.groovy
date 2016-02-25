package com.icc.service


import groovy.util.GroovyTestCase;
import junit.*


/**
 * Created by endocron on 2/25/2016.
 */
class LifeHelperTest extends groovy.util.GroovyTestCase {

    private final static String fName = "C:\\data\\popState1.txt";
    private LifeHelper lifeHelper;

    void setUp() {
        super.setUp();
        lifeHelper = new LifeHelper();

    }

    void tearDown() {

    }

    void testCountLines() {

        int lines = lifeHelper.countLines(fName);

        assert lines == 8;

    }
}
