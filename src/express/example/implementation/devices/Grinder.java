package express.example.implementation.devices;

import express.api.exceptions.DeviceException;
import express.api.model.devices.Device;
import express.api.utils.validators.ArgumentsValidator;

/**
 * Grinder representation.
 */
public class Grinder implements Device {

    private String name;

    /**
     * Create new grinder instance
     *
     * @param name name of device
     */
    public Grinder(String name) {
        ArgumentsValidator.nullArgument(name);
        ArgumentsValidator.emptyString(name);

        this.name = name;
    }

    /**
     * Order turning grinder on.
     *
     * @throws DeviceException
     */
    @Override
    public void perform() throws DeviceException {
        /*
        Mieli składnik...
         */
        System.out.println("Mielę");
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
