package express.api.controller.machine;

import express.api.controller.brew.BrewProcessSequence;
import express.api.controller.brew.BrewSequencePerformer;
import express.api.model.ingredient.Ingredient;
import express.api.model.ingredient.IngredientsSet;
import express.api.model.recipe.Recipe;
import express.api.model.recipe.RecipeMaker;
import express.api.model.recipe.RecipesSet;

import java.util.Iterator;

/**
 * Created by Admin on 2014-12-14.
 */
public class MachineController {

    private IngredientsSet ingredientsSet;
    private RecipesSet recipesSet;
    private RecipeMaker recipeMaker;
    private BrewSequencePerformer brewSequencePerformer;


    public Ingredient getIngredient(int containerId)
    {
        return ingredientsSet.getIngredient(containerId);
    }

    public Iterator<Ingredient> getAllIngredients()
    {
        return ingredientsSet.getAllIngredients();
    }

    public void addIngredient(Ingredient ingredient)
    {
        ingredientsSet.addIngredient(ingredient);
    }

    public Recipe getRecipe(int recipeNumber)
    {
        return recipesSet.getRecipe(recipeNumber);
    }

    public Iterator<Recipe> getAllRecipes()
    {
        return recipesSet.getAllRecipes();
    }

    public void addRecipe(Recipe recipe)
    {
        recipesSet.addRecipe(recipe);
    }

    public void performBrewProcessSequence(BrewProcessSequence sequence)
    {
        sequence.perform();
    }

}
