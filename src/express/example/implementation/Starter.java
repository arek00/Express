package express.example.implementation;

import express.api.model.MachineController;
import express.example.implementation.presenter.Presenter;
import express.example.implementation.sequences.DefaultSequence;
import express.example.implementation.view.View;

/**
 * Starter of application.
 */
public class Starter {

    public static void main(String[] args) {
        Initializer initializer = new Initializer();
        initializer.initialize();

        DefaultSequence sequence = new DefaultSequence();
        MachineController.getInstance().setBrewStrategy(sequence);


        MachineController model = MachineController.getInstance();
        model.setBrewStrategy(new DefaultSequence());

        View view = new View();
        Presenter presenter = new Presenter(view, model);

    }
}
