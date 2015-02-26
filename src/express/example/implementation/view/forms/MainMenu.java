/*
 * Created by JFormDesigner on Wed Feb 25 11:26:32 CET 2015
 */

package express.example.implementation.view.forms;

import express.api.model.recipes.Recipes;
import express.api.utils.converters.IteratorConverter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * @author Arkadiusz Pikulski
 */
public class MainMenu extends JFrame {
    public MainMenu() {
        initComponents();
    }

    public void setChooseRecipeButtonListener(ActionListener listener) {
        chooseRecipeButton.addActionListener(listener);
    }

    public void setCreateRecipeButtonListener(ActionListener listener) {
        createRecipeButton.addActionListener(listener);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Arkadiusz Pikulski

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        chooseRecipeButton = new JButton();
        createRecipeButton = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());

        //---- chooseRecipeButton ----
        chooseRecipeButton.setText("Choose Recipe from List");
        contentPane.add(chooseRecipeButton);

        //---- createRecipeButton ----
        createRecipeButton.setText("Create new Recipe from Available Ingredients");
        contentPane.add(createRecipeButton);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Arkadiusz Pikulski
    private JButton chooseRecipeButton;
    private JButton createRecipeButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
