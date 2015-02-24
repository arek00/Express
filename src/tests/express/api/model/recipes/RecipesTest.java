package tests.express.api.model.recipes;

import express.api.model.devices.containers.Container;
import express.api.model.ingredients.Ingredient;
import express.api.model.ingredients.Ingredients;
import express.api.model.recipes.Recipe;
import express.api.model.recipes.RecipeMaker;
import express.api.model.recipes.Recipes;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import tests.express.api.model.devices.containers.MockContainer;

import java.util.Iterator;

import static org.junit.Assert.*;

public class RecipesTest {

    private static Recipes recipes;
    private static RecipeMaker recipeMaker;
    private static Recipe recipe1, recipe2, recipe3;
    private static Ingredient ingredient1, ingredient2, ingredient3;
    private static Container container1, container2, container3;

    @BeforeClass
    public static void init() {
        recipes = Recipes.getInstance();
        recipeMaker = RecipeMaker.getInstance();

        container1 = new MockContainer("Mleko", Ingredients.LIQUID, 1200);
        container2 = new MockContainer("Woda", Ingredients.LIQUID, 2500);
        container3 = new MockContainer("Cukier", Ingredients.GRANULAR, 1000);

        ingredient1 = container1.getIngredient();
        ingredient2 = container2.getIngredient();
        ingredient3 = container3.getIngredient();

        recipeMaker.addIngredient(ingredient1);
        recipeMaker.addAdditive(ingredient3);
        recipe1 = recipeMaker.createRecipe();
        recipeMaker.clearRecipe();

        recipeMaker.addIngredient(ingredient1);
        recipeMaker.addIngredient(ingredient2);
        recipeMaker.addAdditive(ingredient3);
        recipe2 = recipeMaker.createRecipe();
        recipeMaker.clearRecipe();

        recipeMaker.addIngredient(ingredient2);
        recipe3 = recipeMaker.createRecipe();
        recipeMaker.clearRecipe();

        recipes.addRecipe(recipe1);
        recipes.addRecipe(recipe2);
        recipes.addRecipe(recipe3);
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetRecipe() {
        Recipe recipe = recipes.getRecipe(0);
        assertTrue(recipe == recipe1);

        recipe = recipes.getRecipe(2);
        assertTrue(recipe == recipe3);

        recipe = recipes.getRecipe(10);
    }

    @Test
    public void testGetRecipes() {
        Iterator<Recipe> recipeIterator = recipes.getRecipes();

        assertTrue(recipeIterator.hasNext());
        assertTrue(recipeIterator.next() == recipe1);
    }

    @Test
    public void testAddRecipe() {
        int recipesNumber = recipes.getNumberRecipes();
        recipes.addRecipe(recipe2);
        recipes.addRecipe(recipe3);

        assertTrue(recipesNumber + 2 == recipes.getNumberRecipes());
    }
}