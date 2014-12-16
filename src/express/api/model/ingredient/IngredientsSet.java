package express.api.model.ingredient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by Admin on 2014-12-14.
 */
public class IngredientsSet {

    private static IngredientsSet instance = new IngredientsSet();

    public static IngredientsSet getInstance()
    {
        return instance;
    }

    private HashMap<Integer,Ingredient> ingredients = new HashMap<Integer, Ingredient>();

    public IngredientsSet()
    {
    }

    public void addIngredient(Ingredient ingredient)
    {
        int ingredientContainerId = ingredient.getContainerId();

        checkIdInSet(ingredientContainerId);
        this.ingredients.put(ingredientContainerId, ingredient);
    }

    public Ingredient getIngredient(int containerId)
    {
        if( this.ingredients.get(containerId) == null )
            throw new IllegalArgumentException("There's no Ingredient with id " + containerId);

        return this.ingredients.get(containerId);
    }

    public Iterator<Ingredient> getAllIngredients()
    {
        return ingredients.values().iterator();
    }

    private void checkIdInSet(int containerId){
        if( ingredients.get(containerId) != null )
        {
            throw new IllegalArgumentException(String.format("There's already ingredient set to container with %d id. Ids must be unique",
                    containerId));
        }
    }

}
