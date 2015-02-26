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
import express.api.model.recipes.RecipeMaker;
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
    private BrewSequence brewStrategy;
    private RecipeMaker recipeMaker;

    private MachineController() {
        devices = Devices.getInstance();
        ingredients = Ingredients.getInstance();
        recipes = Recipes.getInstance();
        containers = Containers.getInstance();
        recipeMaker = RecipeMaker.getInstance();
    }

    public void addIngredientToMaker(Ingredient ingredient) {
        recipeMaker.addIngredient(ingredient);
    }

    /**
     * Add ingredient to current selected ingredients in maker.
     *
     * @param ingredient ingredient to add to recipe maker
     */
    public void addAdditiveToMaker(Ingredient ingredient) {
        recipeMaker.addAdditive(ingredient);
    }

    /**
     * Create recipe from given before ingredients and additives.
     *
     * @return recipe
     */
    public Recipe createRecipe() {
        return recipeMaker.createRecipe();
    }

    /**
     * Get iterator to selected ingredients.
     *
     * @return Iterator to ingredients
     */
    public Iterator<Ingredient> getAllIngredientsFromMaker() {
        return recipeMaker.getAllIngredients();
    }

    /**
     * Get iterator to selected additives
     *
     * @return
     */
    public Iterator<Ingredient> getAllAdditivesFromMaker() {
        return recipeMaker.getAllAdditives();
    }

    /**
     * Get iterator to all ingredients currently stored in containers.
     *
     * @return Iterator to ingredients.
     */
    public Iterator<Ingredient> getIngredients() {
        return ingredients.getIngredients();
    }

    /**
     * Get recipe from given index.
     *
     * @param recipeNumber index of recipe.
     * @return recipe
     */
    public Recipe getRecipe(int recipeNumber) {
        return recipes.getRecipe(recipeNumber);
    }

    /**
     * Get iterator to all recipes currently stored in express.
     *
     * @return Iterator to all recipes set.
     */
    public Iterator<Recipe> getAllRecipes() {
        return recipes.getRecipes();
    }

    /**
     * Add recipe to set of recipes.
     *
     * @param recipe Recipe to add
     */
    public void addRecipe(Recipe recipe) {
        recipes.addRecipe(recipe);
    }

    /**
     * Set strategy to perform brewing process.
     *
     * @param brewStrategy strategy of brewing
     */
    public void setBrewStrategy(BrewSequence brewStrategy) {
        this.brewStrategy = brewStrategy;
    }

    /**
     * Commision of performing recipe by set strategy in order to brew coffee.
     *
     * @param recipe Recipe to brew
     * @throws DeviceException
     */
    public void performBrewSequence(Recipe recipe) throws DeviceException {
        brewStrategy.setRecipe(recipe);
        brewStrategy.perform();
    }

    /**
     * Add device to express.
     *
     * @param device Instance of class implementing device interface.
     */
    public void addDevice(Device device) {
        devices.addDevice(device);
    }

    /**
     * Get device from set by its name.
     *
     * @param deviceName Name of device.
     * @return Instance of device.
     */
    public Device getDevice(String deviceName) {
        return devices.getDevice(deviceName);
    }

    /**
     * Add container to express.
     *
     * @param container Instance of class that extends Container class.
     */
    public void addContainer(Container container) {
        containers.addContainer(container);
    }

    /**
     * Get container by given name.
     *
     * @param containerName Name of container.
     * @return Instance of container.
     */
    public Container getContainer(String containerName) {
        return containers.getContainer(containerName);
    }

    /**
     * Remove container by name
     *
     * @param containerName Name of container.
     */
    public void removeContainer(String containerName) {
        containers.removeContainer(containerName);
    }

    /**
     * Remove container by instance of itself.
     *
     * @param container Instance of container that must be removed
     */
    public void removeContainer(Container container) {
        containers.removeContainer(container);
    }


    /**
     * Get all registered devices.
     *
     * @return Iterator to devices.
     */
    public Iterator<Device> getAllDevices() {
        return devices.getDevices();
    }

    /**
     * Get all registered containers
     *
     * @return Iterator to containers.
     */
    public Iterator<Container> getAllContainers() {
        return containers.getContainers();
    }

}
