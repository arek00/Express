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

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {

        checkArgument(temperature);
        this.temperature = temperature;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {

        checkArgument(pressure);
        this.pressure = pressure;
    }
}
