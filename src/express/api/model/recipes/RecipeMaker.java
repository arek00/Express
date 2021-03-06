package express.api.model.recipes;

import express.api.utils.converters.IteratorConverter;
import express.api.model.ingredients.Ingredient;
import express.api.utils.validators.ArgumentsValidator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Generate Recipe from current chosen ingredients.
 */
public class RecipeMaker {

    private static RecipeMaker instance = new RecipeMaker();


    private List<Ingredient> ingredients = new ArrayList<Ingredient>();
    private List<Ingredient> additives = new ArrayList<Ingredient>();
    private String name;

    private RecipeMaker() {
    }

    /**
     * @return instance of RecipeMaker
     */
    public static RecipeMaker getInstance() {
        return RecipeMaker.instance;
    }

    /**
     * Add main ingredient to set in order to create recipe.
     *
     * @param ingredient instance of ingredient.
     */
    public void addIngredient(Ingredient ingredient) {
        ArgumentsValidator.notNull(ingredient);
        ingredients.add(ingredient);
    }

    /**
     * Add additive to recipe
     *
     * @param additive Ingredient that will be additive to drink.
     */
    public void addAdditive(Ingredient additive) {
        ArgumentsValidator.notNull(additive);
        additives.add(additive);
    }

    /**
     * Remove ingredient from current set of main ingredients.
     *
     * @param ingredientIndex index of ingredient in current set.
     */
    public void removeIngredient(int ingredientIndex) {
        ingredients.remove(ingredientIndex);
    }

    /**
     * Remove ingredient from current set of main ingredients.
     *
     * @param additiveIndex index of ingredient in current set.
     */
    public void removeAdditive(int additiveIndex) {
        additives.remove(additiveIndex);
    }

    /**
     * Clear current set of ingredients and additives.
     */
    public void clearRecipe() {
        ingredients.clear();
        additives.clear();

    }

    /**
     * Get amount of ingredients in current recipe in making
     *
     * @return Number of ingredients
     */
    public int getIngredientsNumber() {
        return ingredients.size();
    }


    /**
     * Get amount of additives in current recipe in making
     *
     * @return Number of additives
     */
    public int getAdditivesNumber() {
        return additives.size();
    }

    /**
     * Create instance of Recipe that contains current chosen ingredients and additives.
     *
     * @return Instance of Recipe
     */
    public Recipe createRecipe() {
        ArgumentsValidator.notNull(ingredients);
        ArgumentsValidator.notNull(additives);
        ArgumentsValidator.collectionNotEmpty(ingredients);

        return new Recipe(name, ingredients, additives);
    }

    /**
     * Get all current chosen ingredients.
     *
     * @return Iterator to ingredients
     */
    public Iterator<Ingredient> getAllIngredients() {
        return ingredients.iterator();
    }


    /**
     * Get all current chosen additives.
     *
     * @return Iterator to additives.
     */
    public Iterator<Ingredient> getAllAdditives() {
        return additives.iterator();
    }

    /**
     * Set current ingredients and additives from existing recipe in order to create or modify recipe.
     *
     * @param recipe Recipe to set in maker.
     */
    public void setIngredientsFromRecipe(Recipe recipe) {
        ArgumentsValidator.notNull(recipe);

        Collection<Ingredient> copyCollection;
        clearRecipe();

        copyCollection = IteratorConverter.toCollection(recipe.getIngredients());
        ingredients.addAll(copyCollection);

        copyCollection = IteratorConverter.toCollection(recipe.getAdditives());
        additives.addAll(copyCollection);
    }

    /**
     * @param additiveIndex Index of additive in current set.
     * @return Additive under given index.
     */
    public Ingredient getAdditive(int additiveIndex) {
        return additives.get(additiveIndex);
    }

    /**
     * @param ingredientIndex Index of additive in current set.
     * @return Ingredient under given index.
     */
    public Ingredient getIngredient(int ingredientIndex) {
        return ingredients.get(ingredientIndex);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return createRecipe().toString();
    }


}
