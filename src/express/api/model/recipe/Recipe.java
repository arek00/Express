package express.api.model.recipe;

import express.api.model.ingredient.Ingredient;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Admin on 2014-12-14.
 */
public class Recipe {

    private String recipeName;
    private List<Ingredient> ingredients = new ArrayList<Ingredient>();
    private List<Ingredient> additives = new ArrayList<Ingredient>();

    public Recipe(List<Ingredient> ingredients, List<Ingredient> additives) {
        this.ingredients.addAll(ingredients);
        this.additives.addAll(additives);
    }

    public Iterator<Ingredient> getIngredients() {
        return ingredients.iterator();
    }

    public Iterator<Ingredient> getAdditives() {
        return additives.iterator();
    }

    public int getIngredientsNumber() {
        return ingredients.size();
    }

    public int getAdditivesNumber() {
        return additives.size();
    }

}
