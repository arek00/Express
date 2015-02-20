package example.impl;

import example.impl.Devices.Container;
import example.impl.Devices.Dispenser;
import example.impl.Devices.Grinder;
import express.api.controller.device.Device;
import express.api.controller.machine.MachineController;
import express.api.model.ingredient.Granular;
import express.api.model.ingredient.Ingredient;
import express.api.model.ingredient.Liquid;
import express.api.model.recipe.RecipeMaker;

/**
 * Created by Admin on 2015-01-13.
 */
public class Initializer {
    //initialization simple express with grinder, dispenser and 3 containers

    private Ingredient milk = new Liquid("Mleko", DevicesIds.MILK_CONTAINER.getValue());
    private Ingredient coffee = new Granular("Kawa", DevicesIds.COFFEE_CONTAINER.getValue());
    private Ingredient sugar = new Granular("Cukier", DevicesIds.SUGAR_CONTAINER.getValue());

    private Device milkContainer = new Container(milk, 100, DevicesIds.MILK_CONTAINER.getValue());
    private Device coffeeContainer = new Container(coffee, 100, DevicesIds.COFFEE_CONTAINER.getValue());
    private Device sugarContainer = new Container(sugar, 100, DevicesIds.SUGAR_CONTAINER.getValue());
    private Device grinder = new Grinder(DevicesIds.GRINDER.getValue());
    private Device dispenser = new Dispenser(DevicesIds.DISPENSER.getValue());

    private MachineController controller = MachineController.getInstance();

    public Initializer() {
        initialize();
    }

    public void initialize() {
        initializeDevices();
        addIngredients();
        addRecipes();
    }

    private void initializeDevices() {
        controller.addDevice(milkContainer);
        controller.addDevice(coffeeContainer);
        controller.addDevice(sugarContainer);
        controller.addDevice(grinder);
        controller.addDevice(dispenser);
    }

    private void addIngredients() {
        controller.addIngredient(milk);
        controller.addIngredient(coffee);
        controller.addIngredient(sugar);
    }

    private void addRecipes() {

        RecipeMaker recipeMaker = RecipeMaker.getInstance();
        recipeMaker.addIngredient(milk);
        recipeMaker.addAdditive(sugar);

        controller.addRecipe(recipeMaker.createRecipe());
        recipeMaker.clearRecipe();

        recipeMaker.addIngredient(coffee);
        recipeMaker.addAdditive(milk);
        controller.addRecipe(recipeMaker.createRecipe());
    }

}
