package express.example.implementation.devices;

import express.api.exceptions.DeviceException;
import express.api.model.devices.Device;

/**
 * Class representation of dispenser device in express.
 */
public class Dispenser implements Device {

    private String name;

    /**
     * Create new dispenser instance
     *
     * @param name name of device
     */
    public Dispenser(String name) {
        this.name = name;
    }


    /**
     * Perform operation ths implements dispenser functionality
     *
     * @throws DeviceException
     */
    @Override
    public void perform() throws DeviceException {
        /*
         Funkcjonalność podajnika
         */
        System.out.println("Nalewam");
    }

    /**
     * Get name of this device.
     *
     * @return Name of Device
     */
    @Override
    public String getName() {
        return name;
    }
}
