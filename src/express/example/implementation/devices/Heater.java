package express.example.implementation.devices;

import express.api.exceptions.DeviceException;
import express.api.model.devices.Device;
import express.api.utils.validators.ArgumentsValidator;
import express.api.utils.validators.NumbersValidator;

/**
 * Created by Admin on 2015-02-23.
 */
public class Heater implements Device {

    private double temperature;
    private String name;

    public Heater(String name) {
        ArgumentsValidator.nullArgument(name);
        ArgumentsValidator.emptyString(name);

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

    public double getTemperature() {
        return temperature;
    }

    @Override
    public void perform() throws DeviceException {
        /*
        Tutaj powinno wykonywać jakąś operację z API producenta z ustawioną temperaturą.
         */
    }

    @Override
    public String getName() {
        return name;
    }
}
