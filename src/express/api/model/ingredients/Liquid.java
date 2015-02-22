package express.api.model.ingredients;

import express.api.model.devices.containers.Container;
import express.api.utils.validators.NumbersValidator;

/**
 * Representation of liquid ingredient that may be using to brew coffee.
 * Besides information about amount it also has information about temperature and pressure that ingredient
 * should be warm and pumped.
 */
public class Liquid extends Ingredient {

    private double temperature;
    private double pressure;

    /**
     * @param name      Name of liquid ingredient
     * @param container Instance of container that stores this ingredient.
     */
    public Liquid(String name, Container container) {
        super(name, container);

        this.temperature = 0;
        this.pressure = 0;
    }

    /**
     * @return Temperature that liquid ingredient has to be warm.
     */
    public double getTemperature() {
        return temperature;
    }

    /**
     * Set temperature of liquid ingredient has to be warm.
     *
     * @param temperature Temperature in Celsius degree
     */
    public void setTemperature(int temperature) {
        NumbersValidator.negativeNumber(temperature);
        this.temperature = temperature;
    }

    /**
     * @return Pressure that ingredient must be pump with.
     */
    public double getPressure() {
        return pressure;
    }

    /**
     * Set pressure that ingredient must be pump with.
     *
     * @param pressure Pressure in Bars degree
     */
    public void setPressure(double pressure) {
        NumbersValidator.negativeNumber(pressure);
        this.pressure = pressure;
    }
}