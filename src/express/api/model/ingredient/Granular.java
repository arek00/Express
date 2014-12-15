package express.api.model.ingredient;

/**
 * Created by Admin on 2014-12-14.
 */
public class Granular extends Ingredient{

    private boolean grounded;

    public Granular(String name, int containerId)
    {
        super(name,containerId);
        this.grounded = false;
    }

    public boolean isGrounded()
    {
        return this.grounded;
    }

    public void setGrounded(boolean isGrounded)
    {
        this.grounded = isGrounded;
    }

}
