/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciohijos;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JCheckBox;

public class frasehijos extends JFrame {

    private JTextField textField;
    private JCheckBox daugthersCheckBox;
    private JCheckBox sonsCheckBox;
    private JCheckBox noneCheckBox;
    private JLabel label;

    //radioBotton
    // grupo de botones que contiene los botones de opción
    private ButtonGroup optionsGroup;
    private JRadioButton maleJRadioButton;
    private JRadioButton femaleJRadioButton;

    public frasehijos() {

        setTitle("frase");
        setSize(300,300);
        setLayout(new FlowLayout());
        label = new JLabel();
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        daugthersCheckBox = new JCheckBox("Daugthers");
        sonsCheckBox = new JCheckBox("Sons");
        noneCheckBox = new JCheckBox("None");
        add(daugthersCheckBox);
        add(sonsCheckBox);
        add(noneCheckBox);
        Listener manejador1 = new Listener();
        daugthersCheckBox.addItemListener(manejador1);
        sonsCheckBox.addItemListener(manejador1);
        noneCheckBox.addItemListener(manejador1);

        //creo los botons 
        maleJRadioButton = new JRadioButton("Male", true);
        femaleJRadioButton = new JRadioButton("Female", false);
        add(maleJRadioButton);
        add(femaleJRadioButton);

        //creo una relacion logica entre los objetos RadioButton
        optionsGroup = new ButtonGroup();
        optionsGroup.add(maleJRadioButton);
        optionsGroup.add(femaleJRadioButton);
        femaleJRadioButton.addItemListener(manejador1);
        maleJRadioButton.addItemListener(manejador1);
        add(label);

    }

    private class Listener implements ItemListener {

        private String none;
        private String result;
        private String result1;

        public void itemStateChanged(ItemEvent event) {
            if (event.getSource() == daugthersCheckBox) {
                result1 = "You have daugthers ";
                label.setText(result1);
            } else if (event.getSource() == sonsCheckBox) {
                result1 = "You have sons ";
                label.setText(result1);
            }
            if (event.getSource() == sonsCheckBox) {
                result1 = "You have sons ";
                label.setText(result1);
            } else if (event.getSource() == daugthersCheckBox) {
                result1 = "You have daugthers ";
                label.setText(result1);
            }
            if (event.getSource() == noneCheckBox) {
                result1 = "I do not have ";
                label.setText(result1);
            }else if (event.getSource() == sonsCheckBox) {
                result1 = "You have sons ";
                label.setText(result1);
            }else if(event.getSource() == daugthersCheckBox) {
                result1 = "You have daugthers ";
                label.setText(result1);
            }

           
            if (maleJRadioButton.isSelected() == true) {
                result = "and you are male ";
                label.setText(result);
            } else if (femaleJRadioButton.isSelected() == true) {
                result = "and you are female ";
                label.setText(result);
            }
            label.setText(result1 + result);

        }

       

    }

}
