package express.example.implementation.devices;

import express.api.exceptions.DeviceException;
import express.api.model.devices.Device;
import express.api.utils.validators.ArgumentsValidator;
import express.api.utils.validators.NumbersValidator;

/**
 * Pump representation
 */
public class Pump implements Device {

    private String name;
    private double pressure;

    /**
     * Create new instance of water pump device
     *
     * @param name     Name of device
     * @param pressure Set pressure that should be pumped, in bars
     */
    public Pump(String name, double pressure) {
        ArgumentsValidator.nullArgument(name);
        ArgumentsValidator.emptyString(name);
        NumbersValidator.negativeNumber(pressure);

        this.name = name;
        this.pressure = pressure;
    }

    /**
     * Create new instance of water pump device
     *
     * @param name Name of device
     */
    public Pump(String name) {
        this(name, 0d);
    }

    /**
     * Set pressure of punping
     *
     * @param pressure pressure that should be use to pump in bars
     */
    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    /**
     * Perform operation of pumping liquid ingredient.
     *
     * @throws DeviceException
     */
    @Override
    public void perform() throws DeviceException {
        /*
        Pompuje wodę z danym ciśnieniem.
         */
        System.out.println("Pompuję");
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
