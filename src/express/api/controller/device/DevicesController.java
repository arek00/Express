package express.api.controller.device;

import java.util.Iterator;

/**
 * Created by Admin on 2014-12-14.
 */
public class DevicesController {

    private static DevicesController instance = new DevicesController();

    private DevicesController(){

    }

    public static DevicesController getInstance()
    {
        return instance;
    }

    private Devices devices;

    public DevicesController(Devices devices)
    {
        this.devices = devices;
    }

    public Device getDeviceById(int deviceId)
    {
        return devices.getDeviceById(deviceId);
    }

    public Iterator<Device> getAllDevices()
    {
        return devices.getAllDevices();
    }

    public void addDevice(Device device)
    {
        devices.addDevice(device);
    }


}
