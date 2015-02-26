package express.api.model.devices.sequences;

import express.api.exceptions.DeviceException;
import express.api.model.recipes.Recipe;

/**
 * Interface that describe strategy of brewing process.
 */
public interface BrewSequence {
    /**
     * Performing operation of brewing.
     *
     * @throws DeviceException
     */
    public void perform() throws DeviceException;

    /**
     * Set recipe that will be use in process of brewing.
     *
     * @param recipe recipe to brew
     */
    public void setRecipe(Recipe recipe);
}
