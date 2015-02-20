package tests.express.api.model.ingredient;

import express.api.model.ingredient.Liquid;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class LiquidTest {

    private static Liquid liquid;
    private int temperature = 10;
    private int pressure = 15;


    @BeforeClass
    public static void init() {
        liquid = new Liquid("Woda", 1);
    }

    @Test
    public void shouldSetValues() {
        liquid.setTemperature(temperature);
        liquid.setPressure(pressure);

        assertEquals(temperature, liquid.getTemperature());
        assertEquals(pressure, liquid.getPressure());
    }

    @Test
    public void shouldGetValues() {
        int returnedTemperature = 0;
        int returnedPressure = 0;

        liquid.setTemperature(temperature);
        liquid.setPressure(pressure);

        returnedTemperature = liquid.getTemperature();
        returnedPressure = liquid.getPressure();

        assertEquals(temperature, returnedTemperature);
        assertEquals(pressure, returnedPressure);

    }


}