package express.example.implementation.view;

import express.api.model.ingredients.Ingredient;
import express.api.model.recipes.Recipe;

import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by Admin on 2015-02-24.
 */
public class ConsoleView implements IView {

    private Iterator<Recipe> recipeIterator;

    private Iterator<Ingredient> ingredientIterator;
    private Iterator<Ingredient> additiveIterator;

    private Scanner scanner = new Scanner(System.in);

    private ActionListener startBrewingListener;
    private ActionListener chooseRecipeListener;

    String action;


    public ConsoleView() {

    }


    private void displayMenu() {
        System.out.println("1. Choose recipe");
        System.out.println("2. Create recipe");

        action = scanner.nextLine();
        action = action.toLowerCase();

        if (action.equals("1")) {
            chooseRecipe();
        } else if (action.equals("2")) {
            createRecipe();
        }
    }


    private void chooseRecipe() {
        int recipeIndex = 0;
        Recipe entity;

        while (recipeIterator.hasNext()) {
            entity = recipeIterator.next();
            System.out.println(recipeIndex + ". " + entity.getRecipeName());
        }

        System.out.println("q - Anuluj");

        action = scanner.nextLine();
        startBrewingListener.actionPerformed(null);


    }

    private void createRecipe() {

    }


    @Override
    public void setRecipes(Iterator<Recipe> recipes) {

    }

    @Override
    public void setIngredients(Iterator<Ingredient> ingredients) {

    }

    @Override
    public String getRecipe() {
        return action;
    }

    @Override
    public void setStartBrewSequenceListener(ActionListener listener) {
        this.startBrewingListener = listener;
    }

    @Override
    public void onRecipeChooseListener(ActionListener listener) {
        this.chooseRecipeListener = listener;
    }


}
