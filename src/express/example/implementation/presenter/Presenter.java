package express.example.implementation.presenter;

import express.api.exceptions.DeviceException;
import express.api.model.MachineController;
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

    /**
     *
     * @param view
     * @param model
     */
    public Presenter(IView view, MachineController model) {
        this.model = model;
        this.view = view;

        view.setRecipesListener(new RecipesListener());
        view.setIngredientsListener(new IngredientsListener());
        view.setIngredientListener(new AddIngredient());
        view.setAdditiveListener(new AddAdditive());
    }

    /**
     *
     */
    class RecipesListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.setRecipes(model.getAllRecipes());
        }
    }

    class IngredientsListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.setIngredients(model.getIngredients());
        }
    }

    class AddIngredient implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.addIngredientToMaker(view.getIngredient());
            view.setRecipeDescription(model.createRecipe().toString());
        }
    }

    class AddAdditive implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            model.addAdditiveToMaker(view.getIngredient());
            view.setRecipeDescription(model.createRecipe().toString());
        }
    }
}
