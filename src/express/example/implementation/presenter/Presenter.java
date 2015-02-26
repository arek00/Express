package express.example.implementation.presenter;

import express.api.exceptions.DeviceException;
import express.api.model.MachineController;
import express.example.implementation.model.Model;
import express.example.implementation.view.IView;

import javax.crypto.Mac;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Presenter
 */
public class Presenter {
    private IView view;
    private MachineController model;


    public Presenter(IView view, MachineController model) {
        this.model = model;
        this.view = view;
        view.setStartBrewingSequenceListener(new StartBrewSequenceListener());
        view.setRecipesListener(new RecipesListener());
        view.setIngredientsListener(new IngredientsListener());
    }


    class StartBrewSequenceListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            try {
                model.performBrewSequence(view.getSelectedRecipe());
            } catch (DeviceException exception) {
                view.showError(exception.getMessage());
            }
        }
    }

    class RecipesListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.setRecipesList(model.getAllRecipes());
        }
    }

    class IngredientsListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.setIngredientsList(model.getIngredients());
        }
    }
}
