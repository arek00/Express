package express.api.model.devices.containers;

import express.api.model.devices.Device;
import express.api.model.ingredients.Granular;
import express.api.model.ingredients.Ingredient;
import express.api.model.ingredients.Ingredients;
import express.api.model.ingredients.Liquid;

/**
 * Created by Admin on 2015-02-19.
 */
public abstract class Container implements Device {


    protected String name;
    protected int ingredientType;
    protected String ingredientName;


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
        if (name == null) {
            throw new IllegalArgumentException("Container name can't be null");
        } else if (ingredientType != Ingredients.GRANULAR && ingredientType != Ingredients.LIQUID) {
            throw new IllegalArgumentException("Invalid ingredient type");
        } else if (ingredientName == null) {
            throw new IllegalArgumentException("Ingredient name can't be null");
        }
    }
}
