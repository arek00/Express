package express.api.model.devices.sequences;

import express.api.exceptions.DeviceException;

/**
 * Interface that describe strategy of brewing process.
 */
public interface BrewSequence {
    /**
     * Performing operation of brewing.
     *
     * @throws DeviceException
     */
    public void perform() throws DeviceException;
}
