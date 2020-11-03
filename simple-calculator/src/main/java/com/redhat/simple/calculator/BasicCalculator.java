package com.redhat.simple.calculator;

import java.util.*;

public class BasicCalculator {
    public int divide(int dividend, int divisor) {
        if (divisor == 0)
            return Integer.MAX_VALUE;
        else
            return dividend / divisor;
    }

    public int subs(int minuend, int subtrahend) {
        return minuend-subtrahend;
    }

    public int sum(int addendA, int addendB) {
        return addendA+addendB;
    }

    public int multiply(int multiplicand, int multiplier) {
        return multiplicand*multiplier;
    }

    public int Random() {
        Random r = new Random();

        return r.nextInt();
    }
}