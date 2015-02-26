package tests.express.example.implementation.containers;

import express.api.model.ingredients.Liquid;
import express.example.implementation.containers.LiquidContainer;
import org.junit.Test;

import static org.junit.Assert.*;

public class LiquidContainerTest {

    private LiquidContainer container = new LiquidContainer("Woda", 1000);

    @Test(expected = IllegalArgumentException.class)
    public void testSetNullIngredient() {
        container.setIngredient(null);
    }

    @Test
    public void testPerform() throws Exception {
        Liquid water = new Liquid("Woda");
        water.setAmount(20);

        container.setIngredient(water);
        container.perform();

        assertTrue(container.getContainerState() == 1000 - 20);
    }
}