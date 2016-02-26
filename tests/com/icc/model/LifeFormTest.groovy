package com.icc.model

/**
 * Created by jgordon on 2/25/2016.
 */
class LifeFormTest extends GroovyTestCase {

    private final static Point p = new Point(3,4);
    private LifeForm lifeForm = new LifeForm(false, p);

    void testGetNeighbors() {

        ArrayList<Point> tmp = lifeForm.getNeighbors();

        assert tmp.length == 0;

    }

    void testSetNeighbors() {

        lifeForm.setNeighbors(new Point(4,3));

        assert lifeForm.getNeighbors().length == 1;

    }

    void testGetLocation() {
        Point p = lifeForm.getLocation();

        assert p.getColumn() == 4;
        assert p.getRow() == 3;
    }

    void testSetLocation() {
        lifeForm.setLocation(new Point(5,6));
        Point p = lifeForm.getLocation();

        assert p.getColumn() == 6;
        assert p.getRow() == 5;

    }

    void testIsAlive() {

        assert lifeForm.isAlive() == false;

    }

    void testCreate() {
        lifeForm.create();

        assert lifeForm.isAlive() == true;

    }

    void testKill() {
        lifeForm.kill();

        assert lifeForm.isAlive() == false;
    }
}
