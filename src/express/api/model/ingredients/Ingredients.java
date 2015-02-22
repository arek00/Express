package express.api.model.ingredients;

import express.api.model.devices.containers.Container;
import express.api.model.devices.containers.Containers;

import java.util.*;

/**
 * Class that manages but doesn't store instances of ingredients.
 * It is able to return list of ingredients.
 */
public class Ingredients {

    private static Ingredients instance = new Ingredients();
    private Containers containersSet = Containers.getInstance();

    public static final int GRANULAR = 0;
    public static final int LIQUID = 1;


    /**
     * Get an instance of Ingredients set, singleton.
     *
     * @return instance of Ingredients.
     */
    public static Ingredients getInstance() {
        return instance;
    }

    /**
     * Get ingredient from given container instance.
     *
     * @param container Instance of container.
     * @return ingredient instance.
     */
    public Ingredient getIngredient(Container container) {
        return container.getIngredient();
    }


    /**
     * Get list of all currently stored ingredients
     *
     * @return Iterator of ingredients.
     */
    public Iterator<Ingredient> getIngredients() {
        Iterator<Container> containersIterator;
        Collection<Ingredient> ingredientsCollection = new ArrayList<Ingredient>();

        containersIterator = containersSet.getContainers();

        while (containersIterator.hasNext()) {
            Container container = containersIterator.next();
            ingredientsCollection.add(container.getIngredient());
        }

        return ingredientsCollection.iterator();
    }

}
