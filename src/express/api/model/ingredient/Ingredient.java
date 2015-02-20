package express.api.model.ingredient;

import express.api.controller.containers.Container;

/**
 * Created by Admin on 2014-12-14.
 */
public class Ingredient {

    protected String name;
    protected Container container;
    protected int amount;

    public Ingredient(String name, int containerId) {
        this.name = name;
        this.amount = 0;
    }

    /**
     * @return name of ingredient.
     */
    public String getName() {
        return name;
    }

    /**
     * Get reference to container that stores this ingredient.
     *
     * @return reference of container
     */
    public Container getContainer() {
        return container;
    }

    /**
     * Get current amount of ingredient that will be used in recipe.
     *
     * @return amount of ingredient that must be take to recipe
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Set amount of ingredient that must be use in recipe.
     *
     * @param amount Amount of ingredient in recipe
     */
    public void setAmount(int amount) {
        validationAmount(amount);
        this.amount = amount;
    }


    protected void validationAmount(int arg) {
        if (arg < 0) {
            throw new IllegalArgumentException("Amount can't be less than 0");
        }
    }

}
