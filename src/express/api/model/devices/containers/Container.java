package express.api.model.devices.containers;

import express.api.model.devices.Device;
import express.api.model.ingredients.Granular;
import express.api.model.ingredients.Ingredient;
import express.api.model.ingredients.Ingredients;
import express.api.model.ingredients.Liquid;
import express.api.utils.validators.ArgumentsValidator;
import express.api.utils.validators.NumbersValidator;

/**
 * Abstract implementation for devices that going to be using like containers.
 * Every container-like device representation should extends this class and implements their functionality
 * like taking ingredient from it.
 */
public abstract class Container implements Device {

    protected String name;
    protected String ingredientName;
    protected double containerState;
    protected int ingredientType;

    /**
     * @param ingredientName Name of ingredient that is stored in container. Name of container become the same as ingredient
     * @param ingredientType Liquid or granular kind of ingredient. Use Ingredients' class final variables to choose that.
     */
    public Container(String ingredientName, int ingredientType) {
        this(ingredientName, ingredientName, ingredientType, 0);
    }

    /**
     * @param ingredientName Name of ingredient that is stored in container. Name of container become the same as ingredient
     * @param ingredientType Liquid or granular kind of ingredient. Use Ingredients' class final variables to choose that.
     * @param containerState Amount of ingredient in container in milliliters or grams.
     */
    public Container(String ingredientName, int ingredientType, double containerState) {
        this(ingredientName, ingredientName, ingredientType, containerState);
    }

    /**
     * @param name           Name that describe container.
     * @param ingredientName Name of ingredient that is stored in container.
     * @param ingredientType Liquid or granular kind of ingredient. Use Ingredients' class final variables to choose that.
     */
    public Container(String name, String ingredientName, int ingredientType) {
        this(name, ingredientName, ingredientType, 0);
    }

    /**
     * @param name           Name that describe container.
     * @param ingredientName Name of ingredient that is stored in container.
     * @param ingredientType Liquid or granular kind of ingredient. Use Ingredients' class final variables to choose that.
     * @param containerState Amount of ingredient in container in milliliters or grams.
     */
    public Container(String name, String ingredientName, int ingredientType, double containerState) {
        validateArguments(name, ingredientName, ingredientType, containerState);

        this.name = name;
        this.ingredientType = ingredientType;
        this.ingredientName = ingredientName;
        this.containerState = containerState;
    }

    /**
     * Get an instance that representing an ingredient's properties.
     *
     * @return Ingredient that is keeping in current container.
     */
    public Ingredient getIngredient() {
        if (ingredientType == Ingredients.LIQUID) {
            return new Liquid(this.ingredientName);
        } else if (ingredientType == Ingredients.GRANULAR) {
            return new Granular(this.ingredientName);
        } else {
            return new Ingredient(this.ingredientName);
        }
    }

    /**
     * @return Amount of ingredient in this container in milliliters or grams.
     */
    public double getContainerState() {
        return containerState;
    }

    /**
     * @param containerState Set amount of ingredient in container in milliliters or grams.
     */
    public void setContainerState(double containerState) {
        NumbersValidator.negativeNumber(containerState);
        this.containerState = containerState;
    }

    private void validateArguments(String name, String ingredientName, int ingredientType, double containerState) {
        ArgumentsValidator.nullArgument(name);
        ArgumentsValidator.nullArgument(ingredientName);
        ArgumentsValidator.nullArgument(ingredientType);
        ArgumentsValidator.emptyString(name);
        ArgumentsValidator.emptyString(ingredientName);
        NumbersValidator.negativeNumber(containerState);
        validateIngredientType(ingredientType);
    }

    private void validateIngredientType(int ingredientType) {
        if (!(ingredientType == Ingredients.GRANULAR || ingredientType == Ingredients.LIQUID)) {
            throw new IllegalArgumentException("Wrong given ingredient type.");
        }
    }
}
