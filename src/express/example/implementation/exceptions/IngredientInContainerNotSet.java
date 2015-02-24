package express.example.implementation.exceptions;

import express.api.exceptions.DeviceException;

/**
 * Created by Admin on 2015-02-23.
 */
public class IngredientInContainerNotSet extends DeviceException {

    public IngredientInContainerNotSet(String message) {
        super(message);
    }
}
