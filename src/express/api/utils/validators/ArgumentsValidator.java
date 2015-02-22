package express.api.utils.validators;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by Admin on 2015-02-22.
 */
public class ArgumentsValidator {

    private ArgumentsValidator() {
    }

    public static void nullArgument(Object argument) {
        if (argument == null) {
            throw new IllegalArgumentException("Given argument is null");
        }
    }

    public static <T> void emptyCollection(Collection<T> collection) {
        if (collection.isEmpty()) {
            throw new IllegalArgumentException("Given collection is empty");
        }
    }

    public static <T> void emptyIterator(Iterator<T> iterator) {
        if (!iterator.hasNext()) {
            throw new IllegalArgumentException("Given iterator is empty");
        }
    }

    public static void emptyString(String string) {
        if (string.isEmpty()) {
            throw new IllegalArgumentException("Given string is empty");
        }
    }
}
