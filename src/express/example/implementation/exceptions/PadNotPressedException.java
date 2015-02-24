package express.example.implementation.exceptions;

import express.api.exceptions.DeviceException;

/**
 * Created by Admin on 2015-02-23.
 */
public class PadNotPressedException extends DeviceException {

    public PadNotPressedException(String message) {
        super(message);
    }
}
