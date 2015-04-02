package express.api.exceptions;

/**
 * Base exception for signalizing problems with devices.
 * DeviceException is base exception and could throws
 * every issue of devices.
 */
public class DeviceException extends Exception {

    /**
     * Constructs exception with given message.
     *
     * @param message
     */
    public DeviceException(String message) {
        super(message);
    }

}
