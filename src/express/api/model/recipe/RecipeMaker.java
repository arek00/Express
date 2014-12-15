package express.api.model.recipe;

import express.api.model.ingredient.Ingredient;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Admin on 2014-12-14.
 */
public class RecipeMaker {

    private static RecipeMaker instance = new RecipeMaker();


    private ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
    private ArrayList<Ingredient> additives = new ArrayList<Ingredient>();

    private RecipeMaker()
    {
    }

    public static RecipeMaker getInstance()
    {
        return RecipeMaker.instance;
    }

    public void addIngredient(Ingredient ingredient)
    {
        ingredients.add(ingredient);
    }

    public void addAdditive(Ingredient additive)
    {
        additives.add(additive);
    }

    public void removeIngredient(int ingredientNumber)
    {
        ingredients.remove(ingredientNumber);
    }

    public void removeAdditive(int additiveNumber)
    {
        additives.remove(additiveNumber);
    }

    public void clearRecipe()
    {
        ingredients.clear();
        additives.clear();
    }

    public Recipe createRecipe()
    {
        return new Recipe(ingredients,additives);
    }

    public Iterator<Ingredient> getAllIngredients()
    {
        return ingredients.iterator();
    }

    public Iterator<Ingredient> getAllAdditives()
    {
        return additives.iterator();
    }

    public void setIngredientsFromRecipe(Recipe recipe)
    {
        Iterator<Ingredient> ingredientIterator = recipe.getIngredients();
        Iterator<Ingredient> additiveIterator = recipe.getAdditives();

        putFromIteratorToArray(ingredientIterator,ingredients);
        putFromIteratorToArray(additiveIterator,additives);
    }

    private <E>  void putFromIteratorToArray(Iterator<E> iterator, ArrayList<E> arrayList)
    {
        while(iterator.hasNext())
        {
            arrayList.add(iterator.next());
        }
    }

}
