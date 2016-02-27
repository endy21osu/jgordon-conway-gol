package com.icc.model

/**
 * Created by jgordon on 2/27/2016.
 */
class LifeFormTest extends GroovyTestCase {

    private final static Point p = new Point(3,4)
    private LifeForm lifeForm = new LifeForm(false, p)
    private LifeForm deadForm = new LifeForm()


    void tearDown() {

    }

    void testGetLocation() {

        Point p = lifeForm.getLocation()

        assert p.getColumn() == 4
        assert p.getRow() == 3
    }

    void testSetLocation() {
        lifeForm.setLocation(new Point(5,6))
        Point p = lifeForm.getLocation()
        assert p.getColumn() == 6
        assert p.getRow() == 5
    }

    void testIsAlive() {
        assert !lifeForm.isAlive()
        assert !deadForm.isAlive()
    }


    void testSetNeighbor() {

        lifeForm.setNeighbor(new Point(4,3))

        assert lifeForm.getNumberOfneighbors() == 1
    }

    void testGetNumberOfneighbors() {
        lifeForm.setNeighbor(new Point(6,3))

        assert lifeForm.getNumberOfneighbors() == 1
        assert deadForm.getNumberOfneighbors() == 0
    }


    void testCreate() {
        lifeForm.create()
        assert lifeForm.isAlive()
    }


    void testKill() {
        lifeForm.create()
        lifeForm.kill()

        assert !lifeForm.isAlive()
    }
}
