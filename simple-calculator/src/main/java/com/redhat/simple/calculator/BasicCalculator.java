package com.redhat.simple.calculator;

import java.util.Random;

public final class BasicCalculator extends Calculator {

    private final Random randomService = new Random();

    public int random() {
        return randomService.nextInt();
    }
}
