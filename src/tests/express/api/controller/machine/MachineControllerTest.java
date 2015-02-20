package tests.express.api.controller.machine;

import example.impl.DevicesIds;
import express.api.controller.machine.MachineController;
import express.api.model.ingredient.Granular;
import express.api.model.ingredient.Ingredient;
import express.api.model.ingredient.Liquid;
import express.api.model.recipe.Recipe;
import express.api.model.recipe.RecipeMaker;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class MachineControllerTest {

    private static MachineController controller;

    @BeforeClass
    public static void init()
    {
        controller = MachineController.getInstance();
    }

    @Test
    public void addRecipeTest()
    {
        Ingredient milk = new Liquid("Mleko", DevicesIds.MILK_CONTAINER.getValue());
        Ingredient coffee = new Granular("Kawa", DevicesIds.COFFEE_CONTAINER.getValue());
        Ingredient sugar = new Granular("Cukier", DevicesIds.SUGAR_CONTAINER.getValue());

        RecipeMaker recipeMaker = RecipeMaker.getInstance();
        recipeMaker.addIngredient(milk);
        recipeMaker.addAdditive(sugar);

        controller.addRecipe(recipeMaker.createRecipe());

        assertTrue(controller.getAllRecipes().isEmpty());

        recipeMaker.clearRecipe();

        assertTrue(controller.getAllRecipes().size() > 0);

        recipeMaker.addIngredient(coffee);
        recipeMaker.addAdditive(milk);
        controller.addRecipe(recipeMaker.createRecipe());


        Recipe recipe = controller.getRecipe(0);

        assertNotNull(recipe);

        assertTrue(controller.getAllIngredients().size() > 0);

    }

}