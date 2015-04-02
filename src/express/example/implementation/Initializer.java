package express.example.implementation;

import express.api.model.MachineController;
import express.api.model.ingredients.Granular;
import express.api.model.ingredients.Liquid;
import express.api.model.recipes.Recipe;
import express.api.model.recipes.RecipeMaker;
import express.api.model.recipes.Recipes;
import express.example.implementation.containers.GranularContainer;
import express.example.implementation.containers.LiquidContainer;
import express.example.implementation.devices.*;
import express.example.implementation.sequences.DefaultSequence;

/**
 *
 */
public class Initializer {

    public void initialize() {
        addDevices();
        addContainers();
        createRecipe();
    }

    private void addDevices() {
        MachineController expressController = MachineController.getInstance();
        expressController.addDevice(new Heater("Grzałka wody"));
        expressController.addDevice(new PressurePad("Czujnik kubka"));
        expressController.addDevice(new Grinder("Młynek"));
        expressController.addDevice(new Pump("Pompa wody"));
        expressController.addDevice(new Dispenser("Podajnik"));

    }

    private void addContainers() {
        MachineController expressController = MachineController.getInstance();

        expressController.addContainer(new LiquidContainer("Woda", 2000));
        expressController.addContainer(new LiquidContainer("Mleko", 2000));
        expressController.addContainer(new GranularContainer("Cukier", 1000));
        expressController.addContainer(new GranularContainer("Kawa", 1000));
    }


    private void createRecipe() {
        MachineController expressController = MachineController.getInstance();

        Granular granular;
        Liquid liquid;

        Recipe recipe;
        RecipeMaker maker = RecipeMaker.getInstance();

        granular = (Granular) expressController.getContainer("Kawa").getIngredient();
        granular.setGrounded(false);
        granular.setAmount(150);

        maker.addIngredient(granular);

        liquid = (Liquid) expressController.getContainer("Woda").getIngredient();
        liquid.setTemperature(35d);
        liquid.setPressure(1.2d);
        liquid.setAmount(250);

        maker.setName("Zwykła Kawa");
        maker.addIngredient(liquid);


        Recipes.getInstance().addRecipe(maker.createRecipe());
        maker.clearRecipe();
    }

}
