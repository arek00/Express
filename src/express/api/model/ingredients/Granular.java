package express.api.model.ingredients;

import express.api.model.devices.containers.Container;

/**
 * Class is representing granular ingredient.
 * Besides amount it keeps also information about ground consistence of ingredient,
 * if granular ingredient must be grind in grinder.
 */
public class Granular extends Ingredient {

    private boolean grounded;

    /**
     * @param name Name of ingredient.
     */
    public Granular(String name) {
        super(name);
        this.grounded = false;
    }

    /**
     * Get information about ingredient is already grounded.
     *
     * @return Logical value if ingredient is grounded or not.
     */
    public boolean isGrounded() {
        return this.grounded;
    }

    /**
     * Set parameter if granular ingredient is grounded.
     * Negative means that ingredient will be grind by grinder.
     */
    public void setGrounded(boolean isGrounded) {
        this.grounded = isGrounded;
    }

    @Override
    public String toString() {
        return String.format("%s : %.2f g.", getName(), getAmount());
    }

}
