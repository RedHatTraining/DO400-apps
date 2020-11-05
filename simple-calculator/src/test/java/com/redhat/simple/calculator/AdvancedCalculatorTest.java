package com.redhat.simple.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdvancedCalculatorTest {
    AdvancedCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new AdvancedCalculator();
    }

    @Test
    void testSumIntegers() {
        assertEquals(1, calculator.sum(1, 0));
    }

    @Test
    void testSubstractIntegers() {
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

    @Test
    void noDiscountOnVeryLowPurchase() {
        assertEquals(0, calculator.discount(9, 100, true));
    }

    @Test
    void noDiscountOnZeroYearsAsCustomer() {
        assertEquals(0, calculator.discount(999, 0, true));
    }

    @Test
    void lowDiscountOnLowPurchaseAndBusiness() {
        assertEquals(AdvancedCalculator.LOW_DISCOUNT_AMOUNT, calculator.discount(50, 1, true));
    }

    @Test
    void vipDiscountOnHighPurchaseAndBusiness() {
        assertEquals(AdvancedCalculator.VIP_DISCOUNT_AMOUNT, calculator.discount(5000, 1, true));
    }

    @Test
    void midDiscountOnLowPurchaseNoBusinessAndGoldCustomer() {
        assertEquals(AdvancedCalculator.MID_DISCOUNT_AMOUNT, calculator.discount(50, 4, false));
    }

    @Test
    void lowDiscountOnLowPurchaseNoBusinessAndNoGoldCustomer() {
        assertEquals(AdvancedCalculator.LOW_DISCOUNT_AMOUNT, calculator.discount(50, 1, false));
    }

    @Test
    void lowDiscountOnHighPurchaseNoBusinessAndBronzeCustomer() {
        assertEquals(AdvancedCalculator.LOW_DISCOUNT_AMOUNT, calculator.discount(5000, 1, false));
    }

    @Test
    void midDiscountOnHighPurchaseNoBusinessAndSilverCustomer() {
        assertEquals(AdvancedCalculator.MID_DISCOUNT_AMOUNT, calculator.discount(5000, 2, false));
    }

    @Test
    void highDiscountOnHighPurchaseNoBusinessAndGoldCustomer() {
        assertEquals(AdvancedCalculator.HIGH_DISCOUNT_AMOUNT, calculator.discount(5000, 3, false));
    }

    @Test
    void vipDiscountOnHighPurchaseNoBusiness() {
        assertEquals(AdvancedCalculator.VIP_DISCOUNT_AMOUNT, calculator.discount(5000, 4, false));
    }

    @Test
    void noDiscountOnPurchasesBetweenLowAndHighAmounts() {
        assertEquals(0, calculator.discount(200, 4, false));
    }
}
