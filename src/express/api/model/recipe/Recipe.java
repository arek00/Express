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

    private List<Ingredient> ingredients = new ArrayList<Ingredient>();
    private List<Ingredient> additives = new ArrayList<Ingredient>();

    public Recipe(List<Ingredient> ingredients, List<Ingredient> additives) {
        this.ingredients.addAll(ingredients);
        this.additives.addAll(additives);
    }

    public Collection<Ingredient> getIngredients() {
        return ingredients;
    }

    public Collection<Ingredient> getAdditives() {
        return additives;
    }

    public int getIngredientsNumber() {
        return ingredients.size();
    }

    public int getAdditivesNumber() {
        return additives.size();
    }

}
