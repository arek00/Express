package tests.express.api.model.recipe;

import express.api.model.ingredient.Granular;
import express.api.model.ingredient.Ingredient;
import express.api.model.ingredient.Liquid;
import express.api.model.recipe.Recipe;
import express.api.model.recipe.RecipesSet;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class RecipesSetTest {

    RecipesSet recipesSet;
    ArrayList<Recipe> recipe = new ArrayList<Recipe>();
    ArrayList<Ingredient> ingredient = new ArrayList<Ingredient>();
    ArrayList<Ingredient> additive = new ArrayList<Ingredient>();

    @Before
    public void initialize()
    {
        recipesSet = new RecipesSet();

        ingredient.add(new Granular("Kawa",1));
        ingredient.add(new Liquid("Mleko",2));
        additive.add(new Granular("Posypka",3));
        additive.add(new Liquid("Śmietanka",4));

        recipesSet.addRecipe(new Recipe(ingredient,additive));
        recipesSet.addRecipe(new Recipe(additive,ingredient));
        recipesSet.addRecipe(new Recipe(ingredient,ingredient));
        recipesSet.addRecipe(new Recipe(additive,ingredient));
    }


}