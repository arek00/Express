package tests.express.api.model.recipes;

import express.api.model.ingredients.Granular;
import express.api.model.ingredients.Ingredient;
import express.api.model.ingredients.Ingredients;
import express.api.model.recipes.Recipe;
import express.api.model.recipes.RecipeMaker;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import tests.express.api.model.devices.containers.MockContainer;

import java.util.Iterator;

import static org.junit.Assert.*;

public class RecipeMakerTest {

    private static RecipeMaker maker;
    private static MockContainer container1, container2, container3, container4;
    private static Ingredient ingredient1, ingredient2, additive1, additive2;


    @BeforeClass
    public static void init() {
        maker = RecipeMaker.getInstance();
        container1 = new MockContainer("Kawa", Ingredients.GRANULAR, 1250);
        container2 = new MockContainer("Woda", Ingredients.LIQUID, 10000);
        container3 = new MockContainer("Cukier", Ingredients.GRANULAR, 1000);
        container4 = new MockContainer("Mleko", Ingredients.LIQUID, 1000);

        ingredient1 = container1.getIngredient();
        ingredient2 = container2.getIngredient();
        additive1 = container3.getIngredient();
        additive2 = container4.getIngredient();
    }


    @Before
    public void restore() {
        maker.clearRecipe();

        maker.addAdditive(additive1);
        maker.addAdditive(additive2);
        maker.addIngredient(ingredient1);
        maker.addIngredient(ingredient2);
    }


    @Test
    public void testAddIngredientAdditive() {
        assertTrue(maker.getAdditivesNumber() == 2);
        assertTrue(maker.getIngredientsNumber() == 2);

        maker.addAdditive(container1.getIngredient());
        maker.addIngredient(container2.getIngredient());

        assertTrue(maker.getAdditivesNumber() == 3);
        assertTrue(maker.getAdditivesNumber() == 3);
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveIngredientAdditive() {
        assertTrue(maker.getAdditivesNumber() == 2);
        assertTrue(maker.getIngredientsNumber() == 2);

        maker.removeIngredient(0);
        maker.removeIngredient(1);

        assertTrue(maker.getAdditivesNumber() == 1);
        assertTrue(maker.getIngredientsNumber() == 1);

        maker.removeIngredient(0);
        assertTrue(maker.getIngredientsNumber() == 0);

        maker.removeIngredient(0);
    }

    @Test
    public void testClearRecipe() {
        assertTrue(maker.getAdditivesNumber() == 2);
        assertTrue(maker.getIngredientsNumber() == 2);

        maker.clearRecipe();

        assertTrue(maker.getAdditivesNumber() == 0);
        assertTrue(maker.getIngredientsNumber() == 0);
    }

    @Test
    public void testCreateRecipe() {
        Recipe recipe = maker.createRecipe();

        assertTrue(recipe.getIngredientsNumber() == 2);
        assertTrue(recipe.getAdditivesNumber() == 2);
    }

    @Test
    public void testGetAllIngredientsAdditives() {
        Iterator<Ingredient> ingredientIterator = maker.getAllAdditives();
        int iteratorCount = 0;

        while (ingredientIterator.hasNext()) {
            ingredientIterator.next();
            iteratorCount++;
        }

        assertTrue(iteratorCount == 2);

        iteratorCount = 0;
        ingredientIterator = maker.getAllIngredients();

        while (ingredientIterator.hasNext()) {
            ingredientIterator.next();
            iteratorCount++;
        }

        assertTrue(iteratorCount == 2);
    }


    @Test
    public void testSetIngredientsFromRecipe() {

        Recipe recipe = maker.createRecipe();
        maker.clearRecipe();

        assertTrue(maker.getAdditivesNumber() == 0);
        assertTrue(maker.getIngredientsNumber() == 0);

        maker.setIngredientsFromRecipe(recipe);

        assertTrue(recipe.getAdditivesNumber() == maker.getAdditivesNumber());
        assertTrue(recipe.getIngredientsNumber() == maker.getIngredientsNumber());

    }

    @Test
    public void testGetAdditive() {

    }

    @Test
    public void testGetIngredient() {

    }
}