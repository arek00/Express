package tests.express.api.model.devices.containers;

import express.api.exceptions.DeviceException;
import express.api.model.devices.containers.Container;
import express.api.model.ingredients.Ingredient;
import express.api.utils.validators.ArgumentsValidator;

/**
 * Created by Admin on 2015-02-22.
 */


public class MockContainer extends Container {
    private Ingredient ingredient;

    public MockContainer(String ingredientName, int ingredientType, double containerState) {
        super(ingredientName, ingredientType, containerState);
    }

    public void setIngredient(Ingredient ingredient) {
        ArgumentsValidator.notNull(ingredient);
        this.ingredient = ingredient;
    }

    @Override
    public void perform() throws DeviceException {
        setContainerState(containerState - ingredient.getAmount());
    }

    @Override
    public String getName() {
        return name;
    }
}
