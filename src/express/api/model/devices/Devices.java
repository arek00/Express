package express.api.model.devices;

import java.util.*;

/**
 * Created by Admin on 2014-12-14.
 */
public class Devices {

    private static Devices instance = new Devices();

    public static Devices getInstance() {
        return instance;
    }

    private Devices() {
    }

    private Map<String, Device> devices = new HashMap<String, Device>();

    public Device getDeviceByName(String deviceName) {
        return devices.get(deviceName);
    }

    public Iterator<Device> getDevices() {

        Collection<Device> devicesCollection = devices.values();
        return devicesCollection.iterator();
    }

    public void addDevice(Device device) {
        devices.put(device.getName(), device);
    }
}
