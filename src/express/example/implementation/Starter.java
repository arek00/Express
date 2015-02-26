package express.example.implementation;

import express.api.model.MachineController;
import express.example.implementation.presenter.Presenter;
import express.example.implementation.sequences.DefaultSequence;
import express.example.implementation.view.GraphicsView;

/**
 * Created by Admin on 2015-02-23.
 */
public class Starter {

    public static void main(String[] args) {
        Initializer initializer = new Initializer();
        initializer.initialize();

        DefaultSequence sequence = new DefaultSequence();
        MachineController.getInstance().setBrewStrategy(sequence);


        MachineController model = MachineController.getInstance();
        model.setBrewStrategy(new DefaultSequence());

        GraphicsView view = new GraphicsView();
        Presenter presenter = new Presenter(view, model);

    }
}
