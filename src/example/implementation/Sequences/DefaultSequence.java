package example.implementation.Sequences;

import example.implementation.devices.Grinder;
import express.api.controller.brew.BrewProcessSequence;
import express.api.controller.device.Device;
import express.api.controller.device.DevicesController;
import express.api.model.ingredient.Granular;
import express.api.model.ingredient.Ingredient;
import express.api.model.recipe.Recipe;

import java.util.Iterator;

/**
 * Created by Admin on 2014-12-16.
 */
public class DefaultSequence extends BrewProcessSequence {


    public DefaultSequence(DevicesController controller, Recipe recipe)
    {
        super(controller, recipe);
    }

    @Override
    public void perform() {
        Iterator<Ingredient> iterator;
        Ingredient ingredient;

        iterator = getRecipe().getIngredients();

        while(iterator.hasNext())
        {
            ingredient = iterator.next();



            if(ingredient instanceof Granular)
            {
                if(! ((Granular) ingredient).isGrounded())
                {
                    Device device = getController().getDeviceById(4);
                    ((Grinder)device).setIngredientToGrind(ingredient);
                }
            }


        }


    }
}
