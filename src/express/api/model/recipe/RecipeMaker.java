package express.api.model.recipe;

import express.api.converter.IteratorConverter;
import express.api.model.ingredient.Ingredient;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Admin on 2014-12-14.
 */
public class RecipeMaker {

    private static RecipeMaker instance = new RecipeMaker();


    private List<Ingredient> ingredients = new ArrayList<Ingredient>();
    private List<Ingredient> additives = new ArrayList<Ingredient>();

    private RecipeMaker() {
    }

    public static RecipeMaker getInstance() {
        return RecipeMaker.instance;
    }

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public void addAdditive(Ingredient additive) {
        additives.add(additive);
    }

    public void removeIngredient(int ingredientNumber) {
        ingredients.remove(ingredientNumber);
    }

    public void removeAdditive(int additiveNumber) {
        additives.remove(additiveNumber);
    }

    public void clearRecipe() {
        ingredients.clear();
        additives.clear();
    }

    public Recipe createRecipe() {
        return new Recipe(ingredients, additives);
    }

    public Iterator<Ingredient> getAllIngredients() {
        return ingredients.iterator();
    }

    public Iterator<Ingredient> getAllAdditives() {
        return additives.iterator();
    }

    public void setIngredientsFromRecipe(Recipe recipe) {
        Collection<Ingredient> copyCollection;
        clearRecipe();

        copyCollection = IteratorConverter.toCollection(recipe.getIngredients());
        ingredients.addAll(copyCollection);

        copyCollection = IteratorConverter.toCollection(recipe.getAdditives());
        additives.addAll(copyCollection);
    }

    public Ingredient getAdditive(int additiveIndex) {
        return additives.get(additiveIndex);
    }

    public Ingredient getIngredient(int ingredientIndex) {
        return ingredients.get(ingredientIndex);
    }


}
