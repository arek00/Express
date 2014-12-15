package tests.express.api.model.ingredient;

import express.api.model.ingredient.Granular;
import express.api.model.ingredient.Ingredient;
import express.api.model.ingredient.IngredientsSet;
import express.api.model.ingredient.Liquid;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class IngredientsSetTest {

    private static IngredientsSet ingredientsSet = new IngredientsSet();

    @BeforeClass
    public static void initializeIngredientSet()
    {
        ingredientsSet.addIngredient(new Granular("Kawa",1));
        ingredientsSet.addIngredient(new Liquid("Woda",2));
        ingredientsSet.addIngredient(new Liquid("Mleko",3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void IdsShouldBeUnique()
    {
        ingredientsSet.addIngredient(new Granular("Posypka",1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldntReturnIngredientWithWrongId()
    {
        assertNotNull(ingredientsSet.getIngredient(3));
        ingredientsSet.getIngredient(11);
    }

    @Test
    public void iteratorShouldntBeEmpty()
    {
        Iterator<Ingredient> ingredientsIterator = ingredientsSet.getAllIngredients();
        assertTrue(ingredientsIterator.hasNext());
    }

}