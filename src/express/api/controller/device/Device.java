package express.api.controller.device;

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

    public abstract void operate();
}
