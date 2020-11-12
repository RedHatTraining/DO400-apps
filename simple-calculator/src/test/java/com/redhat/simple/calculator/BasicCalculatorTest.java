package com.redhat.simple.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BasicCalculatorTest {
    BasicCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new BasicCalculator();
    }

    @Test
    void testSumIntegers() {
        assertEquals(2, calculator.sum(1, 1));
    }

    @Test
    void testSubstractIntegers() {
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

    @Test
    void testDivideByZero() {
        assertEquals(Integer.MAX_VALUE, calculator.divide(1, 0));
    }
}
