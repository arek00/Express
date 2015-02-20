package tests.express.api.model.recipe;

import express.api.model.ingredient.Granular;
import express.api.model.ingredient.Ingredient;
import express.api.model.ingredient.Liquid;
import express.api.model.recipe.Recipe;
import express.api.model.recipe.Recipes;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RecipesTest {

    private static Recipes recipes;
    private static Recipe recipe;

    private static List<Ingredient> ingredients;
    private static List<Ingredient> additives;

    @BeforeClass
    public static void init() {
        recipes = Recipes.getInstance();

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
    public void shouldAddRecipes() {
        recipes.addRecipe(recipe);
        recipes.addRecipe(recipe);
        recipes.addRecipe(recipe);

        int recipesAmount = recipes.getNumberRecipes();
        assertEquals(3, recipesAmount);

        assertEquals(recipe, recipes.getRecipe(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyRecipe() {
        ArrayList<Ingredient> emptyIngredientsList = new ArrayList<Ingredient>();
        Recipe emptyRecipe = new Recipe(emptyIngredientsList, additives);

        recipes.addRecipe(emptyRecipe);
    }

}