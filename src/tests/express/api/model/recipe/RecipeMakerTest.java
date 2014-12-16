package tests.express.api.model.recipe;

import express.api.model.ingredient.Granular;
import express.api.model.ingredient.Ingredient;
import express.api.model.ingredient.Liquid;
import express.api.model.recipe.Recipe;
import express.api.model.recipe.RecipeMaker;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.Assert.*;

public class RecipeMakerTest {

    static RecipeMaker recipeMaker = RecipeMaker.getInstance();
    static ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
    static ArrayList<Ingredient> additives = new ArrayList<Ingredient>();

    @Before
    public void initialize()
    {
        recipeMaker.clearRecipe();
        recipeMaker.addIngredient(new Granular("Kawa",1));
        recipeMaker.addIngredient(new Liquid("Woda",2));
        recipeMaker.addAdditive(new Granular("Cukier",4));
    }

    @Test
    public void shouldMadeRecipe()
    {
        Recipe recipe = recipeMaker.createRecipe();

        assertTrue(recipe.getAdditivesNumber() > 0);
        assertTrue(recipe.getIngredientsNumber() > 0);
    }

    @Test
    public void shouldRemove()
    {
        Ingredient additive = recipeMaker.getAdditive(0);
        recipeMaker.removeAdditive(0);

        assertFalse(recipeMaker.getAdditive(0) == additive);

        Ingredient ingredient = recipeMaker.getIngredient(0);
        recipeMaker.removeIngredient(0);

        assertFalse(recipeMaker.getIngredient(0) == ingredient);
    }

    @Test
    public void setIngredientsFromRecipe()
    {
        ingredients.add(new Liquid("Woda",1));
        ingredients.add(new Liquid("Mleko",2));

        additives.add(new Liquid("Mleko",3));
        additives.add(new Granular("Cukier",4));

        Recipe recipe = new Recipe(ingredients,additives);

        recipeMaker.setIngredientsFromRecipe(recipe);

        Iterator<Ingredient> recipeIterator = recipe.getIngredients();
        Iterator<Ingredient> makerIterator = recipeMaker.getAllIngredients();

        while(recipeIterator.hasNext() || makerIterator.hasNext())
        {
            assertTrue(recipeIterator.next() == makerIterator.next());
        }

        recipeIterator = recipe.getAdditives();
        makerIterator = recipeMaker.getAllAdditives();

        while(recipeIterator.hasNext() || makerIterator.hasNext())
        {
            assertTrue(recipeIterator.next() == makerIterator.next());
        }
    }

}