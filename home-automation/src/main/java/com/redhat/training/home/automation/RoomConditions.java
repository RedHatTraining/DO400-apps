package com.redhat.training.home.automation;

public class RoomConditions {
    public double daylightFactor;
    public boolean presenceDetected;

    RoomConditions(double daylightFactor, boolean presenceDetected) {
        this.daylightFactor = daylightFactor;
        this.presenceDetected = presenceDetected;
    }
}
