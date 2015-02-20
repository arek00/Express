package express.api.controller.machine;

import express.api.controller.brew.BrewSequence;
import express.api.controller.device.Device;
import express.api.controller.device.DevicesController;
import express.api.exceptions.DeviceException;
import express.api.model.ingredient.Ingredient;
import express.api.model.ingredient.Ingredients;
import express.api.model.recipe.Recipe;
import express.api.model.recipe.RecipeMaker;
import express.api.model.recipe.Recipes;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by Admin on 2014-12-14.
 */
public class MachineController {

    private static MachineController instance = new MachineController();

    public static MachineController getInstance() {
        return instance;
    }


    private DevicesController devicesController;
    private Ingredients ingredients;
    private Recipes recipes;

    private MachineController() {
        devicesController = DevicesController.getInstance();
        ingredients = Ingredients.getInstance();
        recipes = Recipes.getInstance();
    }

    public Ingredient getIngredient(int containerId) {
        return ingredients.getIngredient(containerId);
    }

    public Collection<Ingredient> getAllIngredients() {
        return ingredients.getAllIngredients();
    }

    public void addIngredient(Ingredient ingredient) {
        ingredients.addIngredient(ingredient);
    }

    public Recipe getRecipe(int recipeNumber) {
        return recipes.getRecipe(recipeNumber);
    }

    public Collection<Recipe> getAllRecipes() {
        return recipes.getAllRecipes();
    }

    public void addRecipe(Recipe recipe) {
        recipes.addRecipe(recipe);
    }

    public void performBrewSequence(BrewSequence sequence) throws DeviceException {
        sequence.perform();
    }

    public void addDevice(Device device) {
        devicesController.addDevice(device);
    }

    public Device getDevice(int deviceId) {
        return devicesController.getDeviceById(deviceId);
    }

    public Collection<Device> getAllDevices() {
        return devicesController.getAllDevices();
    }

}
