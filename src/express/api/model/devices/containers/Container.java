package express.api.model.devices.containers;

import express.api.model.devices.Device;
import express.api.model.ingredients.Granular;
import express.api.model.ingredients.Ingredient;
import express.api.model.ingredients.Ingredients;
import express.api.model.ingredients.Liquid;
import express.api.utils.validators.ArgumentsValidator;

/**
 * Abstract implementation for devices that going to be using like containers.
 * Every container-like device representation should extends this class and implements their functionality
 * like taking ingredient from it.
 */
public abstract class Container implements Device {


    protected String name;
    protected int ingredientType;
    protected String ingredientName;

    /**
     * @param name           Name that describe container.
     * @param ingredientName Name of ingredient that is stored in container.
     * @param ingredientType Liquid or granular kind of ingredient. Use Ingredients' class final variables to choose that.
     */
    public Container(String name, String ingredientName, int ingredientType) {
        validateArguments(name, ingredientName, ingredientType);
        
        this.name = name;
        this.ingredientType = ingredientType;
        this.ingredientName = ingredientName;
    }

    /**
     * Get an instance that representing an ingredient's properties.
     *
     * @return Ingredient that is keeping in current container.
     */
    public Ingredient getIngredient() {
        if (ingredientType == Ingredients.LIQUID) {
            return new Liquid(this.ingredientName, this);
        } else if (ingredientType == Ingredients.GRANULAR) {
            return new Granular(this.ingredientName, this);
        } else {
            return new Ingredient(this.ingredientName, this);
        }
    }

    private void validateArguments(String name, String ingredientName, int ingredientType) {
        ArgumentsValidator.nullArgument(name);
        ArgumentsValidator.nullArgument(ingredientName);
        ArgumentsValidator.nullArgument(ingredientType);
        ArgumentsValidator.emptyString(name);
        ArgumentsValidator.emptyString(ingredientName);
        validateIngredientType(ingredientType);
    }

    private void validateIngredientType(int ingredientType) {
        if (!(ingredientType == Ingredients.GRANULAR || ingredientType == Ingredients.LIQUID)) {
            throw new IllegalArgumentException("Wrong given ingredient type.");
        }
    }
}
