package example.impl.Devices;

import express.api.model.devices.Device;
import express.api.exceptions.DeviceException;
import express.api.model.ingredients.Ingredient;

/**
 * Created by Admin on 2015-01-13.
 */
public class Grinder implements Device {

    private int id;
    private Ingredient ingredient;


    public Grinder(int id) {
        this.id = id;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    @Override
    public void perform() throws DeviceException {

        System.out.println("Zmielono " + ingredient.getAmount() + " " + ingredient.getName());
    }

    @Override
    public int getDeviceId() {
        return id;
    }
}
