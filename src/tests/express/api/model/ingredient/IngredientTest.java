package tests.express.api.model.ingredient;

import express.api.model.ingredient.Ingredient;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTest {

    private static Ingredient ingredient;

    @BeforeClass
    public static void init() {
        ingredient = new Ingredient("Składnik", 10);
    }


    @Test
    public void shouldGetValues() {
        String name = ingredient.getName();

        assertFalse(name.isEmpty());
        assertTrue(name.equals("Składnik"));

        ingredient.setAmount(0);
        assertEquals(0, ingredient.getAmount());
        assertEquals(10, ingredient.getContainerId());

    }

    @Test(expected = IllegalArgumentException.class)
    public void setAmountTest()
    {
        ingredient.setAmount(10);
        assertEquals(10, ingredient.getAmount());

        ingredient.setAmount(-1);
    }


}