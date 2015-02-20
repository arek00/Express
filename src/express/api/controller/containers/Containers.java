package express.api.controller.containers;

import express.api.model.ingredient.Ingredient;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Admin on 2015-02-19.
 */
public class Containers {


    private List<Container> containers = new ArrayList<Container>();

    /**
     * Add container to current set of containers
     *
     * @param container Container
     */
    public void addContainer(Container container) {
        validateArgument(container);
        containers.add(container);
    }

    public void removeContainer(Container container) {
        validateArgument(container);
        containers.remove(container);
    }

    public void removeContainer(int containerIndex) {
        containers.remove(containerIndex);
    }

    public int getContainersNumber() {
        return containers.size();
    }

    /**
     * Get a list of all currently stored containers instances.
     *
     * @return Iterator to list of containers.
     */
    public Iterator<Container> getContainers() {
        return containers.iterator();
    }

    /**
     * Get instance of container under given Id number.
     *
     * @param id Identification number of container you want to get. (Index number)
     * @return Instance of container.
     */
    public Container getContainerById(int id) {
        return containers.get(id);
    }


    private void validateArgument(Container container) {
        if (container == null) {
            throw new IllegalArgumentException("Argument is null");
        }
    }


}
