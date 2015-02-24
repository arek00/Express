package express.example.implementation.view;

import express.api.model.ingredients.Ingredient;
import express.api.model.recipes.Recipe;

import java.awt.event.ActionListener;
import java.util.Iterator;

/**
 * Created by Admin on 2015-02-24.
 */
public interface IView {

    public void setStartBrewSequenceListener(ActionListener listener);
    public void setRecipes(Iterator<Recipe> recipes);
    public void setIngredients(Iterator<Ingredient> ingredients);

    public String getRecipe();

    public void onRecipeChooseListener(ActionListener listener);
}
