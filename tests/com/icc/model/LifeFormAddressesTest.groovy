package com.icc.model

/**
 * Created by endocron on 2/29/2016.
 */
class LifeFormAddressesTest extends GroovyTestCase {

    private LifeFormAddresses lfa = new LifeFormAddresses()

    void setUp() {
        super.setUp()

        lfa.create(9)
        lfa.create(7)
        lfa.create(4)
    }

    void tearDown() {

    }

    void testGetLifeForms() {
        TreeSet<Integer> temp = lfa.getLifeForms()

        assert temp.size() == 3
    }

    void testIsAliveAt() {
        assert lfa.isAliveAt(9)
        assert !lfa.isAliveAt(10)
    }

    void testCreate() {
        lfa.create(10)

        assert lfa.isAliveAt(10)
    }

    void testKill() {
        lfa.kill(9)
        assert !lfa.isAliveAt(9);
    }

    void testGetWidth() {
        int w = lfa.getWidth();
        assert w == 9;
    }
}
