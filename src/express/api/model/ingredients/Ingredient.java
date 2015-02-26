package express.api.model.ingredients;

import express.api.model.devices.containers.Container;
import express.api.utils.validators.NumbersValidator;

/**
 * Base class of ingredients.
 */
public class Ingredient {

    protected String name;
    protected Container container;
    protected double amount;

    /**
     * @param name Name of ingredient.
     */
    public Ingredient(String name) {
        this.name = name;
        this.amount = 0d;
    }

    /**
     * @return name of ingredient.
     */
    public String getName() {
        return name;
    }

    /**
     * Get current amount of ingredient that will be used in recipe.
     *
     * @return amount of ingredient that must be take to recipe
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Set amount of ingredient that must be use in recipe.
     *
     * @param amount amount of ingredient in milliliters [m] or grams [g]
     */
    public void setAmount(double amount) {
        NumbersValidator.negativeNumber(amount);
        this.amount = amount;
    }

}
