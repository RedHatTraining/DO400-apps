package com.redhat.simple.calculator;

import java.util.*;

public class BasicCalculator {
    public int divide(final int dividend, final int divisor) {
        if (divisor == 0)
            return Integer.MAX_VALUE;
        else
            return dividend / divisor;
    }

    public int subs(final int minuend, final int subtrahend) {
        return minuend-subtrahend;
    }

    public int sum(final int addendA, final int addendB) {
        return addendA+addendB;
    }

    public int multiply(final int multiplicand, final int multiplier) {
        return multiplicand*multiplier;
    }

    public int Random() {
        Random r = new Random();

        return r.nextInt();
    }
}