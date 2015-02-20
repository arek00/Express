package tests.express.api.model.ingredient;

import express.api.model.ingredient.Granular;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class GranularTest {

    private static Granular granular;

    @BeforeClass
    public static void init() {
        granular = new Granular("Kawa", 17);
    }

    @Test
    public void testGrounded() {
        granular.setGrounded(false);
        assertFalse(granular.isGrounded());

    }

}