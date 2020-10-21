package com.redhat.training.tdd.devices.repository;

import javax.enterprise.context.ApplicationScoped;

import com.redhat.training.tdd.devices.Device;

@ApplicationScoped
public class InMemoryDeviceRepository implements DeviceRepository {

    @Override
    public Device find( String id ) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Device list() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void add(Device device) {
        // TODO Auto-generated method stub

    }


}
