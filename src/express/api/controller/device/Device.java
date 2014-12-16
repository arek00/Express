package express.api.controller.device;

import example.implementation.Exceptions.DeviceException;
import example.implementation.Exceptions.LackOfIngredientException;

/**
 * Created by Admin on 2014-12-14.
 */
public abstract class Device {

    private int deviceId;

    public Device(int deviceId)
    {
        this.deviceId = deviceId;
    }

    public int getDeviceId()
    {
        return this.deviceId;
    }

    public abstract void operate() throws DeviceException;
}
