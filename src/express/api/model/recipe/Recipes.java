package express.api.model.recipe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Admin on 2014-12-14.
 */
public class Recipes {

    private static Recipes instance = new Recipes();

    private List<Recipe> recipes = new ArrayList<Recipe>();

    private Recipes() {
    }

    /**
     *
     * @return Instance of Recipes Collection
     */
    public static Recipes getInstance() {
        return instance;
    }

    public Recipe getRecipe(int recipeIndex) {
        return recipes.get(recipeIndex);
    }

    /**
     * Get all recipes from Collection of recipes.
     *
     * @return Collection of recipes
     */
    public Collection<Recipe> getAllRecipes() {
        return recipes;
    }

    /**
     * Add recipe to collection of recipes.
     * @param recipe Recipe that must be collected in.
     */
    public void addRecipe(Recipe recipe) {
        if (recipe.getIngredients().isEmpty()) {
            throw new IllegalArgumentException("Ingredients can't be empty");
        }

        recipes.add(recipe);
    }

    /**
     * @return Amount of elements in Collection
     */
    public int getNumberRecipes() {
        return recipes.size();
    }
}
