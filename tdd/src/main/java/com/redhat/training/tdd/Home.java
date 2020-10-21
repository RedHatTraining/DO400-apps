package com.redhat.training.tdd;

import io.quarkus.vertx.ConsumeEvent;

import java.util.ArrayList;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.redhat.training.tdd.devices.Device;
import com.redhat.training.tdd.devices.repository.DeviceRepository;




@ApplicationScoped
class Home {

    @Inject
    DeviceRepository deviceRepository;

    public void addDevice(Device device) {
        deviceRepository.add(device);
    }

    @ConsumeEvent
    public String consume(String name) {
        return name.toUpperCase();
    }

}