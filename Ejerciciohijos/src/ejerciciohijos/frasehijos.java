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

    //radioBotton
    // grupo de botones que contiene los botones de opción
    private ButtonGroup optionsGroup;
    private JRadioButton maleJRadioButton;
    private JRadioButton femaleJRadioButton;
    public frasehijos() {

        setTitle("frase");
        setLayout(new FlowLayout());
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
        maleJRadioButton = new JRadioButton("Male");
        femaleJRadioButton = new JRadioButton("Female");
        add(maleJRadioButton);
        add(femaleJRadioButton);
      //  maleJRadioButton.addItemListener(new );
        
        
        //creo una relacion logica entre los objetos RadioButton
        optionsGroup = new ButtonGroup();
        optionsGroup.add(maleJRadioButton);
        optionsGroup.add(femaleJRadioButton);
        
        //creo el textfield
        textField = new JTextField(20);
        add(textField); 

    }
    private class ListenerCheckBox implements ItemListener{
        public void itemStateChanged(ItemEvent event){
            
        }
    }

}
