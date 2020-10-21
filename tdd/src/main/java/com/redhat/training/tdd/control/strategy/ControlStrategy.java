package com.redhat.training.tdd.control.strategy;

import com.redhat.training.tdd.ac.AirConditioning;
import com.redhat.training.tdd.sensors.SensorEvent;

/**
 * Strategy to control the AC based on events
 */
public interface ControlStrategy {

    void apply(Iterable<SensorEvent> events, AirConditioning ac);

}
