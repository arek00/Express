package express.api.controller.device;

import java.util.Collection;
import java.util.Iterator;

/**
 * Facade on Devices set. May be not necessary.
 */
public class DevicesController {

    private static DevicesController instance = new DevicesController();
    private Devices devices;

    private DevicesController() {
        devices = new Devices();
    }

    /**
     * @return instance of DevicesController
     */
    public static DevicesController getInstance() {
        return instance;
    }

    /**
     * Returns device by its ID.
     *
     * @param deviceName
     * @return Device with ID deviceId
     */
    public Device getDeviceByName(String deviceName) {
        return devices.getDeviceByName(deviceName);
    }

    public Iterator<Device> getDevices() {
        return devices.getDevices();
    }

    public void addDevice(Device device) {
        devices.addDevice(device);
    }
}
