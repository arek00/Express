package example.implementation.Sequences;

import express.api.controller.brew.BrewProcessSequence;
import express.api.controller.device.DevicesController;
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

            

        }


    }
}
