package com.redhat.simple.calculator;

import java.util.*;

public class Calculator {
    static final double pi = 3.14;

    public double circumference(int r) {
        return 2*pi*r;
    }

    public int divide(int n, int d) {
        if (d == 0)
            return Integer.MAX_VALUE;
        else
            return n / d;
    }

    public int random() {
        Random r = new Random();

        return r.nextInt();
    }

    public boolean is_greater_than(int a, int b) {
        if (a > b) {
            return true;
        } else {
            return false;
        }
    }
}