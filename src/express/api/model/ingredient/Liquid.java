package express.api.model.ingredient;

/**
 * Created by Admin on 2014-12-14.
 */
public class Liquid extends Ingredient {

    private int temperature;
    private int pressure;

    public Liquid(String name, int containerId)
    {
        super(name, containerId);

        this.temperature = 0;
        this.pressure = 0;
    }

    /**
     * @return Temperature that liquid ingredient has to be warm.
     */
    public int getTemperature() {
        return temperature;
    }

    /**
     * Set temperature of liquid ingredient has to be warm.
     * @param temperature
     */
    public void setTemperature(int temperature) {

        checkArgument(temperature);
        this.temperature = temperature;
    }

    /**
     * @return Pressure that ingredient must be pump with.
     */
    public int getPressure() {
        return pressure;
    }

    /**
     * Set pressure that ingredient must be pump with.
     * @param pressure
     */
    public void setPressure(int pressure) {

        checkArgument(pressure);
        this.pressure = pressure;
    }
}
