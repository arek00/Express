/*
 * Created by JFormDesigner on Wed Feb 25 11:50:56 CET 2015
 */

package express.example.implementation.view.forms;

import javax.swing.event.*;

import express.api.model.ingredients.Granular;
import express.api.model.ingredients.Ingredient;
import express.api.model.ingredients.Liquid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Arkadiusz Pikulski
 */
public class CreateRecipeWindow extends JDialog {

    private Ingredient ingredient;
    private ActionListener setIngredientListener;
    private ActionListener setAdditiveListener;

    /**
     *
     */
    public CreateRecipeWindow() {
        initComponents();
        setListsListeners();
        addGranularButton.addActionListener(new HidePanelsListener());
        addLiquidButton.addActionListener(new HidePanelsListener());
    }

    private void setListsListeners() {
        additivesList.addListSelectionListener(new IngredientsListListener(additivesList));
        ingredientsList.addListSelectionListener(new IngredientsListListener(ingredientsList));
    }

    /**
     * Set elements to put it on  ingredients list
     *
     * @param items
     */
    public void setIngredientsList(Object[] items) {
        ingredientsList.setListData(items);
    }

    /**
     * Set elements to put it on  additives list
     *
     * @param items
     */
    public void setAdditivesList(Object[] items) {
        additivesList.setListData(items);
    }


    public void addSetIngredientListener(ActionListener listener) {
        this.setIngredientListener = listener;
    }

    /**
     * Set listener to setting additives on recipe maker.
     *
     * @param listener
     */
    public void addSetAdditiveListener(ActionListener listener) {
        this.setAdditiveListener = listener;
    }

    /**
     * Get selected ingredient in order to put ingredient to recipe maker.
     *
     * @return ingredient
     */
    public Ingredient getIngredient() {
        return ingredient;
    }

    /**
     * Get selected additive in order to put ingredient to recipe maker.
     *
     * @return ingredient
     */
    public Ingredient getAdditive() {
        return ingredient;
    }


    private void hidePanels() {
        granularEditionPanel.setVisible(false);
        liquidEditPanel.setVisible(false);
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Arkadiusz Pikulski
        liquidEditPanel = new JPanel();
        liquidNameLabel = new JLabel();
        temperatureField = new JTextField();
        pressureField = new JTextField();
        addLiquidButton = new JButton();
        liquidValueSlider = new JSlider();
        liquidAmountLabel = new JLabel();
        liquidValueLabel = new JLabel();
        liquidUnitLabel = new JLabel();
        temperatureLabel = new JLabel();
        pressureLabel = new JLabel();
        recipeNameField = new JTextField();
        scrollPane1 = new JScrollPane();
        ingredientsList = new JList();
        RecipeNameLabel = new JLabel();
        ingredientsLabel = new JLabel();
        scrollPane2 = new JScrollPane();
        additivesList = new JList();
        additivesLabel = new JLabel();
        scrollPane3 = new JScrollPane();
        currentRecipe = new JTextArea();
        createRecipeButton = new JButton();
        granularEditionPanel = new JPanel();
        granularNameLabel = new JLabel();
        granularAmountSlider = new JSlider();
        granularAmountLabel = new JLabel();
        granularValueLabel = new JLabel();
        unitLabel = new JLabel();
        granularGrindingSwitch = new JToggleButton();
        grindLabel = new JLabel();
        addGranularButton = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== liquidEditPanel ========
        {
            liquidEditPanel.setVisible(false);

            // JFormDesigner evaluation mark
            liquidEditPanel.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                            "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                            javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                            java.awt.Color.red), liquidEditPanel.getBorder()));
            liquidEditPanel.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
                public void propertyChange(java.beans.PropertyChangeEvent e) {
                    if ("border".equals(e.getPropertyName())) throw new RuntimeException();
                }
            });

            liquidEditPanel.setLayout(null);

            //---- liquidNameLabel ----
            liquidNameLabel.setText("INGREDIENT NAME");
            liquidEditPanel.add(liquidNameLabel);
            liquidNameLabel.setBounds(10, 10, 115, liquidNameLabel.getPreferredSize().height);
            liquidEditPanel.add(temperatureField);
            temperatureField.setBounds(15, 130, 105, temperatureField.getPreferredSize().height);
            liquidEditPanel.add(pressureField);
            pressureField.setBounds(165, 130, 105, pressureField.getPreferredSize().height);

            //---- addLiquidButton ----
            addLiquidButton.setText("Add");
            liquidEditPanel.add(addLiquidButton);
            addLiquidButton.setBounds(new Rectangle(new Point(265, 155), addLiquidButton.getPreferredSize()));
            liquidEditPanel.add(liquidValueSlider);
            liquidValueSlider.setBounds(new Rectangle(new Point(15, 70), liquidValueSlider.getPreferredSize()));

            //---- liquidAmountLabel ----
            liquidAmountLabel.setText("Amount:");
            liquidEditPanel.add(liquidAmountLabel);
            liquidAmountLabel.setBounds(15, 40, 60, liquidAmountLabel.getPreferredSize().height);

            //---- liquidValueLabel ----
            liquidValueLabel.setText("VALUE");
            liquidEditPanel.add(liquidValueLabel);
            liquidValueLabel.setBounds(65, 40, 50, liquidValueLabel.getPreferredSize().height);

            //---- liquidUnitLabel ----
            liquidUnitLabel.setText("liters");
            liquidEditPanel.add(liquidUnitLabel);
            liquidUnitLabel.setBounds(110, 40, 45, liquidUnitLabel.getPreferredSize().height);

            //---- temperatureLabel ----
            temperatureLabel.setText("Temperature (in Celsius)");
            liquidEditPanel.add(temperatureLabel);
            temperatureLabel.setBounds(5, 105, 145, temperatureLabel.getPreferredSize().height);

            //---- pressureLabel ----
            pressureLabel.setText("Pressure (in Bar)");
            liquidEditPanel.add(pressureLabel);
            pressureLabel.setBounds(165, 105, 125, pressureLabel.getPreferredSize().height);
        }
        contentPane.add(liquidEditPanel);
        liquidEditPanel.setBounds(10, 280, 335, 190);
        contentPane.add(recipeNameField);
        recipeNameField.setBounds(105, 5, 265, recipeNameField.getPreferredSize().height);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(ingredientsList);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(10, 55, 75, 170);

        //---- RecipeNameLabel ----
        RecipeNameLabel.setText("Recipe Name");
        contentPane.add(RecipeNameLabel);
        RecipeNameLabel.setBounds(new Rectangle(new Point(10, 5), RecipeNameLabel.getPreferredSize()));

        //---- ingredientsLabel ----
        ingredientsLabel.setText("Ingredients");
        contentPane.add(ingredientsLabel);
        ingredientsLabel.setBounds(new Rectangle(new Point(10, 30), ingredientsLabel.getPreferredSize()));

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(additivesList);
        }
        contentPane.add(scrollPane2);
        scrollPane2.setBounds(105, 55, 75, 170);

        //---- additivesLabel ----
        additivesLabel.setText("Additives");
        contentPane.add(additivesLabel);
        additivesLabel.setBounds(new Rectangle(new Point(105, 30), additivesLabel.getPreferredSize()));

        //======== scrollPane3 ========
        {

            //---- currentRecipe ----
            currentRecipe.setEditable(false);
            scrollPane3.setViewportView(currentRecipe);
        }
        contentPane.add(scrollPane3);
        scrollPane3.setBounds(200, 50, 145, 175);

        //---- createRecipeButton ----
        createRecipeButton.setText("Create Recipe");
        contentPane.add(createRecipeButton);
        createRecipeButton.setBounds(205, 235, 140, createRecipeButton.getPreferredSize().height);

        //======== granularEditionPanel ========
        {
            granularEditionPanel.setVisible(false);
            granularEditionPanel.setLayout(null);

            //---- granularNameLabel ----
            granularNameLabel.setText("INGREDIENT NAME");
            granularEditionPanel.add(granularNameLabel);
            granularNameLabel.setBounds(15, 15, 125, granularNameLabel.getPreferredSize().height);
            granularEditionPanel.add(granularAmountSlider);
            granularAmountSlider.setBounds(new Rectangle(new Point(15, 80), granularAmountSlider.getPreferredSize()));

            //---- granularAmountLabel ----
            granularAmountLabel.setText("Amount");
            granularEditionPanel.add(granularAmountLabel);
            granularAmountLabel.setBounds(new Rectangle(new Point(15, 55), granularAmountLabel.getPreferredSize()));

            //---- granularValueLabel ----
            granularValueLabel.setText("value");
            granularEditionPanel.add(granularValueLabel);
            granularValueLabel.setBounds(65, 55, 40, granularValueLabel.getPreferredSize().height);

            //---- unitLabel ----
            unitLabel.setText("grams");
            granularEditionPanel.add(unitLabel);
            unitLabel.setBounds(105, 55, 45, unitLabel.getPreferredSize().height);

            //---- granularGrindingSwitch ----
            granularGrindingSwitch.setText("Off");
            granularEditionPanel.add(granularGrindingSwitch);
            granularGrindingSwitch.setBounds(new Rectangle(new Point(20, 120), granularGrindingSwitch.getPreferredSize()));

            //---- grindLabel ----
            grindLabel.setText("Grind:");
            granularEditionPanel.add(grindLabel);
            grindLabel.setBounds(20, 100, 60, grindLabel.getPreferredSize().height);

            //---- addGranularButton ----
            addGranularButton.setText("Add");
            granularEditionPanel.add(addGranularButton);
            addGranularButton.setBounds(225, 180, 76, 26);
        }
        contentPane.add(granularEditionPanel);
        granularEditionPanel.setBounds(10, 270, 340, 215);

        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for (int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Arkadiusz Pikulski
    private JPanel liquidEditPanel;
    private JLabel liquidNameLabel;
    private JTextField temperatureField;
    private JTextField pressureField;
    private JButton addLiquidButton;
    private JSlider liquidValueSlider;
    private JLabel liquidAmountLabel;
    private JLabel liquidValueLabel;
    private JLabel liquidUnitLabel;
    private JLabel temperatureLabel;
    private JLabel pressureLabel;
    private JTextField recipeNameField;
    private JScrollPane scrollPane1;
    private JList ingredientsList;
    private JLabel RecipeNameLabel;
    private JLabel ingredientsLabel;
    private JScrollPane scrollPane2;
    private JList additivesList;
    private JLabel additivesLabel;
    private JScrollPane scrollPane3;
    private JTextArea currentRecipe;
    private JButton createRecipeButton;
    private JPanel granularEditionPanel;
    private JLabel granularNameLabel;
    private JSlider granularAmountSlider;
    private JLabel granularAmountLabel;
    private JLabel granularValueLabel;
    private JLabel unitLabel;
    private JToggleButton granularGrindingSwitch;
    private JLabel grindLabel;
    private JButton addGranularButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    /**
     * Listener that observes selections on JLists
     */
    class IngredientsListListener implements ListSelectionListener {
        private JList list;

        public IngredientsListListener(JList list) {
            this.list = list;
        }

        private void setGranularPanelValues(Granular selectedValue) {
            granularValueLabel.setText(Double.toString(selectedValue.getAmount()));
            granularAmountSlider.setValue((int) selectedValue.getAmount());
            granularNameLabel.setText(selectedValue.getName());
        }

        private void setLiquidPanelValue(Liquid selectedValue) {
            liquidValueLabel.setText(Double.toString(selectedValue.getAmount()));
            liquidNameLabel.setText(selectedValue.getName());
            liquidValueSlider.setValue((int) selectedValue.getAmount());
            temperatureField.setText(Double.toString(selectedValue.getTemperature()));
            pressureField.setText(Double.toString(selectedValue.getPressure()));
        }

        @Override
        public void valueChanged(ListSelectionEvent e) {
            ingredient = (Ingredient) list.getSelectedValue();
            hidePanels();
            clearListeners();
            setButtonListener();
            setPanelType(ingredient);

        }

        private void setButtonListener() {
            if (this.list == additivesList) {
                addLiquidButton.addActionListener(setAdditiveListener);
                addGranularButton.addActionListener(setAdditiveListener);

            } else if (this.list == ingredientsList) {
                addLiquidButton.addActionListener(setIngredientListener);
                addGranularButton.addActionListener(setIngredientListener);
            }


        }

        private void clearListeners() {

            for (ActionListener each : addLiquidButton.getActionListeners()) {
                addLiquidButton.removeActionListener(each);
            }
            for (ActionListener each : addGranularButton.getActionListeners()) {
                addGranularButton.removeActionListener(each);
            }
        }

        private void setPanelType(Ingredient ingredient) {

            if (ingredient instanceof Granular) {
                granularEditionPanel.setVisible(true);
                setGranularPanelValues((Granular) ingredient);

            } else if (ingredient instanceof Liquid) {
                liquidEditPanel.setVisible(true);
                setLiquidPanelValue((Liquid) ingredient);
            }
        }
    }

    /**
     * Listenet to hiding forms
     */
    class HidePanelsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            hidePanels();
        }
    }

    /**
     * Set recipe description on TextArea element.
     *
     * @param description
     */
    public void setRecipeDescription(String description) {
        currentRecipe.setText(description);
    }

}
