package tests.express.api.controller.device;

import express.api.controller.device.Device;
import express.api.controller.device.Devices;
import express.api.exceptions.DeviceException;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class DevicesTest {

    private static Devices devices = new Devices();
    private static Device testDevice;

    @BeforeClass
    public static void initialize()
    {
        testDevice = new Device() {
            @Override
            public void perform() throws DeviceException {

            }

            @Override
            public String getName() {
                return "Device";
            }
        };

        devices.addDevice(testDevice);
    }

    @Test
    public void testGetDeviceByName() throws Exception {
        Device retrievedDevice = devices.getDeviceByName("Device");

        assertTrue(retrievedDevice == testDevice);
    }

    @Test
    public void testGetAllDevices() throws Exception {

    }

    @Test
    public void testAddDevice() throws Exception {

    }
}