package com.redhat.training.tdd.sensors;

public class IndoorWeatherMeasured extends SensorEvent {

    public float temperature;
    public float humidity;

    public IndoorWeatherMeasured(float temperature, float humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public String toString() {
        return "TEMP:" + temperature + ", HUMID: " + humidity;
    }

}
