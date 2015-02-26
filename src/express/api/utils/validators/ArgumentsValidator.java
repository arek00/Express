package express.api.utils.validators;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Utility to arguments validation purposes.
 */
public class ArgumentsValidator {

    private ArgumentsValidator() {
    }

    /**
     * Check if given argument has null reference.
     *
     * @param argument argument to check
     */
    public static void nullArgument(Object argument) {
        if (argument == null) {
            throw new IllegalArgumentException("Given argument is null");
        }
    }

    /**
     * Method to check if given method may returns null.
     * Unlike to nullArgument method, if this test is positive then
     * NoSuchElementException is going to be thrown instead of IllegalArgumentException.
     * Method was created to prevent returns null in methods that search for elements in colleciton
     * by arguments like String.
     *
     * @param returnValue Value that method returns.
     */
    public static void nullReturn(Object returnValue) {
        if (returnValue == null) {
            throw new NoSuchElementException("Could not find such element");
        }
    }

    /**
     * Test if collection is empty. That's not checking if collection has null reference but collection
     * has no elements inside.
     *
     * @param collection Collection to check.
     * @param <T> Type of collection's elements
     */
    public static <T> void emptyCollection(Collection<T> collection) {
        if (collection.isEmpty()) {
            throw new IllegalArgumentException("Given collection is empty");
        }
    }

    /**
     * Check if iterator has no elements inside.
     *
     * @param iterator Iterator to check.
     * @param <T> Type of iterator's elements
     */
    public static <T> void emptyIterator(Iterator<T> iterator) {
        if (!iterator.hasNext()) {
            throw new IllegalArgumentException("Given iterator is empty");
        }
    }

    /**
     * Check if given String argument has any text inside.
     *
     * @param string String to check
     */
    public static void emptyString(String string) {
        if (string.isEmpty()) {
            throw new IllegalArgumentException("Given string is empty");
        }
    }
}
