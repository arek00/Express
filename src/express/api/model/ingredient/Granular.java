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

    /**
     * @return Tells that granular is already grounded.
     */
    public boolean isGrounded()
    {
        return this.grounded;
    }

    /**
     * Set parameter if granular ingredient has to be ground.
     */
    public void setGrounded(boolean isGrounded)
    {
        this.grounded = isGrounded;
    }

}
