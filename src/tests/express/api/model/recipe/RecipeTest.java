package tests.express.api.model.recipe;

import express.api.model.ingredient.Granular;
import express.api.model.ingredient.Ingredient;
import express.api.model.ingredient.Liquid;
import express.api.model.recipe.Recipe;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.Assert.*;

public class RecipeTest {

    Recipe recipe;
    ArrayList<Ingredient> ingredients;
    ArrayList<Ingredient> additives;

    @Before
    public void initialize()
    {
        ingredients = new ArrayList<Ingredient>();
        ingredients.add(new Granular("Kawa",1));
        ingredients.add(new Granular("Cappuccino",2));
        ingredients.add(new Liquid("Woda",3));

        additives = new ArrayList<Ingredient>();
        additives.add(new Granular("Cukier",4));
        additives.add(new Liquid("Mleko",5));
        additives.add(new Liquid("Śmietanka",6));

        recipe = new Recipe(ingredients, additives);
    }

    @Test
    public void ingredientsListShouldntBeEmpty()
    {
        Iterator<Ingredient> ingredientIterator = recipe.getIngredients();
        assertTrue(ingredientIterator.hasNext());
    }

    @Test
    public void additivesListShouldntBeEmpty()
    {
        Iterator<Ingredient> additivesIterator = recipe.getAdditives();

       assertTrue(additivesIterator.hasNext());
    }


    @Test
    public void additivesHasThreeElements()
    {
        assertTrue(additives.size() == 3);
    }
}