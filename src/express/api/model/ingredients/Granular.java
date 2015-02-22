package express.api.model.ingredients;

import express.api.model.devices.containers.Container;

/**
 * Created by Admin on 2014-12-14.
 */
public class Granular extends Ingredient {

    private boolean grounded;

    public Granular(String name, Container container) {
        super(name, container);
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
     * Set parameter if granular ingredient is/isn't grounded.
     */
    public void setGrounded(boolean isGrounded) {
        this.grounded = isGrounded;
    }

}
