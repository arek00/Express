package express.api.controller.brew;

import express.api.exceptions.DeviceException;

/**
 * Created by Admin on 2014-12-14.
 */
public interface BrewSequence {
    public void perform() throws DeviceException;
}
