package express.api.model.recipe;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Admin on 2014-12-14.
 */
public class RecipesSet {

    private static RecipesSet instance = new RecipesSet();

    private ArrayList<Recipe> recipes = new ArrayList<Recipe>();

    private RecipesSet()
    {
    }

    public static RecipesSet getInstance()
    {
        return instance;
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
        if(!recipe.getIngredients().hasNext())
        {
            throw new IllegalArgumentException("Ingredients can't be empty");
        }

        recipes.add(recipe);
    }

    public int getNumberRecipes()
    {
        return recipes.size();
    }
}
