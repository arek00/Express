package tests.express.api.model.recipe;

import express.api.model.ingredient.Granular;
import express.api.model.ingredient.Ingredient;
import express.api.model.ingredient.Liquid;
import express.api.model.recipe.Recipe;
import express.api.model.recipe.RecipesSet;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class RecipesSetTest {

    static RecipesSet recipesSet;
    static ArrayList<Ingredient> ingredient = new ArrayList<Ingredient>();
    static ArrayList<Ingredient> additive = new ArrayList<Ingredient>();

    @BeforeClass
    public static void initialize()
    {
        recipesSet = RecipesSet.getInstance();

        ingredient.add(new Granular("Kawa",1));
        ingredient.add(new Liquid("Mleko",2));
        additive.add(new Granular("Posypka",3));
        additive.add(new Liquid("Śmietanka",4));

        recipesSet.addRecipe(new Recipe(ingredient,additive));
        recipesSet.addRecipe(new Recipe(additive,ingredient));
        recipesSet.addRecipe(new Recipe(ingredient,ingredient));
        recipesSet.addRecipe(new Recipe(additive,ingredient));
    }

    @Test
    public void numberRecipesTest()
    {
        assertTrue(recipesSet.getNumberRecipes() == 4);
    }

    @Test
    public void addingRecipeTest()
    {
        assertTrue(recipesSet.getNumberRecipes() == 4);
        assertFalse(recipesSet.getNumberRecipes() == 8);
        recipesSet.addRecipe(new Recipe(ingredient, ingredient));
        assertTrue(ingredient.iterator().hasNext());
        assertTrue(recipesSet.getNumberRecipes() == 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addingEmptyIngredientsList()
    {
        assertTrue(recipesSet.getNumberRecipes() == 4);

        ArrayList<Ingredient> emptyIngredientsList = new ArrayList<Ingredient>();
        emptyIngredientsList.clear();

        assertTrue(emptyIngredientsList.size() == 0);

        recipesSet.addRecipe(new Recipe(emptyIngredientsList, ingredient));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getElementOutOfRecipeSet()
    {
        assertTrue(recipesSet.getNumberRecipes() == 4);

        recipesSet.getRecipe(5);

    }

}