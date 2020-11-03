package com.redhat.simple.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AdvancedCalculatorTest {
    AdvancedCalculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new AdvancedCalculator();
    }

    @Test
    public void testSumIntegers() {
        assertEquals(1, calculator.sum(1, 0));
    }

    @Test
    public void testSubstractIntegers() {
        assertEquals(45, calculator.subs(50, 5));
    }

    @Test
    void testMultiplyIntegers() {
        assertEquals(50, calculator.multiply(5, 10));
    }

    @Test
    void testDivideIntegers() {
        assertEquals(11, calculator.divide(33, 3));
    }

    @Test
    void testCircumferenceWithIntRadius() {
        assertEquals(6.28, calculator.circumference(1));
    }

    @Test
    void testComparisonBetweenInts() {
        assertTrue(calculator.isGreaterThan(10, 5));
        assertFalse(calculator.isGreaterThan(5, 10));
    }
}
