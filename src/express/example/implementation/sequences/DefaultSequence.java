package express.example.implementation.sequences;

import express.api.exceptions.DeviceException;
import express.api.model.MachineController;
import express.api.model.devices.Device;
import express.api.model.devices.sequences.BrewSequence;
import express.api.model.ingredients.Granular;
import express.api.model.ingredients.Ingredient;
import express.api.model.ingredients.Liquid;
import express.api.model.recipes.Recipe;
import express.api.utils.validators.ArgumentsValidator;
import express.example.implementation.devices.Heater;
import express.example.implementation.devices.Pump;

import java.util.Iterator;

/**
 * Created by Admin on 2015-02-24.
 */
public class DefaultSequence implements BrewSequence {

    private MachineController controller = MachineController.getInstance();
    private Recipe recipe;


    public void setRecipe(Recipe recipe) {
        ArgumentsValidator.nullArgument(recipe);
        this.recipe = recipe;
    }

    /*
    Get ingrediences
    grind what need
    heat water
    pump
    add additives
    dispense
     */

    @Override
    public void perform() throws DeviceException {
        prepareIngredients(recipe.getIngredients());
        dispenseIngredients();
        prepareIngredients(recipe.getAdditives());
        addAdditives();

    }

    private void prepareIngredients(Iterator<Ingredient> ingredients) throws DeviceException {
        Iterator<Ingredient> ingredientIterator = recipe.getIngredients();

        while (ingredientIterator.hasNext()) {
            Ingredient ingredient = ingredientIterator.next();

            if (ingredient instanceof Granular) {
                granularIngredientService((Granular) ingredient);
            } else if (ingredient instanceof Liquid) {
                liquidIngredientService((Liquid) ingredient);
            }
        }
    }

    private void dispenseIngredients() {
        Device dispenser = controller.getDevice("Podajnik");
        
    }


    private void addAdditives() {

    }


    private void granularIngredientService(Granular granular) throws DeviceException {
        if (!granular.isGrounded()) {
            Device device = controller.getDevice("Młynek");
            device.perform();
        }
    }

    private void liquidIngredientService(Liquid liquid) throws DeviceException {

        Device heater = controller.getDevice("Grzałka wody");
        Device pump = controller.getDevice("Pompa wody");

        ((Heater) heater).setTemperature(liquid.getTemperature());
        heater.perform();

        ((Pump) pump).setPressure(liquid.getPressure());
        pump.perform();

    }

}
