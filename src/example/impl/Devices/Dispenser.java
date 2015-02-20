package example.impl.Devices;

import express.api.controller.device.Device;
import express.api.exceptions.DeviceException;
import express.api.model.ingredient.Ingredient;
import express.api.model.recipe.Recipe;

import java.util.Collection;

/**
 * Created by Admin on 2015-01-13.
 */
public class Dispenser implements Device {

    private Recipe recipe;
    private int id;

    public Dispenser(int id) {
        this.id = id;
    }

    @Override
    public void perform() throws DeviceException {
        System.out.println("Wylewanie napoju");
        displayRecipe();

    }

    @Override
    public int getDeviceId() {
        return id;
    }

    private void displayRecipe() {
        System.out.println("Składniki napoju:");
        displayIngredientsCollection(recipe.getIngredients());

        System.out.println("Składniki Dodatki:");
        displayIngredientsCollection(recipe.getAdditives());
    }

    private void displayIngredientsCollection(Collection<Ingredient> ingredientsCollection) {
        for (Ingredient ingredient : ingredientsCollection) {
            System.out.println(ingredient.getName() + " : " + ingredient.getAmount());
        }
    }
}
