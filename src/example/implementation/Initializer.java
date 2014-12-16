package example.implementation;

import example.implementation.devices.Container;
import example.implementation.devices.Dispenser;
import example.implementation.devices.Grinder;
import express.api.controller.machine.MachineController;
import express.api.model.ingredient.Granular;
import express.api.model.ingredient.Ingredient;
import express.api.model.ingredient.Liquid;
import express.api.model.recipe.Recipe;

import java.util.ArrayList;

/**
 * Created by Admin on 2014-12-16.
 */
public class Initializer {

    public static void initialize()
    {
        MachineController controller = MachineController.getInstance();

        controller.addDevice(new Container(1,100));
        controller.addDevice(new Container(2,90));
        controller.addDevice(new Container(3,75));

        controller.addDevice(new Grinder(4));
        controller.addDevice(new Dispenser(5));

        controller.addIngredient(new Granular("Kawa",1));
        controller.addIngredient(new Liquid("Woda",2));
        controller.addIngredient(new Liquid("Mleko",3));

        ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
        ingredients.add(controller.getIngredient(1));
        ingredients.add(controller.getIngredient(2));

        ArrayList<Ingredient> additives = new ArrayList<Ingredient>();
        additives.add(controller.getIngredient(3));

        Recipe recipe = new Recipe(ingredients,additives);
        controller.addRecipe(recipe);




    }

}
