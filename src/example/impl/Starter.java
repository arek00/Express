package example.impl;

import example.impl.Sequences.DefaultSequence;
import express.api.model.MachineController;
import express.api.exceptions.DeviceException;

/**
 * Created by Admin on 2015-01-13.
 */
public class Starter {

    public static void main(String args[]) {
        MachineController controller = MachineController.getInstance();

        System.out.println("Inicjalizacja...");
        Initializer initializer = new Initializer();

        try {
            controller.performBrewSequence(new DefaultSequence(controller.getRecipe(0)));
        } catch (DeviceException e) {
            e.printStackTrace();
        }
    }


}
