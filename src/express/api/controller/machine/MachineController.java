package express.api.controller.machine;

import express.api.controller.brew.BrewSequence;
import express.api.controller.containers.Container;
import express.api.controller.device.Device;
import express.api.controller.device.Devices;
import express.api.controller.device.DevicesController;
import express.api.exceptions.DeviceException;
import express.api.model.ingredient.Ingredient;
import express.api.model.ingredient.Ingredients;
import express.api.model.recipe.Recipe;
import express.api.model.recipe.Recipes;

import java.util.Collection;
import java.util.Iterator;

/**
 * Singleton.
 * Machine controller is a set of functions that let simplify usage of Express data's model API.
 * Machine controller is facade that contains methods to use basic functionality, mainly on Express' data structure
 * like sets of devices or recipes. It also let performs a brewing strategy.
 *
 * You should take an instance by calling getInstance() method as it is singleton class, there should be only single
 * representation of class in runtime.
 */
public class MachineController {

    private static MachineController instance = new MachineController();

    public static MachineController getInstance() {
        return instance;
    }

    private Devices devices;
    private Ingredients ingredients;
    private Recipes recipes;

    private MachineController() {
        devices = Devices.getInstance();
        ingredients = Ingredients.getInstance();
        recipes = Recipes.getInstance();
    }

    public Ingredient getIngredient(String containerName) {
        return ingredients.getIngredient(containerName);
    }

    public Ingredient getIngredient(Container container) {
        return ingredients.getIngredient(container);
    }

    public Iterator<Ingredient> getIngredients() {
        return ingredients.getIngredients();
    }

    public Recipe getRecipe(int recipeNumber) {
        return recipes.getRecipe(recipeNumber);
    }

    public Iterator<Recipe> getAllRecipes() {
        return recipes.getRecipes();
    }

    public void addRecipe(Recipe recipe) {
        recipes.addRecipe(recipe);
    }

    public void performBrewSequence(BrewSequence sequence) throws DeviceException {
        sequence.perform();
    }

    public void addDevice(Device device) {
        devices.addDevice(device);
    }

    public Device getDevice(String deviceName) {
        return devices.getDeviceByName(deviceName);
    }

    public Iterator<Device> getAllDevices() {
        return devices.getDevices();
    }

}
