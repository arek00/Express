package tests.example.impl;

import example.impl.Initializer;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class InitializerTest {

    private static Initializer initializer;

    @BeforeClass
    public static void init()
    {
        initializer = new Initializer();
    }

    @Test
    public void recipesShouldHasIngredients()
    {

    }


}