package com.redhat.training.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.inject.Inject;

import com.redhat.training.tdd.devices.HeatingControl;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;



@QuarkusTest
public class HomeTest {

    @Inject
    Home home;

    @Test
    public void testX() {
        HeatingControl heating = new HeatingControl();

        home.addDevice(heating);
        home.consume("asdf");
    }

}