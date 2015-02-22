package express.api.model.recipes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Set of Recipes stored in express' memory.
 */
public class Recipes {

    private static Recipes instance = new Recipes();

    private List<Recipe> recipes = new ArrayList<Recipe>();

    private Recipes() {
    }

    /**
     * @return Instance of Recipes Collection
     */
    public static Recipes getInstance() {
        return instance;
    }

    public Recipe getRecipe(int recipeIndex) {
        return recipes.get(recipeIndex);
    }

    /**
     * Get iterator to all recipes.
     *
     * @return Iterator of recipes.
     */
    public Iterator<Recipe> getRecipes() {
        return recipes.iterator();
    }

    /**
     * Add recipe to collection of recipes.
     *
     * @param recipe Recipe that must be collected in.
     */
    public void addRecipe(Recipe recipe) {
        if (!recipe.getIngredients().hasNext()) {
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
