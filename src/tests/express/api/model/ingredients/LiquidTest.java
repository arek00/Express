package tests.express.api.model.ingredients;

import express.api.model.devices.containers.Container;
import express.api.model.ingredients.Ingredients;
import express.api.model.ingredients.Liquid;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import tests.express.api.model.devices.containers.MockContainer;

import static org.junit.Assert.*;

public class LiquidTest {

    private Container container = new MockContainer("Woda", Ingredients.LIQUID, 2500);
    private Liquid liquidIngredient = (Liquid)container.getIngredient();


    @Test
    public void testSetTemperature(){
        liquidIngredient.setTemperature(75d);
        assertTrue(liquidIngredient.getTemperature() == 75d);
    }

    @Test
    public void testSetPressure() {
        liquidIngredient.setPressure(3.2);
        assertTrue(liquidIngredient.getPressure() == 3.2d);

    }
}