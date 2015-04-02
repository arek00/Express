package express.example.implementation.view;

import express.api.model.ingredients.Ingredient;
import express.api.model.recipes.Recipe;
import express.api.utils.converters.IteratorConverter;
import express.api.utils.validators.ArgumentsValidator;
import express.example.implementation.view.forms.SelectRecipeMenu;
import express.example.implementation.view.forms.CreateRecipeWindow;
import express.example.implementation.view.forms.MainMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Iterator;

/**
 * Graphics view.
 */
public class View implements IView {

    private MainMenu menu = new MainMenu();
    private SelectRecipeMenu selectRecipeMenu = new SelectRecipeMenu();
    private CreateRecipeWindow createRecipeMenu = new CreateRecipeWindow();

    private ActionListener recipesListener;
    private ActionListener ingredientsListener;

    /**
     *
     *
     */
    public View() {
        menu.setVisible(true);
        menu.setChooseRecipeButtonListener(new SelectRecipeListener());
        menu.setCreateRecipeButtonListener(new CreateRecipeListener());
    }

    /**
     * Set listener that signalizing update recipes collection
     *
     * @param listener
     */
    @Override
    public void setRecipesListener(ActionListener listener) {
        ArgumentsValidator.notNull(listener);
        this.recipesListener = listener;
    }

    /**
     * Set all recipes to view.
     *
     * @param recipes Iterator to recipes
     */
    @Override
    public void setRecipes(Iterator<Recipe> recipes) {
        Collection<Recipe> collection = IteratorConverter.toCollection(recipes);
        selectRecipeMenu.setRecipes(collection.toArray());
    }

    /**
     * @param listener
     */
    @Override
    public void setIngredientsListener(ActionListener listener) {
        ingredientsListener = listener;
    }

    /**
     * Set ingredient in order to represent in view.
     *
     * @param ingredients Iterator to ingredients set.
     */
    @Override
    public void setIngredients(Iterator<Ingredient> ingredients) {
        Collection<Ingredient> collection = IteratorConverter.toCollection(ingredients);
        createRecipeMenu.setIngredientsList(collection.toArray());
        createRecipeMenu.setAdditivesList(collection.toArray());

    }

    /**
     * @param listener
     */
    @Override
    public void setIngredientListener(ActionListener listener) {
        createRecipeMenu.addSetIngredientListener(listener);
    }

    /**
     * @param listener
     */
    @Override
    public void setAdditiveListener(ActionListener listener) {
        createRecipeMenu.addSetAdditiveListener(listener);
    }

    /**
     * @return
     */
    @Override
    public Ingredient getIngredient() {
        return createRecipeMenu.getIngredient();
    }

    /**
     * @return
     */
    @Override
    public Ingredient getAdditive() {
        return createRecipeMenu.getAdditive();
    }

    /**
     * Set recipe description from ingredients and additives stores in recipe maker.
     *
     * @param description
     */
    @Override
    public void setRecipeDescription(String description) {
        createRecipeMenu.setRecipeDescription(description);
    }


    /**
     *
     *
     */
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
