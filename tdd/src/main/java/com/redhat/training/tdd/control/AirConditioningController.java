package com.redhat.training.tdd.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.redhat.training.tdd.ac.AirConditioning;
import com.redhat.training.tdd.control.strategy.ControlStrategy;
import com.redhat.training.tdd.sensors.IndoorWeatherMeasured;
import com.redhat.training.tdd.sensors.OccupancyMeasured;
import com.redhat.training.tdd.sensors.SensorEvent;

import io.quarkus.vertx.ConsumeEvent;
import io.vertx.core.json.JsonObject;


/**
 * Acts on the AC system
 */
@ApplicationScoped
public class AirConditioningController {

    @Inject
    AirConditioning ac;

    @Inject
    ControlStrategy strategy;

    // Repository here
    ArrayList<SensorEvent> events = new ArrayList<SensorEvent>();

    @ConsumeEvent("weather")
    public void consume(IndoorWeatherMeasured event) {
        events.add(event);
        processEvents();
    }

    @ConsumeEvent("occupancy")
    public void consume(OccupancyMeasured event) {
        events.add(event);
        processEvents();
    }

    public ArrayList<SensorEvent> getEvents() {
        return events;
    }

    public String getAcStatus() {
        JsonObject status = new JsonObject();
        status.put("on", ac.isOn());
        status.put("temperature", ac.getTemperature());
        return status.encode();
    }

    private void processEvents() {
        strategy.apply(events, ac);
    }

}
