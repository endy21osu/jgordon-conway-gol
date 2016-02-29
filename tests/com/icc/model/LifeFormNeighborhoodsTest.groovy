package com.icc.model

/**
 * Created by endocron on 2/29/2016.
 */
class LifeFormNeighborhoodsTest extends GroovyTestCase {

    private LifeFormNeighborhoods  lfn= new LifeFormNeighborhoods();

    void setUp() {
        super.setUp()

        lfn.createLifeAt(new Point(8,5))
        lfn.createLifeAt(new Point(0,1))
        lfn.createLifeAt(new Point(18,15))
        lfn.createLifeAt(new Point(2,11))

    }

    void tearDown() {

    }

    void testGetNeighborsHoods() {
        HashMap<Integer, LifeFormAddresses> temp = lfn.getNeighborsHoods();

        assert temp.size() == 4
        assert temp.get(8).isAliveAt(5)
    }

    void testIsAliveAt() {
        assert lfn.isAliveAt(new Point(0,1))
    }

    void testCreateLifeAt() {
        Point p = new Point(6,7)

        lfn.createLifeAt(p)
        assert lfn.isAliveAt(p)
    }

    void testGetHeight() {
        int h = lfn.getMaxHeight()

        assert h == 18
    }

    void testGetWidth() {
        int w = lfn.getMaxWidth()

        assert w == 15
    }
}
