package express.example.implementation.containers;

import express.api.exceptions.DeviceException;
import express.api.model.devices.containers.Container;
import express.api.model.ingredients.Ingredient;
import express.api.model.ingredients.Ingredients;
import express.api.utils.validators.ArgumentsValidator;
import express.example.implementation.exceptions.IngredientInContainerNotSet;

/**
 * Created sby Admin on 2015-02-23.
 */
public class LiquidContainer extends Container {

    private Ingredient ingredient;

    public LiquidContainer(String ingredientName, double containerState) {
        super(ingredientName, Ingredients.LIQUID, containerState);
    }

    public void setIngredient(Ingredient ingredient) {
        ArgumentsValidator.nullArgument(ingredient);
        this.ingredient = ingredient;
    }

    @Override
    public void perform() throws DeviceException {
        if (ingredient == null) {
            throw new IngredientInContainerNotSet("Ingredient hadn't been set.");
        }

        setContainerState(containerState - ingredient.getAmount());
    }

    @Override
    public String getName() {
        return name;
    }
}
