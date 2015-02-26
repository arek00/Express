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
        ArgumentsValidator.notNull(deviceName);
        ArgumentsValidator.stringNotEmpty(deviceName);

        Device device = devices.get(deviceName);
        ArgumentsValidator.returnNotNull(device);

        return device;
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
        ArgumentsValidator.notNull(device);
        checkUniqueName(device.getName());

        devices.put(device.getName(), device);
    }

    /**
     * Get amount of registered devices
     *
     * @return Number of currently stored devices instances.
     */
    public int getDevicesNumber() {
        return devices.size();
    }

    /**
     * Check if set contains device with given name.
     *
     * @param deviceName name of device.
     * @return true if contains device with given name, false otherwise.
     */
    public boolean containsDevice(String deviceName) {
        return (devices.get(deviceName) != null);
    }

    /**
     * Remove device from express by its name.
     * @param deviceName name of device to remove.
     */
    public void removeDevice(String deviceName) {
        ArgumentsValidator.notNull(deviceName);
        ArgumentsValidator.stringNotEmpty(deviceName);

        devices.remove(deviceName);
    }


    private void checkUniqueName(String name) {
        if (devices.get(name) != null) {
            throw new IllegalArgumentException("There is already device with name" + name);
        }
    }
}
