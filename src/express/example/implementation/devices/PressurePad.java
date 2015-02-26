package express.example.implementation.devices;

import express.api.exceptions.DeviceException;
import express.api.model.devices.Device;
import express.api.utils.validators.ArgumentsValidator;
import express.example.implementation.exceptions.PadNotPressedException;

/**
 * Pressure Pad representation.
 */
public class PressurePad implements Device {

    private String name;
    private boolean isPressed;

    /**
     * Create new instance of pressure pad device
     *
     * @param name Name of device
     */
    public PressurePad(String name) {
        ArgumentsValidator.notNull(name);
        ArgumentsValidator.stringNotEmpty(name);

        this.name = name;
        isPressed = false;
    }

    /**
     * Calls when pad has been pressed.
     */
    public void pressed() {
        isPressed = true;
    }

    /**
     * Calls when pad has been released.
     */
    public void released() {
        isPressed = false;
    }

    /**
     * @return State of pad.
     */
    public boolean isPressed() {
        return isPressed;
    }

    /**
     * Perform operation of Pressure pad. Should stop dispense or stop process of brewing when is not
     * pressed before dispense process
     *
     * @throws DeviceException
     */
    @Override
    public void perform() throws DeviceException {
        if (!isPressed) {
            throw new PadNotPressedException("Cup is not on the place.");
        }
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
