package express.api.controller.device;

import express.api.exceptions.DeviceException;

/**
 * Created by Admin on 2014-12-14.
 */

public interface Device{
    public void perform() throws DeviceException;
    public int getDeviceId();
}