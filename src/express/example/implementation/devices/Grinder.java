package express.example.implementation.devices;

import express.api.exceptions.DeviceException;
import express.api.model.devices.Device;
import express.api.utils.validators.ArgumentsValidator;

/**
 * Created by Admin on 2015-02-23.
 */
public class Grinder implements Device {

    String name;

    public Grinder(String name)
    {
        ArgumentsValidator.nullArgument(name);
        ArgumentsValidator.emptyString(name);

        this.name = name;
    }

    @Override
    public void perform() throws DeviceException {
        /*
        Mieli składnik...
         */
    }

    @Override
    public String getName() {
        return name;
    }
}
