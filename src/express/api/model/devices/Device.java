package express.api.model.devices;

import express.api.exceptions.DeviceException;

/**
 * Interface that describes any of device in express.
 */

public interface Device {
    /**
     * Perform operation assigned to component of express - device.
     *
     * @throws DeviceException
     */
    public void perform() throws DeviceException;

    /**
     * Get name of this device
     *
     * @return device's name.
     */
    public String getName();
}