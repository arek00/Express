package tests.express.api.model.devices.containers;

import express.api.model.devices.containers.Containers;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContainersTest {

    private static Containers containers;

    @BeforeClass
    public static void init() {
        containers = Containers.getInstance();
    }


    @Test
    public void testGetInstance() throws Exception {
        assertTrue(containers == Containers.getInstance());
    }

    @Test
    public void testAddContainer() throws Exception {
        int containersNumber = containers.getContainersNumber();

        assertTrue(containersNumber == 0);

    }

    @Test
    public void testRemoveContainer() throws Exception {

    }

    @Test
    public void testRemoveContainer1() throws Exception {

    }

    @Test
    public void testGetContainersNumber() throws Exception {

    }

    @Test
    public void testGetContainers() throws Exception {

    }

    @Test
    public void testGetContainer() throws Exception {

    }
}