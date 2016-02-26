package com.icc.service

import com.icc.model.LifeForm
import com.icc.model.Point


/**
 * Created by endocron on 2/25/2016.
 */
class LifeHelperTest extends groovy.util.GroovyTestCase {

    private final static String fName = "C:\\data\\popState1.txt";
    private LifeHelper lifeHelper;

//    private final static Point p = new Point(3,4);
//    private LifeForm lifeForm = new LifeForm(false, p);

    void setUp() {
        super.setUp();
        lifeHelper = new LifeHelper();

    }

    void tearDown() {

    }

    void testCountLines() {

        int lines = lifeHelper.countLines(fName);

        assert lines == 6;

    }
}
