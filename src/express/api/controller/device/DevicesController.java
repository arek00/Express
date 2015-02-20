package express.api.controller.device;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by Admin on 2014-12-14.
 */
public class DevicesController {

    private static DevicesController instance = new DevicesController();
    private Devices devices;

    private DevicesController () {
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
     * @param deviceId
     * @return Device with ID deviceId
     */
    public Device getDeviceById(int deviceId) {
        return devices.getDeviceById(deviceId);
    }

    public Collection<Device> getAllDevices() {
        return devices.getAllDevices();
    }

    public void addDevice(Device device) {
        devices.addDevice(device);
    }


}
