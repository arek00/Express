package tests.express.example.implementation.containers;

import express.api.exceptions.DeviceException;
import express.api.model.devices.containers.Container;
import express.api.model.ingredients.Granular;
import express.api.model.ingredients.Ingredient;
import express.example.implementation.containers.GranularContainer;
import express.example.implementation.exceptions.IngredientInContainerNotSet;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class GranularContainerTest {

    private static GranularContainer granularContainer;

    @BeforeClass
    public static void init() {
        granularContainer = new GranularContainer("TEST", 2000);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testSetIngredient() throws DeviceException {
        Ingredient ingredient = new Granular("Cukier");
        granularContainer.setIngredient(ingredient);
        granularContainer.perform();

        granularContainer.setIngredient(null);

    }

    @Test(expected = IngredientInContainerNotSet.class)
    public void testPerformThrowsError() throws DeviceException {
        Container granularContainer2 = new GranularContainer("Cukier", 10000);

        granularContainer2.perform();
    }

    @Test
    public void testPerform() throws DeviceException {
        GranularContainer granularContainer2 = new GranularContainer("Cukier", 10000);
        Ingredient ingredient = new Granular("Cukier");
        ingredient.setAmount(450);

        granularContainer2.setIngredient(ingredient);
        granularContainer2.perform();

        assertTrue(granularContainer2.getContainerState() == 10000 - 450);
    }


}