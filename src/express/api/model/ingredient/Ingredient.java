package express.api.model.ingredient;

/**
 * Created by Admin on 2014-12-14.
 */
public class Ingredient {

    private String name;
    private int containerId;
    private int amount;

    public Ingredient(String name, int containerId)
    {
        this.name = name;
        this.containerId = containerId;
        this.amount = 0;
    }


    public String getName() {
        return name;
    }

    public int getContainerId() {
        return containerId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {

        checkArgument(amount);
        this.amount = amount;
    }


    protected void checkArgument(int arg)
    {
        if(arg < 0)
        {
            throw new IllegalArgumentException("Argument can't be less than 0");
        }
    }

}
