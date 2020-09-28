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
        setLayout(new FlowLayout());
        label = new JLabel();
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        daugthersCheckBox = new JCheckBox("Daugthers");
        sonsCheckBox = new JCheckBox("Sons");
        noneCheckBox = new JCheckBox("None");
        add(daugthersCheckBox);
        add(sonsCheckBox);
        add(noneCheckBox);
        ListenerCheckBox manejador1 = new ListenerCheckBox();
        daugthersCheckBox.addItemListener(manejador1);
        sonsCheckBox.addItemListener(manejador1);
        noneCheckBox.addItemListener(manejador1);

        //creo los botons 
        maleJRadioButton = new JRadioButton("Male", true);
        femaleJRadioButton = new JRadioButton("Female", false);
        add(maleJRadioButton);
        add(femaleJRadioButton);
        maleJRadioButton.addItemListener(new ListenerCheckBox());

        //creo una relacion logica entre los objetos RadioButton
        optionsGroup = new ButtonGroup();
        optionsGroup.add(maleJRadioButton);
        optionsGroup.add(femaleJRadioButton);

        add(label);

    }

    private class ListenerCheckBox implements ItemListener {

        private boolean dauthers;
        private String dau;
        private String sons;
        private String none;
        private String male;
        private String dos;
        private String female;

        
        public void itemStateChanged(ItemEvent event) {
            if (event.getSource() == daugthersCheckBox) {
                dau = "tengo hijas";
                label.setText(dau);
            }
            if (event.getSource() == sonsCheckBox) {
                sons = "you are sons";
                label.setText(sons);
            } else if (event.getSource() == sonsCheckBox && event.getSource() == daugthersCheckBox) {
                dos = "You are sons and daugthers";
                label.setText(dos);
            } else if (event.getSource() == noneCheckBox) {
                none = "no tengo hijos";
                label.setText(none);
            }
            /*if(maleJRadioButton.isSelected()==true){
                male = "and you are male";
                label.setText(male);
            }*/

        }

    }

}
