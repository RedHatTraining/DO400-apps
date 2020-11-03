package com.redhat.simple.calculator;

public final class AdvancedCalculator {
    static final double PI = 3.14;

    public int divide(final int n, final int d) {
        if (d == 0) {
            return Integer.MAX_VALUE;
        } else {
            return n / d;
        }
    }

    public int subs(final int a, final int b) {
        return a - b;
    }

    public int sum(final int a, final int b) {
        return a + b;
    }

    public int multiply(final int a, final int b) {
        return a * b;
    }

    public double circumference(final int r) {
        return 2 * PI * r;
    }

    public boolean isGreaterThan(final int a, final int b) {
        return a > b;
    }
}
