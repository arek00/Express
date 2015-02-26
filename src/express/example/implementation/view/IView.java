package express.example.implementation.view;

import express.api.model.ingredients.Ingredient;
import express.api.model.recipes.Recipe;
import express.api.model.recipes.Recipes;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Iterator;

/**
 *
 */
public interface IView {

    public void setRecipesListener(ActionListener listener);

    public void setRecipes(Iterator<Recipe> recipes);

    public void setIngredientsListener(ActionListener listener);

    public void setIngredients(Iterator<Ingredient> ingredients);

    public void setIngredientListener(ActionListener listener);

    public void setAdditiveListener(ActionListener listener);

    public Ingredient getIngredient();

    public Ingredient getAdditive();

    public void setRecipeDescription(String description);

}
