package express.api.model.devices.containers;

import express.api.utils.validators.ArgumentsValidator;

import java.util.*;

/**
 * Set that stores and manages a set of containers.
 */
public class Containers {

    private static Containers instance = new Containers();

    /**
     * Singleton.
     *
     * @return instance of Containers set.
     */
    public static Containers getInstance() {
        return instance;
    }

    private Containers() {
    }

    private Map<String, Container> containers = new HashMap<String, Container>();

    /**
     * Add container to current set of containers
     *
     * @param container Container
     */
    public void addContainer(Container container) {
        ArgumentsValidator.nullArgument(container);
        containers.put(container.getName(), container);
    }

    /**
     * Remove container by reference of itself
     *
     * @param container Instance of container to remove from set.
     */
    public void removeContainer(Container container) {
        ArgumentsValidator.nullArgument(container);

        removeContainer(container.getName());
    }

    /**
     * Remove container by its name.
     *
     * @param containerName Name of container to remove.
     */
    public void removeContainer(String containerName) {
        ArgumentsValidator.nullArgument(containerName);
        ArgumentsValidator.emptyString(containerName);

        containers.remove(containerName);
    }

    /**
     * Get a number of containers in set.
     *
     * @return Amount of containers.
     */
    public int getContainersNumber() {
        return containers.size();
    }

    /**
     * Get a list of all currently stored containers instances as a iterator.
     *
     * @return Iterator to list of containers.
     */
    public Iterator<Container> getContainers() {
        Collection<Container> values = containers.values();
        return values.iterator();
    }

    /**
     * @param containerName Name of container.
     * @return Instance of container with that name
     */
    public Container getContainer(String containerName) {
        ArgumentsValidator.nullArgument(containerName);
        ArgumentsValidator.emptyString(containerName);

        return containers.get(containerName);
    }
}
