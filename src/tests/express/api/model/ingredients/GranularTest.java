package tests.express.api.model.ingredients;

import express.api.model.devices.containers.Container;
import express.api.model.ingredients.Granular;
import express.api.model.ingredients.Ingredients;
import org.junit.Test;
import tests.express.api.model.devices.containers.MockContainer;

import static org.junit.Assert.*;

public class GranularTest {

    Container container = new MockContainer("Kawa", Ingredients.GRANULAR, 1000);
    Granular granular = (Granular) container.getIngredient();

    @Test
    public void testIsGrounded() {
        granular.setGrounded(true);

        assertTrue(granular.isGrounded());
    }
}