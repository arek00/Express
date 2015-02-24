package express.example.implementation.presenter;

import express.api.exceptions.DeviceException;
import express.api.model.MachineController;
import express.example.implementation.model.Model;
import express.example.implementation.view.IView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 2015-02-24.
 */
public class Presenter {
    private MachineController machineController = MachineController.getInstance();
    private List<IView> viewList = new ArrayList<IView>();
    private Model model;


    public Presenter(IView view, Model model) {
        viewList.add(view);
        this.model = model;

    }


    class StartBrewSequenceListener implements ActionListener {
        IView view = viewList.get(0);

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int index = Integer.getInteger(view.getRecipe());
                model.performBrewSequence(model.getRecipe(index));
            } catch (DeviceException e1) {
                e1.printStackTrace();
            }
        }
    }

    class ChooseRecipeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            viewList.get(0).setRecipes(model.getAllRecipes());
        }
    }

}
