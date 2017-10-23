package de.packagingcalculator.model;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    Calculator calculator;

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

    private void testPrice(double expectedPrice, double d1, double d2, double d3, int weight) {
        assertEquals(expectedPrice, calculator.calcShippingCostsMMg(d1, d2, d3, weight), 0.0);
    }
}
