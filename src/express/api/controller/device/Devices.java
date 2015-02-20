package express.api.controller.device;

import java.util.*;

/**
 * Created by Admin on 2014-12-14.
 */
public class Devices {

    private Map<Integer, Device> devicesCollection;

    public Devices() {
        devicesCollection = new HashMap<Integer, Device>();
    }

    public Device getDeviceById(int deviceId) {
        return devicesCollection.get(deviceId);
    }

    public Collection<Device> getAllDevices() {
        return devicesCollection.values();
    }

    public void addDevice(Device device) {
        devicesCollection.put(device.getDeviceId(),device);
    }


}
