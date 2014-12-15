package express.api.model.recipe;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Admin on 2014-12-14.
 */
public class RecipesSet {

    private ArrayList<Recipe> recipes = new ArrayList<Recipe>();

    public RecipesSet()
    {
    }

    public Recipe getRecipe(int recipeIndex)
    {
        return recipes.get(recipeIndex);
    }

    public Iterator<Recipe> getAllRecipes()
    {
        return recipes.iterator();
    }

    public void addRecipe(Recipe recipe)
    {
        recipes.add(recipe);
    }
}
