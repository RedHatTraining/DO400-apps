package com.redhat.training.home.automation.lights;

public interface LightSystem {
    void switchOff();

    void switchOn();

    boolean isOn();
}
