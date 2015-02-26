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
        ArgumentsValidator.notNull(container);
        checkUnique(container);

        containers.put(container.getName(), container);
    }

    /**
     * Remove container by reference of itself
     *
     * @param container Instance of container to remove from set.
     */
    public void removeContainer(Container container) {
        ArgumentsValidator.notNull(container);

        removeContainer(container.getName());
    }

    /**
     * Remove container by its name.
     *
     * @param containerName Name of container to remove.
     */
    public void removeContainer(String containerName) {
        ArgumentsValidator.notNull(containerName);
        ArgumentsValidator.stringNotEmpty(containerName);

        containers.remove(containerName);
    }

    /**
     * Get a number of containers in set.
     *
     * @return Amount of containers.
     */
    public int getNumberOfContainers() {
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
        ArgumentsValidator.notNull(containerName);
        ArgumentsValidator.stringNotEmpty(containerName);

        Container container = containers.get(containerName);
        ArgumentsValidator.returnNotNull(container);

        return container;
    }

    /**
     * Tells if set already has container with that name.
     *
     * @param containerName container name
     * @return true when container with given name exists in set, false otherwise
     */
    public boolean containsContainer(String containerName) {
        return (containers.get(containerName) != null);
    }

    private void checkUnique(Container container) {
        if (containers.get(container.getName()) != null) {
            throw new IllegalArgumentException("There already exists container with name " + container.getName());
        }
    }
}
