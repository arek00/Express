package example.impl.Devices;

import express.api.controller.device.Device;
import express.api.exceptions.DeviceException;
import express.api.model.ingredient.Ingredient;

/**
 * Created by Admin on 2015-01-13.
 */
public class Container implements Device {

    private int id;
    private Ingredient ingredient;
    private int containerState;

    public Container(Ingredient ingredient, int state, int id) {
        this.ingredient = ingredient;
        this.containerState = state;
        this.id = id;
    }

    public int getContainerState() {
        return this.containerState;
    }

    private void getIngredientPortionFromContainer() throws DeviceException {
        if (containerState-ingredient.getAmount() < 0) {
            throw new DeviceException("Not enough ingredient in container " + id);
        }
        containerState -= ingredient.getAmount();
    }

    @Override
    public void perform() throws DeviceException {
        getIngredientPortionFromContainer();
        System.out.println("Pobrano " + ingredient.getAmount() + " składnika ze zbiornika " + id);
    }

    @Override
    public int getDeviceId() {
        return this.id;
    }
}
