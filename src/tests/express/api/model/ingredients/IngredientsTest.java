package tests.express.api.model.ingredients;

import express.api.model.devices.containers.Container;
import express.api.model.devices.containers.Containers;
import express.api.model.ingredients.Granular;
import express.api.model.ingredients.Ingredient;
import express.api.model.ingredients.Ingredients;
import express.api.model.ingredients.Liquid;
import express.api.utils.converters.IteratorConverter;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import tests.express.api.model.devices.containers.MockContainer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

public class IngredientsTest {

    private static Ingredients ingredients = Ingredients.getInstance();
    private static Containers containers = Containers.getInstance();

    @BeforeClass
    public static void init() {
        clear();

        containers.addContainer(new MockContainer("Mleko", Ingredients.LIQUID, 2000));
        containers.addContainer(new MockContainer("Mleko w proszku", Ingredients.GRANULAR, 2000));
        containers.addContainer(new MockContainer("Woda", Ingredients.LIQUID, 2000));
    }

    @Test
    public void testGetIngredients() {

        Iterator<Ingredient> ingredientIterator = ingredients.getIngredients();
        Ingredient entity;

        entity = ingredientIterator.next();


    }


    /**
     * That's what happens when you use singletons. Don't do it again.
     */
    private static void clear() {
        Iterator<Container> containerIterator = containers.getContainers();
        List<Container> containersList = new ArrayList<Container>();

        containersList.addAll(IteratorConverter.toCollection(containerIterator));

        for (Container each : containersList) {
            containers.removeContainer(each);
        }

        containersList.clear();
    }
}