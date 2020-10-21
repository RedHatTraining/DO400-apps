package com.redhat.training.tdd.control.strategy;

import javax.enterprise.context.ApplicationScoped;

import com.redhat.training.tdd.ac.AirConditioning;
import com.redhat.training.tdd.sensors.SensorEvent;


@ApplicationScoped
public class AlwaysOffStrategy implements ControlStrategy {

    @Override
    public void apply( Iterable<SensorEvent> events, AirConditioning ac ) {
        ac.swithOff();
    }

}
