package express.api.controller.containers;

import express.api.controller.device.Device;
import express.api.model.ingredient.Ingredient;

/**
 * Created by Admin on 2015-02-19.
 */
public abstract class Container implements Device {

    protected String name;
    protected Ingredient ingredient;


    public Container(String name, Ingredient ingredient) {
        this.name = name;
        this.ingredient = ingredient;
    }

    /**
     * Get an instance that representing an ingredient's properties.
     *
     * @return Ingredient that is keeping in current container.
     */
    public Ingredient getIngredient() {
        return this.ingredient;
    }

}
