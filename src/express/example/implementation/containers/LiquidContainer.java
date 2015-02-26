package express.example.implementation.containers;

import express.api.exceptions.DeviceException;
import express.api.model.devices.containers.Container;
import express.api.model.ingredients.Ingredient;
import express.api.model.ingredients.Ingredients;
import express.api.utils.validators.ArgumentsValidator;
import express.example.implementation.exceptions.IngredientInContainerNotSet;

/**
 * Class that represents Container that holds liquid ingredients.
 */
public class LiquidContainer extends Container {

    private Ingredient ingredient;

    /**
     * @param ingredientName Name of ingredient and container
     * @param containerState Amount of ingredient in container in grams.
     */
    public LiquidContainer(String ingredientName, double containerState) {
        super(ingredientName, Ingredients.LIQUID, containerState);
    }


    /**
     * Set ingredient in order to get given by ingredient instance amount of this from this container.
     *
     * @param ingredient ingredient that's amount property has been set.
     */
    public void setIngredient(Ingredient ingredient) {
        ArgumentsValidator.notNull(ingredient);
        this.ingredient = ingredient;
    }

    /**
     * Perform operation implement by this device, in this case retrieving ingredient from container.
     * Method will be use by express machine during execute brewing sequence.
     *
     * @throws DeviceException
     */
    @Override
    public void perform() throws DeviceException {
        if (ingredient == null) {
            throw new IngredientInContainerNotSet("Ingredient hadn't been set.");
        }

        setContainerState(containerState - ingredient.getAmount());
    }

    /**
     * Get name of this container.
     *
     * @return name of container.
     */
    @Override
    public String getName() {
        return name;
    }
}
