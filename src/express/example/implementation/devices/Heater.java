package express.example.implementation.devices;

import express.api.exceptions.DeviceException;
import express.api.model.devices.Device;
import express.api.utils.validators.ArgumentsValidator;
import express.api.utils.validators.NumbersValidator;

/**
 * Heater representation.
 */
public class Heater implements Device {

    private double temperature;
    private String name;

    /**
     * Create new water heater instance
     *
     * @param name name of device
     */
    public Heater(String name) {
        ArgumentsValidator.notNull(name);
        ArgumentsValidator.stringNotEmpty(name);

        this.name = name;
        temperature = 0d;
    }

    /**
     * Set temperature to heat.
     *
     * @param temperature Temperature in celsius.
     */
    public void setTemperature(double temperature) {
        NumbersValidator.negativeNumber(temperature);

        this.temperature = temperature;
    }

    /**
     * Get temperature that has been ordered heat.
     *
     * @return temperature that liquid ingredient has to be warm.
     */
    public double getTemperature() {
        return temperature;
    }

    /**
     * Order heating liquid ingredient process.
     *
     * @throws DeviceException
     */
    @Override
    public void perform() throws DeviceException {
        /*
        Tutaj powinno wykonywać jakąś operację z API producenta z ustawioną temperaturą.
         */
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
