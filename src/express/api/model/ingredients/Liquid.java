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
     * @param name Name of liquid ingredient
     */
    public Liquid(String name) {
        super(name);

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
    public void setTemperature(double temperature) {
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

    @Override
    public String toString() {
        return String.format("%s : %.2f ml %.2f \u2103 %.2f bars", getName(), getAmount(), getTemperature(), getPressure());
    }
}
