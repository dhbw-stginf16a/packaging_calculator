package de.packagingcalculator.model;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author andreas, dorian, erik, jan-robin
 */
public class CalculatorTest {

    private ShippingCostCalculatable calculator;

    @Before
    public void beforeTest() {
        calculator = new Calculator();
    }

    @After
    public void afterTest() {
        calculator = null;
    }

    @Test
    public void smallPackageTest() {
        testPrice(4.99, 500, 250, 100, 1000);
    }

    @Test
    public void medPackageTest() {
        testPrice(5.99, 700, 250, 100, 1000);
        testPrice(5.99, 500, 250, 100, 4000);
        testPrice(5.99, 700, 250, 100, 4000);
    }

    @Test
    public void medBigPackageTest() {
        testPrice(8.49, 700, 250, 100, 6000);
        testPrice(8.49, 500, 250, 100, 6000);
    }

    @Test
    public void bigPackageTest() {
        testPrice(16.49, 700, 250, 100, 11000);
        testPrice(16.49, 500, 250, 100, 11000);
    }

    private void testPrice(double expectedPrice, int d1, int d2, int d3, int weight) {
        assertEquals(expectedPrice, calculator.calcShippingCosts(createPacketList(d1, d2, d3, weight)), 0.0);
    }

    private List<Packet> createPacketList(int d1, int d2, int d3, int weight) {
        ArrayList<Packet> list = new ArrayList<>(1);
        Packet p = new Packet();
        p.setHeight(d1);
        p.setWidth(d2);
        p.setLength(d3);
        p.setWeight(weight);
        list.add(p);

        return list;
    }
}
