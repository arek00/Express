package express.api.model.recipe;

import express.api.model.ingredient.Ingredient;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Admin on 2014-12-14.
 */
public class Recipe {

    private ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
    private ArrayList<Ingredient> additives = new ArrayList<Ingredient>();

    public Recipe(ArrayList<Ingredient> ingredients, ArrayList<Ingredient> additives)
    {
        this.ingredients.addAll(ingredients);
        this.additives.addAll(additives);
    }

    public Iterator<Ingredient> getIngredients()
    {
        return ingredients.iterator();
    }

    public Iterator<Ingredient> getAdditives()
    {
        return additives.iterator();
    }

}
