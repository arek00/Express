package tests.express.api.model.recipe;

import express.api.model.ingredient.Granular;
import express.api.model.ingredient.Ingredient;
import express.api.model.ingredient.Liquid;
import express.api.model.recipe.Recipe;
import express.api.model.recipe.RecipeMaker;
import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;

public class RecipeMakerTest {

    private static RecipeMaker recipeMaker;
    private int ingredientsAmount;
    private int additivesAmount;

    @BeforeClass
    public static void init() {
        recipeMaker = RecipeMaker.getInstance();
    }

    @Test
    public void shouldAddIngredients() {
        fillRecipeMaker();
        ingredientsAmount = recipeMaker.getAllIngredients().size();
        additivesAmount = recipeMaker.getAllAdditives().size();
        assertEquals(2, ingredientsAmount);
        assertEquals(2, additivesAmount);
    }

    @Test
    public void shouldRemoveIngredients()
    {
        fillRecipeMaker();
        ingredientsAmount = recipeMaker.getAllIngredients().size();
        additivesAmount = recipeMaker.getAllAdditives().size();

        assertTrue(ingredientsAmount > 0);
        assertTrue(additivesAmount > 0);

        recipeMaker.removeIngredient(0);
        recipeMaker.removeAdditive(0);

        assertEquals(ingredientsAmount - 1,recipeMaker.getAllIngredients().size());
        assertEquals(additivesAmount - 1, recipeMaker.getAllAdditives().size());

        recipeMaker.clearRecipe();

        assertEquals(0, recipeMaker.getAllIngredients().size());
        assertEquals(0, recipeMaker.getAllAdditives().size());

    }



    private void fillRecipeMaker()
    {
        recipeMaker.addIngredient(new Liquid("Woda", 10));
        recipeMaker.addIngredient(new Granular("Cukier", 11));

        recipeMaker.addAdditive(new Liquid("Mleko", 7));
        recipeMaker.addAdditive(new Granular("Mleko w proszku", 8));

    }

    @Test
    public void setFromRecipe()
    {
        ArrayList<Ingredient> ingredients;
        ArrayList<Ingredient> additives;

        ingredients = new ArrayList<Ingredient>();
        additives = new ArrayList<Ingredient>();

        ingredients.add(new Granular("Kawa", 0));
        ingredients.add(new Granular("Kakao", 1));
        ingredients.add(new Liquid("Woda", 2));

        additives.add(new Granular("Cukier", 3));
        additives.add(new Granular("Posypka", 4));
        additives.add(new Liquid("Mleko", 5));

        Recipe recipe = new Recipe(ingredients, additives);


        recipeMaker.setIngredientsFromRecipe(recipe);

        Collection<Ingredient> recipeMakerCollection = recipeMaker.getAllIngredients();

        assertTrue(recipeMaker.getAllAdditives().size() == additives.size());
        assertTrue(recipeMaker.getAllIngredients().size() == ingredients.size());

    }

}