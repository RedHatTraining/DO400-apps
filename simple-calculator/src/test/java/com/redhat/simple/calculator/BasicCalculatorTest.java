package com.redhat.simple.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicCalculatorTest {
    BasicCalculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new BasicCalculator();
    }

    @Test
    public void testSumIntegers() {
        assertEquals(2, calculator.sum(1, 1));
    }

    @Test
    public void testSubstractIntegers() {
        assertEquals(5, calculator.subs(10, 5));
    }

    @Test
    void testMultiplyIntegers() {
        assertEquals(25, calculator.multiply(5, 5));
    }

    @Test
    void testDivideIntegers() {
        assertEquals(1, calculator.divide(4, 3));
    }
}
