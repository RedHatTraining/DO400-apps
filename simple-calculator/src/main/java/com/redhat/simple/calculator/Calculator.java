package com.redhat.simple.calculator;

public abstract class Calculator {
    public final int divide(final int dividend, final int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        } else {
            return dividend / divisor;
        }
    }

    public final int subs(final int minuend, final int subtrahend) {
        return minuend - subtrahend;
    }

    public final int sum(final int addendA, final int addendB) {
        return addendA + addendB;
    }

    public final int multiply(final int multiplicand, final int multiplier) {
        return multiplicand * multiplier;
    }
}
