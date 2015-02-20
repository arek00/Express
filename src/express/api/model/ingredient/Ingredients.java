package express.api.model.ingredient;

import java.util.*;

public class Ingredients {

    private static Ingredients instance = new Ingredients();

    public static Ingredients getInstance() {
        return instance;
    }

    private List<Ingredient> ingredients = new ArrayList<Ingredient>();

    /**
     * Add ingredient to current set of ingredients. Ingredient must be unique.
     *
     * @param ingredient
     */
    public void addIngredient(Ingredient ingredient) {
        validationIngredientOnList(ingredient);
        ingredients.add(ingredient);
    }

    /**
     * Get ingredient by its Id.
     *
     * @param id Index/Identification of ingredient.
     * @return Ingredient under given id.
     */
    public Ingredient getIngredient(int id) {
        return this.ingredients.get(id);
    }

    /**
     * Get list of all currently stored ingredients
     *
     * @return Iterator of ingredients.
     */
    public Iterator<Ingredient> getIngredients() {
        return ingredients.iterator();
    }

    private void validationIngredientOnList(Ingredient ingredient) {
        if (ingredients.contains(ingredient)) {
            throw new IllegalArgumentException("There's already this ingredient on list.");
        }
    }
}
