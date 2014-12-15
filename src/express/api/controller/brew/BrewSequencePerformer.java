package express.api.controller.brew;

/**
 * Created by Admin on 2014-12-14.
 */
public class BrewSequencePerformer {

    private static BrewSequencePerformer instance = new BrewSequencePerformer();

    private BrewSequencePerformer()
    {

    }

    public static BrewSequencePerformer getInstance()
    {
        return instance;
    }

    public void perform(BrewSequence sequence)
    {
        sequence.perform();
    }

}
