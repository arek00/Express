package express.api.utils.converters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Set of methods to conversion iterator.
 */
public class IteratorConverter {

    private IteratorConverter() {
    }

    /**
     * Converts given iterator to collection of same type.
     *
     * @param iterator Iterator to conversion.
     * @param <T>      Generic type of iterator/collection
     * @return Collection of given iterator type.
     */
    public static <T> Collection<T> toCollection(Iterator<T> iterator) {
        T iteratorEntity;
        Collection<T> collection = new ArrayList<T>();

        while (iterator.hasNext()) {
            iteratorEntity = iterator.next();
            collection.add(iteratorEntity);
        }

        return collection;
    }


}
