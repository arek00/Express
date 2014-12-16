package express.api.controller.machine;

import express.api.controller.brew.BrewProcessSequence;
import express.api.controller.brew.BrewSequencePerformer;
import express.api.controller.device.Device;
import express.api.controller.device.DevicesController;
import express.api.model.ingredient.Ingredient;
import express.api.model.ingredient.IngredientsSet;
import express.api.model.recipe.Recipe;
import express.api.model.recipe.RecipeMaker;
import express.api.model.recipe.RecipesSet;

import java.util.Iterator;

/**
 * Created by Admin on 2014-12-14.
 */
public class MachineController {

    private static MachineController instance = new MachineController();

    public static MachineController getInstance()
    {
        return instance;
    }
    private MachineController()
    {
        ingredientsSet = IngredientsSet.getInstance();
        recipesSet = RecipesSet.getInstance();
        recipeMaker = RecipeMaker.getInstance();
        brewSequencePerformer = BrewSequencePerformer.getInstance();
        devicesController = DevicesController.getInstance();
    }


    private IngredientsSet ingredientsSet;
    private RecipesSet recipesSet;
    private RecipeMaker recipeMaker;
    private BrewSequencePerformer brewSequencePerformer;
    private DevicesController devicesController;


    public Ingredient getIngredient(int containerId)
    {
        return ingredientsSet.getIngredient(containerId);
    }

    public Iterator<Ingredient> getAllIngredients()
    {
        return ingredientsSet.getAllIngredients();
    }

    public void addIngredient(Ingredient ingredient)
    {
        ingredientsSet.addIngredient(ingredient);
    }

    public Recipe getRecipe(int recipeNumber)
    {
        return recipesSet.getRecipe(recipeNumber);
    }

    public Iterator<Recipe> getAllRecipes()
    {
        return recipesSet.getAllRecipes();
    }

    public void addRecipe(Recipe recipe)
    {
        recipesSet.addRecipe(recipe);
    }

    public void performBrewProcessSequence(BrewProcessSequence sequence)
    {
        sequence.perform();
    }

    public void addDevice(Device device)
    {
        devicesController.addDevice(device);
    }

    public Device getDevice(int deviceId)
    {
        return devicesController.getDeviceById(deviceId);
    }

    public Iterator<Device> getAllDevices()
    {
        return devicesController.getAllDevices();
    }


}
