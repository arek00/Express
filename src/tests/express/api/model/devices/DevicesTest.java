package tests.express.api.model.devices;

import express.api.model.devices.Device;
import express.api.model.devices.Devices;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class DevicesTest {

    private static Devices devices;
    private static Device device1, device2, device3;

    @BeforeClass
    public static void init() {
        devices = Devices.getInstance();
        device1 = new MockDevice("Grzałka");
        device2 = new MockDevice("Pompa");
        device3 = new MockDevice("Młynek");

        devices.addDevice(device1);
        devices.addDevice(device2);
        devices.addDevice(device3);
    }

    @Before
    public void restore() {
        if (!devices.containsDevice(device1.getName())) {
            devices.addDevice(device1);
        }
        if (!devices.containsDevice(device2.getName())) {
            devices.addDevice(device2);
        }
        if (!devices.containsDevice(device3.getName())) {
            devices.addDevice(device3);
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetDevice() {

        Device device = devices.getDevice("Młynek");
        assertFalse(device == null);

        device = devices.getDevice("Włącznik");
    }

    @Test
    public void testGetDevices() {

        int iteratorCount = 0;
        Iterator<Device> deviceIterator = devices.getDevices();

        while (deviceIterator.hasNext()) {
            deviceIterator.next();
            iteratorCount++;
        }

        System.out.println(Integer.toString(iteratorCount));
        assertTrue(iteratorCount == 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddDeviceNullArgument() {
        devices.addDevice(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddDeviceIllegalName() {
        devices.addDevice(new MockDevice("Młynek"));
    }


    @Test
    public void testAddRemoveDevice() {
        devices.addDevice(new MockDevice("Miarka Poziomu Wody"));
        assertTrue(devices.getDevicesNumber() == 4);

        devices.removeDevice("Miarka Poziomu Wody");
        assertTrue(devices.getDevicesNumber() == 3);
    }

}