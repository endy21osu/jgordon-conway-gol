package com.icc.model

/**
 * Created by jgordon on 2/26/2016.
 */
class NeighborsTest extends GroovyTestCase {

    private Neighbors  neighbors = new Neighbors()

    void setUp() {
        super.setUp()
        neighbors.addNeighbor(new Point(3,4))
        neighbors.addNeighbor(new Point(7,4))
        neighbors.addNeighbor(new Point(20,12))
        neighbors.addNeighbor(new Point(6,19))

    }

    void testGetNeighborLocations() {
        List<Point> listOfPoints = neighbors.getNeighborLocations()

        int size = listOfPoints.size()

        assert size == 4
    }

    void testAddNeighbor() {
        Point myN = new Point(6,6)
        neighbors.addNeighbor(myN)

        int size = neighbors.getNumberOfNeighbors()

        assert size == 5
        assert neighbors.getNeighborLocations().contains(myN)

    }

    void testClearNeighbors() {

        neighbors.clearNeighbors()

        assert neighbors.getNumberOfNeighbors() == 0

    }

    void testGetNumberOfNeighbors() {

        int size =  neighbors.getNumberOfNeighbors()

        assert size == 4
    }
}
