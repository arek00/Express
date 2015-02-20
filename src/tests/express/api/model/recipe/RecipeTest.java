package tests.express.api.model.recipe;

import express.api.model.ingredient.Granular;
import express.api.model.ingredient.Ingredient;
import express.api.model.ingredient.Liquid;
import express.api.model.recipe.Recipe;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import static org.junit.Assert.*;

public class RecipeTest {

    private static Recipe recipe;
    private static ArrayList<Ingredient> ingredients;
    private static ArrayList<Ingredient> additives;


    @BeforeClass
    public static void init() {
        ingredients = new ArrayList<Ingredient>();
        additives = new ArrayList<Ingredient>();

        ingredients.add(new Granular("Kawa", 0));
        ingredients.add(new Granular("Kakao", 1));
        ingredients.add(new Liquid("Woda", 2));

        additives.add(new Granular("Cukier", 3));
        additives.add(new Granular("Posypka", 4));
        additives.add(new Liquid("Mleko", 5));

        recipe = new Recipe(ingredients, additives);
    }

    @Test
    public void getIngredientsCollections() {
        Collection<Ingredient> returnedIngredients = recipe.getIngredients();
        Collection<Ingredient> returnedAdditives = recipe.getAdditives();

        assertEquals(returnedIngredients.size(), recipe.getIngredientsNumber());
        assertEquals(returnedAdditives.size(), recipe.getAdditivesNumber());

        Iterator<Ingredient> returnedIterator = returnedAdditives.iterator();
        Iterator<Ingredient> ingredientIterator = recipe.getAdditives().iterator();

        while (returnedIterator.hasNext()) {
            assertTrue(returnedIterator.next() == ingredientIterator.next());
        }

        returnedIterator = returnedIngredients.iterator();
        ingredientIterator = recipe.getIngredients().iterator();

        while (returnedIterator.hasNext()) {
            assertTrue(returnedIterator.next() == ingredientIterator.next());
        }
    }


}