package example.impl;

/**
 * Created by Admin on 2015-01-13.
 */
public enum DevicesIds {
    MILK_CONTAINER(0),
    SUGAR_CONTAINER(1),
    COFFEE_CONTAINER(17),
    GRINDER(23),
    DISPENSER(50);

    private int value;

    private DevicesIds(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
