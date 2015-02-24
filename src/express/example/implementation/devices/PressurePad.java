package express.example.implementation.devices;

import express.api.exceptions.DeviceException;
import express.api.model.devices.Device;
import express.api.utils.validators.ArgumentsValidator;
import express.example.implementation.exceptions.PadNotPressedException;

/**
 * Created by Admin on 2015-02-23.
 */
public class PressurePad implements Device {

    private String name;
    private boolean isPressed;

    public PressurePad(String name) {
        ArgumentsValidator.nullArgument(name);
        ArgumentsValidator.emptyString(name);

        this.name = name;
        isPressed = false;
    }

    public void padPressed() {
        isPressed = true;
    }

    public void padReleased() {
        isPressed = false;
    }

    @Override
    public void perform() throws DeviceException {
        if (!isPressed) {
            throw new PadNotPressedException("Cup is not on the place.");
        }
    }

    @Override
    public String getName() {
        return name;
    }
}
