package express.example.implementation.devices;

import express.api.exceptions.DeviceException;
import express.api.model.devices.Device;
import express.api.utils.validators.ArgumentsValidator;
import express.api.utils.validators.NumbersValidator;

/**
 * Created by Admin on 2015-02-23.
 */
public class Pump implements Device {

    private String name;
    private double pressure;

    public Pump(String name, double pressure) {
        ArgumentsValidator.nullArgument(name);
        ArgumentsValidator.emptyString(name);
        NumbersValidator.negativeNumber(pressure);

        this.name = name;
        this.pressure = pressure;
    }

    public Pump(String name) {
        this(name, 0d);
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    @Override
    public void perform() throws DeviceException {
        /*
        Pompuje wodę z danym ciśnieniem.
         */
    }

    @Override
    public String getName() {
        return name;
    }
}
