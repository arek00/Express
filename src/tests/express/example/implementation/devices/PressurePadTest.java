package tests.express.example.implementation.devices;

import express.api.exceptions.DeviceException;
import express.example.implementation.devices.PressurePad;
import express.example.implementation.exceptions.PadNotPressedException;
import org.junit.Test;

import static org.junit.Assert.*;

public class PressurePadTest {

    private PressurePad pad = new PressurePad("Pad");

    @Test
    public void testPadPressed() {
        pad.released();
        assertFalse(pad.isPressed());

        pad.pressed();
        assertTrue(pad.isPressed());
    }

    @Test(expected = PadNotPressedException.class)
    public void testPadReleased() throws DeviceException {
        pad.released();
        pad.perform();
    }

    @Test
    public void testPerform() throws Exception {

    }
}