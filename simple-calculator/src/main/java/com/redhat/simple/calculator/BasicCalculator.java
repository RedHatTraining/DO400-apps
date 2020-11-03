package com.redhat.simple.calculator;

import java.util.*;

public class BasicCalculator {
    public int divide(int n, int d) {
        if (d == 0)
            return Integer.MAX_VALUE;
        else
            return n / d;
    }

    public int subs(int a, int b) {
        return a-b;
    }

    public int sum(int a, int b) {
        return a+b;
    }

    public int multiply(int a, int b) {
        return a*b;
    }

    public int Random() {
        Random r = new Random();

        return r.nextInt();
    }
}