package example.implementation.devices;

import example.implementation.Exceptions.DeviceException;
import express.api.controller.device.Device;
import express.api.model.ingredient.Ingredient;
import express.api.model.recipe.Recipe;

import java.util.Iterator;

/**
 * Created by Admin on 2014-12-16.
 */
public class Dispenser extends Device {

    private Recipe recipe;

    public Dispenser(int deviceId){
        super(deviceId);
    }

    public void setRecipe()
    {

    }

    @Override
    public void operate() throws DeviceException {
        System.out.println("Nalano napoju");
        System.out.println("Składniki:");

        displayIngredients(recipe.getIngredients());

        System.out.println("Dodatki:");
        displayIngredients(recipe.getAdditives());
    }

    public void displayIngredients(Iterator<Ingredient> iterator)
    {
        while(iterator.hasNext())
        {
            Ingredient ingredient = iterator.next();
            System.out.println(ingredient.getName()+" "+ingredient.getAmount());
        }
    }

}
