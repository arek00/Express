package example.implementation.devices;

import example.implementation.Exceptions.LackOfIngredientException;
import express.api.controller.device.Device;
import express.api.model.ingredient.Ingredient;

/**
 * Created by Admin on 2014-12-16.
 */
public class Grinder extends Device {

    private Ingredient ingredient;

    public Grinder(int deviceId)
    {
        super(deviceId);
    }

    public void setIngredientToGrind(Ingredient ingredient)
    {
        this.ingredient = ingredient;
    }

    @Override
    public void operate() throws LackOfIngredientException {

        if(ingredient == null)
        {
            throw new LackOfIngredientException("Didn't set ingredient");
        }
        else if(ingredient.getAmount() == 0)
        {
            throw new LackOfIngredientException("Grinder is empty");
        }

        System.out.println("Zmielono " + ingredient.getAmount() + " składnika " + ingredient.getName());
    }
}
