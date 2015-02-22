package express.api.utils.validators;

/**
 * Created by Admin on 2015-02-22.
 */
public class NumbersValidator {
    private NumbersValidator() {
    }

    public static void negativeNumber(double number) {
        if (number < 0d) {
            throw new IllegalArgumentException("Number is lower than 0");
        }

    }

    public static void negativeNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number is lower than 0");
        }
    }

    public static void lowerOrEqualZero(double number) {
        if (number <= 0d) {
            throw new IllegalArgumentException("Number is lower than 0");
        }
    }

    public static void lowerOrEqualZero(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Number is lower than 0");
        }
    }


}
