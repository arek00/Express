package express.api.model.recipes;

import express.api.model.ingredients.Ingredient;
import express.api.utils.validators.ArgumentsValidator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Class that represents Recipe. It contains main ingredients of drink and its additives that should be used by express
 * to brew coffee.
 */
public class Recipe {

    private String recipeName;
    private List<Ingredient> ingredients = new ArrayList<Ingredient>();
    private List<Ingredient> additives = new ArrayList<Ingredient>();

    /**
     * This constructor should be use by RecipeMaker to create Recipe from chose ingredients and additives.
     * Also containing of ingredients is mandatory but additives optional.
     *
     * @param ingredients List of ingredients
     * @param additives   List of additives
     */
    public Recipe(String recipeName, List<Ingredient> ingredients, List<Ingredient> additives) {

        ArgumentsValidator.nullArgument(ingredients);
        ArgumentsValidator.nullArgument(additives);
        ArgumentsValidator.emptyCollection(ingredients);
        ArgumentsValidator.nullArgument(recipeName);
        ArgumentsValidator.emptyString(recipeName);

        this.recipeName = recipeName;
        this.ingredients.addAll(ingredients);
        this.additives.addAll(additives);
    }

    /**
     * Get an iterator to list of main ingredients in this recipe.
     *
     * @return Iterator of ingredients.
     */
    public Iterator<Ingredient> getIngredients() {
        return ingredients.iterator();
    }

    /**
     * @return Iterator to Additives in recipe.
     */
    public Iterator<Ingredient> getAdditives() {
        return additives.iterator();
    }

    /**
     * @return Amount of ingredients in recipe.
     */
    public int getIngredientsNumber() {
        return ingredients.size();
    }

    /**
     * @return number of additives in recipe.
     */
    public int getAdditivesNumber() {
        return additives.size();
    }

    /**
     * @return Name of recipe
     */
    public String getRecipeName() {
        return recipeName;
    }


    /**
     * Return string that lists ingredients and additives in that recipe.
     * Returned string surely be multiline.
     * Mainly for views purposes.
     * <p/>
     * Format of recipe:
     * <p/>
     * Ingredients:
     * *List of ingredients*
     * <p/>
     * Additives:
     * *List of additives*
     *
     * @return String that describe recipe
     */
    @Override
    public String toString() {
        String result = recipeName + " \nIngredients: \n";

        for (Ingredient each : ingredients) {
            result += each.toString() + " \n";
        }

        result += "Additives: \n";

        for (Ingredient each : additives) {
            result += each.toString() + " \n";
        }

        return result;
    }

}
