package express.api.controller.device;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Admin on 2014-12-14.
 */
public class Devices {

    private Map<Integer, Device> devices = new HashMap<Integer, Device>();

    public Devices()
    {
    }

    public Device getDeviceById(int deviceId)
    {
        return devices.get(deviceId);
    }

    public Iterator<Device> getAllDevices()
    {
        return devices.values().iterator();
    }

    public void addDevice(Device device)
    {
        Integer deviceId = device.getDeviceId();
        devices.put(deviceId,device);
    }


}
