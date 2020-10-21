package com.redhat.training.tdd.devices.repository;

import com.redhat.training.tdd.devices.Device;

public interface DeviceRepository {
    Device find(String id);

    Device list();

    void add(Device device);
}
