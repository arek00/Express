package tests.express.api.model.devices;

import express.api.exceptions.DeviceException;
import express.api.model.devices.Device;

/**
 * Mock device implementation class
 */
public class MockDevice implements Device {

    private String name;

    public MockDevice(String name) {
        this.name = name;
    }

    @Override
    public void perform() throws DeviceException {

    }

    @Override
    public String getName() {
        return name;
    }
}
