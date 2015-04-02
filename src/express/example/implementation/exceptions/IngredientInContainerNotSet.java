package express.example.implementation.exceptions;

import express.api.exceptions.DeviceException;

/**
 * Exception that informs about problem with
 */
public class IngredientInContainerNotSet extends DeviceException {

    public IngredientInContainerNotSet(String message) {
        super(message);
    }
}
