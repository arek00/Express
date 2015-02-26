package express.api.utils.validators;

/**
 * Utility class that exams numeric arguments.
 */
public class NumbersValidator {
    private NumbersValidator() {
    }

    /**
     * Test if given number is less than 0.
     *
     * @param number
     */
    public static void negativeNumber(double number) {
        if (number < 0d) {
            throw new IllegalArgumentException("Number is lower than 0");
        }
    }

    /**
     * Test if given number is less than 0.
     *
     * @param number
     */
    public static void negativeNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number is lower than 0");
        }
    }

    /**
     * Test if given number is less or equal 0.
     *
     * @param number
     */
    public static void lowerOrEqualZero(double number) {
        if (number <= 0d) {
            throw new IllegalArgumentException("Number is lower than 0");
        }
    }

    /**
     * Test if given number is less or equal 0.
     *
     * @param number
     */
    public static void lowerOrEqualZero(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Number is lower than 0");
        }
    }


}
