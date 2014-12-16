package example.implementation.devices;

import example.implementation.Exceptions.LackOfIngredientException;
import example.implementation.Exceptions.WrongIngredientInContainerException;
import express.api.controller.device.Device;
import express.api.controller.machine.MachineController;
import express.api.model.ingredient.Ingredient;

/**
 * Created by Admin on 2014-12-16.
 */
public class Container extends Device{

    private int state;
    private Ingredient ingredient;

    public Container(int containerId, int containerState)
    {
        super(containerId);
        this.ingredient = MachineController.getInstance().getIngredient(containerId);
    }

    public void setIngredient(Ingredient ingredient) throws WrongIngredientInContainerException {
        if(ingredient.getContainerId() == getDeviceId()) {
            this.ingredient = ingredient;
        }
        else{
            throw new WrongIngredientInContainerException("Try to set wrong ingredient to container.");
        }
    }




    @Override
    public void operate() throws LackOfIngredientException {
        if(state - ingredient.getAmount() < 0)
        {
            throw new LackOfIngredientException("Not enough ingredient in container");
        }
        else
        {
            state -= ingredient.getAmount();
            System.out.println("Pobrano " + ingredient.getAmount() + " składnika.");
        }
    }
}
