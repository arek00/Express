package express.example.implementation.view;

import express.api.model.ingredients.Ingredient;
import express.api.model.recipes.Recipe;
import express.api.utils.converters.IteratorConverter;
import express.example.implementation.view.forms.SelectRecipeMenu;
import express.example.implementation.view.forms.CreateRecipeMenu;
import express.example.implementation.view.forms.MainMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by Admin on 2015-02-25.
 */
public class GraphicsView implements IView {

    private MainMenu menu = new MainMenu();
    private SelectRecipeMenu selectRecipeMenu = new SelectRecipeMenu();
    private CreateRecipeMenu createRecipeMenu = new CreateRecipeMenu();
    private ActionListener recipesListener;
    private ActionListener ingredientsListener;


    public GraphicsView() {
        menu.setVisible(true);
        menu.setChooseRecipeButtonListener(new SelectRecipeListener());
        menu.setCreateRecipeButtonListener(new CreateRecipeListener());
    }


    public void setRecipesList(Iterator<Recipe> recipesList) {
        Collection<Recipe> recipeCollection = IteratorConverter.toCollection(recipesList);
        selectRecipeMenu.setRecipesListData(recipeCollection.toArray());
    }


    @Override
    public void setStartBrewingSequenceListener(ActionListener listener) {
        selectRecipeMenu.setStartBrewingListener(listener);
    }

    @Override
    public void setRecipesListener(ActionListener listener) {
        recipesListener = listener;
    }

    @Override
    public void setIngredientsListener(ActionListener listener) {
        ingredientsListener = listener;
    }

    @Override
    public Recipe getSelectedRecipe() {
        return selectRecipeMenu.getSelectedRecipe();
    }

    @Override
    public void setIngredientsList(Iterator<Ingredient> ingredients) {
        Collection<Ingredient> ingredientsCollection = IteratorConverter.toCollection(ingredients);

        createRecipeMenu.setIngredientsList(ingredientsCollection.toArray());
        createRecipeMenu.setAdditivesList(ingredientsCollection.toArray());
    }

    @Override
    public void showError(String message) {
        JOptionPane.showMessageDialog(null, message);
    }


    class SelectRecipeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            selectRecipeMenu.setVisible(true);
            recipesListener.actionPerformed(null);
        }
    }

    class CreateRecipeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            createRecipeMenu.setVisible(true);
            ingredientsListener.actionPerformed(null);
        }
    }
}
