package com.icc.model

/**
 * Created by jgordon on 2/25/2016.
 */
class PointTest extends GroovyTestCase {

    private Point p = new Point(3,4)

    void testGetColumn() {
        int tmp = p.getColumn()
        assert tmp == 4

        tmp = p.getRow()
        assert tmp == 3

    }

    void testSetColumn() {
        p.setColumn(8)
        int tmp = p.getColumn()
        assert tmp == 8

        tmp = p.getRow()
        assert tmp == 3
    }

    void testGetRow() {
        int tmp = p.getRow()
        assert tmp == 3

        tmp = p.getColumn()
        assert tmp == 4
    }

    void testSetRow() {
        p.setRow(5)
        int tmp = p.getRow()
        assert tmp == 5


        tmp = p.getColumn()
        assert tmp == 4

    }
}
