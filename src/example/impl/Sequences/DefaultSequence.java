package example.impl.Sequences;

import example.impl.Devices.Grinder;
import example.impl.DevicesIds;
import express.api.model.devices.sequences.BrewSequence;
import express.api.model.devices.Device;
import express.api.model.MachineController;
import express.api.exceptions.DeviceException;
import express.api.model.ingredients.Granular;
import express.api.model.ingredients.Ingredient;
import express.api.model.recipes.Recipe;

import java.util.Collection;

/**
 * Created by Admin on 2015-01-13.
 */
public class DefaultSequence implements BrewSequence {

    private MachineController controller = MachineController.getInstance();


    private Recipe recipe;

    public DefaultSequence(Recipe recipe) {
        this.recipe = recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public void perform() throws DeviceException {

        System.out.println("Wykonywanie napoju: ");

        System.out.println("Dodawanie składników: ");
        getIngredientsFromContainer(recipe.getIngredients());

        System.out.println("Mielenie: ");
        grind(recipe.getIngredients());

        System.out.println("Dodawanie dodatków: ");
        getIngredientsFromContainer(recipe.getAdditives());

        System.out.println("Nalewanie: ");
        dispense();
    }


    private void getIngredientsFromContainer(Collection<Ingredient> ingredients) throws DeviceException {
        for (Ingredient ingredient : ingredients) {
            Device device = controller.getDevice(ingredient.getContainerId());
            device.perform();
        }
    }

    private void grind(Collection<Ingredient> ingredients) throws DeviceException {

        for (Ingredient ingredient : ingredients) {
            if (ingredient instanceof Granular) {
                performGrind((Granular) ingredient);
            }
        }

    }

    private void dispense() throws DeviceException {
        Device device = controller.getDevice(DevicesIds.DISPENSER.getValue());
        device.perform();
    }

    private void performGrind(Granular granular) throws DeviceException {
        if (!granular.isGrounded()) {
            Device device = controller.getDevice(DevicesIds.GRINDER.getValue());
            ((Grinder) device).setIngredient(granular);
            device.perform();
        }
    }

}
