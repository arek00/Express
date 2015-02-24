package express.example.implementation.devices;

import express.api.exceptions.DeviceException;
import express.api.model.devices.Device;

/**
 * Created by Admin on 2015-02-24.
 */
public class Dispenser implements Device {

    String name;

    public Dispenser(String name) {
        this.name = name;
    }

    @Override
    public void perform() throws DeviceException {
        /*
         Funkcjonalność podajnika
         */
    }

    @Override
    public String getName() {
        return name;
    }
}
