package tests.express.api.model.devices.containers;

import express.api.exceptions.DeviceException;
import express.api.model.devices.containers.Container;
import express.api.model.ingredients.Granular;
import express.api.model.ingredients.Ingredient;
import express.api.model.ingredients.Ingredients;
import express.api.model.ingredients.Liquid;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContainerTest {

    private static Container container1;
    private static Container container2;

    @BeforeClass
    public static void init() {
        container1 = new MockContainer("Mleko", Ingredients.LIQUID, 2000);
        container2 = new MockContainer("Kawa", Ingredients.GRANULAR, 1500);
    }


    @Test
    public void testGetIngredient() {
        Ingredient ingredient = container1.getIngredient();
        assertTrue(ingredient instanceof Liquid);
        assertTrue(ingredient.getName().equals(container1.getName()));


        ingredient = container2.getIngredient();
        assertTrue(ingredient instanceof Granular);
        assertTrue(ingredient.getName().equals(container2.getName()));
    }

    @Test
    public void testSetContainerState() {
        container1.setContainerState(2000);
        container2.setContainerState(1500);

        assertTrue(container1.getContainerState() == 2000);
        assertTrue(container2.getContainerState() == 1500);

        container1.setContainerState(1100);
        container2.setContainerState(2500);

        assertTrue(container1.getContainerState() == 1100);
        assertTrue(container2.getContainerState() == 2500);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetContainerStateValidation() {
        container1.setContainerState(-1500);
    }

    @Test
    public void testPerform() {
        double amount1, amount2;

        Ingredient ingredient1, ingredient2;
        ingredient1 = container1.getIngredient();
        ingredient1.setAmount(150);
        ingredient2 = container2.getIngredient();
        ingredient2.setAmount(350);

        ((MockContainer)container1).setIngredient(ingredient1);
        ((MockContainer)container2).setIngredient(ingredient2);

        amount1 = container1.getContainerState();
        amount2 = container2.getContainerState();

        try {
            container1.perform();
            container2.perform();
        } catch (DeviceException e) {
            System.err.println(e.getMessage());
        }

        assertTrue(amount1 == container1.getContainerState() + 150d);
        assertTrue(amount2 == container2.getContainerState() + 350d);
    }

}
