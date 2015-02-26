/*
 * Created by JFormDesigner on Wed Feb 25 11:50:56 CET 2015
 */

package express.example.implementation.view.forms;

import javax.swing.*;
import java.awt.*;

/**
 * @author Arkadiusz Pikulski
 */
public class CreateRecipeMenu extends JFrame {
    public CreateRecipeMenu() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Arkadiusz Pikulski
        recipeNameField = new JTextField();
        scrollPane1 = new JScrollPane();
        ingedientsList = new JList();
        label1 = new JLabel();
        label2 = new JLabel();
        scrollPane2 = new JScrollPane();
        additivesList = new JList();
        label3 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        scrollPane3 = new JScrollPane();
        currentRecipe = new JTextArea();
        button3 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        contentPane.add(recipeNameField);
        recipeNameField.setBounds(105, 5, 265, recipeNameField.getPreferredSize().height);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(ingedientsList);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(10, 55, 75, 175);

        //---- label1 ----
        label1.setText("Recipe Name");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(10, 5), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText("Ingredients");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(10, 30), label2.getPreferredSize()));

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(additivesList);
        }
        contentPane.add(scrollPane2);
        scrollPane2.setBounds(105, 55, 75, 170);

        //---- label3 ----
        label3.setText("Additives");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(105, 30), label3.getPreferredSize()));

        //---- button1 ----
        button1.setText("Add Ingredient");
        contentPane.add(button1);
        button1.setBounds(5, 235, 80, 26);

        //---- button2 ----
        button2.setText("Add Additive");
        contentPane.add(button2);
        button2.setBounds(105, 235, 75, button2.getPreferredSize().height);

        //======== scrollPane3 ========
        {

            //---- currentRecipe ----
            currentRecipe.setEditable(false);
            scrollPane3.setViewportView(currentRecipe);
        }
        contentPane.add(scrollPane3);
        scrollPane3.setBounds(200, 50, 145, 175);

        //---- button3 ----
        button3.setText("Create Recipe");
        contentPane.add(button3);
        button3.setBounds(205, 235, 140, button3.getPreferredSize().height);

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


    public void setIngredientsList(Object[] items) {
        ingedientsList.setListData(items);
    }

    public void setAdditivesList(Object[] items) {
        additivesList.setListData(items);
    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Arkadiusz Pikulski
    private JTextField recipeNameField;
    private JScrollPane scrollPane1;
    private JList ingedientsList;
    private JLabel label1;
    private JLabel label2;
    private JScrollPane scrollPane2;
    private JList additivesList;
    private JLabel label3;
    private JButton button1;
    private JButton button2;
    private JScrollPane scrollPane3;
    private JTextArea currentRecipe;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
