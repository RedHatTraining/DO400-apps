package com.redhat.training.tdd.ac;

import javax.enterprise.context.ApplicationScoped;

/**
 * Stub to simulate an air conditioning system in the console
 */
@ApplicationScoped
public class ConsoleAirConditioning implements AirConditioning {

    private boolean standby = true;
    private float temperature = 22;

    public void switchOn() {
        standby = false;
        System.out.println("AC: switched ON");
    }

    public void swithOff() {
        standby = true;
        System.out.println("AC: switched ON");
    }

    public void setTemperature(float value) {
        System.out.println("AC: temperature set to " +  value);
    }

    @Override
    public float getTemperature() {
        return temperature;
    }

    @Override
    public boolean isOn() {
        return !standby;
    }

}