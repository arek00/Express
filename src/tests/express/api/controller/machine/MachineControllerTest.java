package tests.express.api.controller.machine;

import express.api.controller.machine.MachineController;
import express.api.model.ingredient.Granular;
import express.api.model.ingredient.Ingredient;
import express.api.model.ingredient.Liquid;
import express.api.model.recipe.Recipe;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MachineControllerTest {

    private MachineController controller = MachineController.getInstance();

    @Test
    public void addIngredientToSet() {

        Ingredient ingredient = new Granular("Cukier",7);
        controller.addIngredient(ingredient);

        assertTrue(controller.getIngredient(7) == ingredient );
    }

    @Test(expected = IllegalArgumentException.class)
    public void setIngredientsWithSameId()
    {
        Ingredient ingredient = new Granular("Cukier",10);
        controller.addIngredient(ingredient);
        ingredient = new Liquid("Mleko",10);
        controller.addIngredient(ingredient);
    }

    @Test
    public void addRecipeTest()
    {
        ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
        ArrayList<Ingredient> addictives = new ArrayList<Ingredient>();

        ingredients.add(new Granular("Cukier",1));
        ingredients.add(new Liquid("Woda",2));

        addictives.add(new Granular("Posypka",3));

        Recipe recipe = new Recipe(ingredients,addictives);

        controller.addRecipe(recipe);

        assertTrue(controller.getRecipe(0) == recipe);

    }

}