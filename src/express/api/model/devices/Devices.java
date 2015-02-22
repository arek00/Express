package express.api.model.devices;

import express.api.utils.validators.ArgumentsValidator;

import java.util.*;

/**
 * Set that stores and manages of devices in express.
 * Devices like containers should be stored in Containers set.
 */
public class Devices {

    private static Devices instance = new Devices();

    /**
     * Get an instance of a Devices set. Singleton.
     *
     * @return
     */
    public static Devices getInstance() {
        return instance;
    }

    private Devices() {
    }

    private Map<String, Device> devices = new HashMap<String, Device>();

    /**
     * Get device by its name.
     *
     * @param deviceName Name of device
     * @return Reference to device.
     */
    public Device getDevice(String deviceName) {
        ArgumentsValidator.nullArgument(deviceName);
        ArgumentsValidator.emptyString(deviceName);

        return devices.get(deviceName);
    }

    /**
     * Get iterator to all devices.
     *
     * @return Iterator to all devices.
     */
    public Iterator<Device> getDevices() {

        Collection<Device> devicesCollection = devices.values();
        return devicesCollection.iterator();
    }

    /**
     * Add device to set. Device name must be unique.
     *
     * @param device instance of device.
     */
    public void addDevice(Device device) {
        ArgumentsValidator.nullArgument(device);
        checkUniqueName(device.getName());

        devices.put(device.getName(), device);
    }


    private void checkUniqueName(String name) {
        if (devices.get(name) != null) {
            throw new IllegalArgumentException("There is already device with name" + name);
        }
    }
}
