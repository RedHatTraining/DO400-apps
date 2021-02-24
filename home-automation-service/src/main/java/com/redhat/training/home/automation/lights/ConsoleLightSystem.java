package com.redhat.training.home.automation.lights;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ConsoleLightSystem implements LightSystem {
    private boolean on = false;

    public void switchOn() {
        System.out.println("Lights ON!");
        on = true;
    }

    public void switchOff() {
        System.out.println("Lights OFF!");
        on = false;
    }

    public boolean isOn() {
        return on;
    }
}
