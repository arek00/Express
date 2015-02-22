package express.api.model;

import express.api.model.devices.containers.Containers;
import express.api.model.devices.sequences.BrewSequence;
import express.api.model.devices.containers.Container;
import express.api.model.devices.Device;
import express.api.model.devices.Devices;
import express.api.exceptions.DeviceException;
import express.api.model.ingredients.Ingredient;
import express.api.model.ingredients.Ingredients;
import express.api.model.recipes.Recipe;
import express.api.model.recipes.Recipes;

import java.util.Iterator;

/**
 * Singleton.
 * Machine controller is a set of functions that let simplify usage of Express data's model API.
 * Machine controller is <b>facade</b> that contains methods to use basic functionality, mainly on Express' data structure
 * like sets of devices or recipes. It also let performs a brewing strategy.
 * <p/>
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
    private Containers containers;

    private MachineController() {
        devices = Devices.getInstance();
        ingredients = Ingredients.getInstance();
        recipes = Recipes.getInstance();
        containers = Containers.getInstance();
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
        return devices.getDevice(deviceName);
    }

    public void addContainer(Container container) {
        containers.addContainer(container);
    }

    public Container getContainer(String containerName) {
        return containers.getContainer(containerName);
    }

    public void removeContainer(String containerName) {
        containers.removeContainer(containerName);
    }

    public void removeContainer(Container container) {
        containers.removeContainer(container);
    }


    public Iterator<Device> getAllDevices() {
        return devices.getDevices();
    }

}
