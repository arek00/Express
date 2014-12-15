package tests.express.api.model.ingredient;

import express.api.model.ingredient.Granular;
import express.api.model.ingredient.Ingredient;
import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTest {

    String ingredientName = "Kawa";
    int containerId = 1;

    Ingredient ingredient = new Granular(ingredientName, containerId);

    @Test
    public void instanceShouldBeInitialized()
    {
        assertTrue(ingredient.getName().equals(ingredientName));
        assertTrue(ingredient.getContainerId() == containerId);
    }


    @Test
    public void amountShouldBeZero()
    {
        assertTrue(ingredient.getAmount() == 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void amountShouldntBeLesserThanZero()
    {
        ingredient.setAmount(-1);
        assertFalse(ingredient.getAmount() >= 0);
    }
}