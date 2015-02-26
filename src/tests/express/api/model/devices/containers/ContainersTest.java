package tests.express.api.model.devices.containers;

import express.api.model.devices.containers.Container;
import express.api.model.devices.containers.Containers;
import express.api.model.ingredients.Ingredients;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class ContainersTest {

    private static Containers containers;
    private static Container container1;
    private static Container container2;
    private static Container container3;

    @BeforeClass
    public static void init() {
        containers = Containers.getInstance();

        container1 = new MockContainer("Mleko", Ingredients.LIQUID, 1568);
        container2 = new MockContainer("Kawa", Ingredients.GRANULAR, 552);
        container3 = new MockContainer("Woda", Ingredients.LIQUID, 10000);
    }


    @Before
    public void restore() {
        if (!containers.containsContainer(container1.getName())) {
            containers.addContainer(container1);
        }
        if (!containers.containsContainer(container2.getName())) {
            containers.addContainer(container2);
        }
        if (!containers.containsContainer(container3.getName())) {
            containers.addContainer(container3);
        }
    }

    @Test
    public void testGetInstance() {
        assertTrue(containers == Containers.getInstance());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddContainer() {
        int containersNumber = containers.getNumberOfContainers();
        assertTrue(containersNumber == 3);

        containers.addContainer(container1);
        assertTrue(containers.getNumberOfContainers() == 3);
    }

    @Test
    public void testRemoveContainer() {

        assertTrue(containers.getNumberOfContainers() == 3);

        int containerSize = containers.getNumberOfContainers();

        containers.removeContainer(container2);
        containers.removeContainer("Mleko");

        assertTrue(containers.getNumberOfContainers() == 1);

    }

    @Test
    public void testGetContainersNumber() {
        assertTrue(containers.getNumberOfContainers() == 3);
    }

    @Test
    public void testGetContainers() {
        int iteratorSize = 0;
        Iterator<Container> containerIterator = containers.getContainers();

        while (containerIterator.hasNext()) {
            containerIterator.next();
            iteratorSize++;
        }

        assertTrue(iteratorSize == 3);
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetContainer() {
        assertTrue(containers.getContainer("Mleko") != null);

        containers.getContainer("Herbata");
    }
}