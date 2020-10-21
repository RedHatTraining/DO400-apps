package com.redhat.training.tdd.ac;

public interface AirConditioning {

    public void switchOn();

    public void swithOff();

    public void setTemperature(float value);

    public float getTemperature();

    public boolean isOn();

}
