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
    private SelectRecipeMenu selectRecipeMenu = new SelectRecipeMenu(menu);
    private CreateRecipeMenu createRecipeMenu = new CreateRecipeMenu(menu);

    private ActionListener recipesListener;
    private ActionListener ingredientsListener;


    public GraphicsView() {
        menu.setVisible(true);
        menu.setChooseRecipeButtonListener(new SelectRecipeListener());
        menu.setCreateRecipeButtonListener(new CreateRecipeListener());
    }

    @Override
    public void setRecipesListener(ActionListener listener) {
        this.recipesListener = listener;
    }

    @Override
    public void setRecipes(Iterator<Recipe> recipes) {
        Collection<Recipe> collection = IteratorConverter.toCollection(recipes);
        selectRecipeMenu.setRecipes(collection.toArray());
    }

    @Override
    public void setIngredientsListener(ActionListener listener) {
        ingredientsListener = listener;
    }

    @Override
    public void setIngredients(Iterator<Ingredient> ingredients) {
        Collection<Ingredient> collection = IteratorConverter.toCollection(ingredients);
        createRecipeMenu.setIngredientsList(collection.toArray());
        createRecipeMenu.setAdditivesList(collection.toArray());

    }

    @Override
    public void setIngredientListener(ActionListener listener) {
        createRecipeMenu.addSetIngredientListener(listener);
    }

    @Override
    public void setAdditiveListener(ActionListener listener) {
        createRecipeMenu.addSetAdditiveListener(listener);
    }

    @Override
    public Ingredient getIngredient() {
        return createRecipeMenu.getIngredient();
    }

    @Override
    public Ingredient getAdditive() {
        return createRecipeMenu.getAdditive();
    }

    @Override
    public void setRecipeDescription(String description) {
        createRecipeMenu.setRecipeDescription(description);
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
