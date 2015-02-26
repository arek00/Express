package express.example.implementation.view;

import express.api.model.ingredients.Ingredient;
import express.api.model.recipes.Recipe;
import express.api.model.recipes.Recipes;

import java.awt.event.ActionListener;
import java.util.Iterator;

/**
 *
 */
public interface IView {

    public void setStartBrewingSequenceListener(ActionListener listener);

    public void setRecipesListener(ActionListener listener);

    public void setIngredientsListener(ActionListener listener);

    public Recipe getSelectedRecipe();

    public void setIngredientsList(Iterator<Ingredient> ingredients);

    public void setRecipesList(Iterator<Recipe> recipesIterator);

    public void showError(String message);

}
