package express.api.model.devices.containers;

import java.util.*;

/**
 * Created by Admin on 2015-02-19.
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
        validateArgument(container);
        containers.put(container.getName(), container);
    }

    /**
     * Remove container by reference of itself
     *
     * @param container Instance of container to remove from set.
     */
    public void removeContainer(Container container) {
        validateArgument(container);
        removeContainer(container.getName());
    }

    /**
     * Remove container by its name.
     *
     * @param containerName Name of container to remove.
     */
    public void removeContainer(String containerName) {
        validateArgument(containerName);
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


    public Container getContainer(String containerName) {
        return containers.get(containerName);
    }


    private void validateArgument(Object argument) {
        if (argument == null) {
            throw new IllegalArgumentException("Argument is null");
        }
    }
}
