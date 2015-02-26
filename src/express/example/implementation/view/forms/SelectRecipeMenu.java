/*
 * Created by JFormDesigner on Wed Feb 25 11:46:39 CET 2015
 */

package express.example.implementation.view.forms;

import express.api.model.recipes.Recipe;
import express.api.utils.validators.ArgumentsValidator;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author Arkadiusz Pikulski
 */
public class SelectRecipeMenu extends JFrame {
    public SelectRecipeMenu() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Arkadiusz Pikulski
        scrollPane1 = new JScrollPane();
        recipesList = new JList();
        selectRecipeButton = new JButton();
        scrollPane2 = new JScrollPane();
        recipeTextArea = new JTextArea();
        label1 = new JLabel();
        label2 = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {

            //---- recipesList ----
            recipesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            scrollPane1.setViewportView(recipesList);
            setListSelectionListener();
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(5, 25, 105, 215);

        //---- selectRecipeButton ----
        selectRecipeButton.setText("Choose recipe");
        contentPane.add(selectRecipeButton);
        selectRecipeButton.setBounds(new Rectangle(new Point(130, 215), selectRecipeButton.getPreferredSize()));

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(recipeTextArea);
        }
        contentPane.add(scrollPane2);
        scrollPane2.setBounds(130, 30, 240, 175);

        //---- label1 ----
        label1.setText("Recipes List");
        contentPane.add(label1);
        label1.setBounds(5, 5, 105, label1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("Recipe");
        contentPane.add(label2);
        label2.setBounds(130, 5, 235, label2.getPreferredSize().height);

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

    public void setRecipesListData(Object[] items) {
        recipesList.setListData(items);
    }

    public void setListSelectionListener() {
        recipesList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (recipesList.getSelectedValue() != null) {
                    recipeTextArea.setText(recipesList.getSelectedValue().toString());
                }
            }
        });
    }

    public void setStartBrewingListener(ActionListener listener) {
        selectRecipeButton.addActionListener(listener);
    }

    public Recipe getSelectedRecipe() {
        ArgumentsValidator.nullReturn(recipesList.getSelectedValue());
        return (Recipe) recipesList.getSelectedValue();
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Arkadiusz Pikulski
    private JScrollPane scrollPane1;
    private JList recipesList;
    private JButton selectRecipeButton;
    private JScrollPane scrollPane2;
    private JTextArea recipeTextArea;
    private JLabel label1;
    private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
