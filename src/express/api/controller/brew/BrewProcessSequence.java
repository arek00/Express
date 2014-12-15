package express.api.controller.brew;

import express.api.controller.device.DevicesController;
import express.api.model.recipe.Recipe;

/**
 * Created by Admin on 2014-12-14.
 */
public abstract class BrewProcessSequence {

    private DevicesController controller;
    private Recipe recipe;

    public BrewProcessSequence(DevicesController controller, Recipe recipe)
    {
        this.controller = controller;
    }

    public abstract void perform();

}
