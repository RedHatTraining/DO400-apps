package com.redhat.training.tdd.rules;

import java.util.List;

import com.redhat.training.tdd.devices.Device;
import com.redhat.training.tdd.devices.HeatingControl;

public class StartHeatingRule extends Rule {

    private List<HeatingControl> devices;

    public forDevices(List<HeatingControl> devices) {
        this.devices = devices;
    }

    public run(WeatherEvent event) {

        if event.

    }
}
