package tests.express.api.model.recipe;

import express.api.model.ingredient.Granular;
import express.api.model.ingredient.Ingredient;
import express.api.model.ingredient.Liquid;
import express.api.model.recipe.Recipe;
import org.junit.BeforeClass;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class RecipeTest {

    Recipe recipe;

    @BeforeClass
    public void initialize()
    {
        ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
        ingredients.add(new Granular("Kawa",1));
        ingredients.add(new Granular("Cappuccino",2));
        ingredients.add(new Liquid("Woda",3));

        ArrayList<Ingredient> additives = new ArrayList<Ingredient>();
        additives.add()

    }
}