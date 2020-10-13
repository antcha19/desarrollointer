/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import controller.controller;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import model.show;

/**
 *
 * @author antcha
 */
public class frame extends JFrame {

    private JPanel panel = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel panel3 = new JPanel();
    private JLabel label1, label2, label3, label4, label5, label6, label7;
    private JTextField textf1, textf2, textf3, textf4, textf5, textf6, textf7;
    private JButton boton1, boton2, boton3, boton4, boton5, boton6, boton7;
    //necesito un objeto para el controlador
    private controller c = null;
    
    //combo
    private  JComboBox combo;
    private String[] empresas={"Netflix", "Amazon", "HBO"};
    

    public frame(controller control) {
        c = control;
        setTitle("my series");
        setSize(600 ,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.setLayout(new BorderLayout());
        panel2.setLayout(new GridLayout(7, 2, 10, 10));
        panel3.setLayout(new FlowLayout());
        add(panel);
        panel.add(panel3, BorderLayout.NORTH);
        panel.add(panel2, BorderLayout.CENTER);
        boton1 = new JButton("|<");
        boton2 = new JButton("<");
        boton3 = new JButton(">");
        boton4 = new JButton(">|");
        boton5 = new JButton("+");
        boton6 = new JButton("-");
        boton7 = new JButton("*");
        panel3.add(boton1);
        panel3.add(boton2);
        panel3.add(boton3);
        panel3.add(boton4);
        panel3.add(boton5);
        panel3.add(boton6);
        panel3.add(boton7);
        label1 = new JLabel("title");
        textf1 = new JTextField(50);
        panel2.add(label1);
        panel2.add(textf1);
        label2 = new JLabel("screenwriter");
        textf2 = new JTextField(50);
        panel2.add(label2);
        panel2.add(textf2);
        label3 = new JLabel("season");
        textf3 = new JTextField(50);
        panel2.add(label3);
        panel2.add(textf3);
        label4 = new JLabel("genre");
        textf4 = new JTextField(50);
        panel2.add(label4);
        panel2.add(textf4);
        label5 = new JLabel("seen seasion");
        textf5 = new JTextField(50);
        panel2.add(label5);
        panel2.add(textf5);
        label6 = new JLabel("platform");
        textf6 = new JTextField(50);
        panel2.add(label6);
        panel2.add(textf6);
        
        //combo 
        combo = new JComboBox(empresas);
       
        combo.addItemListener(new Listenercombo());

        textf1.setEditable(false);
        textf2.setEditable(false);
        textf3.setEditable(false);
        textf4.setEditable(false);
        textf5.setEditable(false);
        textf6.setEditable(false);
        //  textf7.setEditable(false);

        //escuchar botones
        buttonsListener bl = new buttonsListener();
        boton1.addActionListener(bl);
        boton2.addActionListener(bl);
        boton3.addActionListener(bl);
        boton4.addActionListener(bl);
        boton5.addActionListener(bl);
        boton6.addActionListener(bl);
        boton6.addActionListener(bl);

    }

    class buttonsListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            show s = new show();
            if (e.getSource() == boton1) {
                s = c.first();
            }
            if (e.getSource() == boton2) {
                s = c.previous();
            }
            if (e.getSource() == boton3) {
                s = c.next();
            }
            if (e.getSource() == boton4) {
                s = c.last();
            }
            
           if (e.getSource() == boton5) {
                if (boton5.getText().equals("+")) {
                    //activar combo
                    combo.setVisible(true);
                    panel2.add(combo);
                    //vaciar textfield
                    textf1.setText("");
                    textf2.setText("");
                    textf3.setText("");
                    textf4.setText("");
                    textf5.setText("");
                    textf6.setText("");
                    boton1.setEnabled(false);
                    boton2.setEnabled(false);
                    boton3.setEnabled(false);
                    boton4.setEnabled(false);
                    boton6.setEnabled(false);
                    boton7.setEnabled(false);

                    boton5.setText("+++");
                    textf1.setEditable(true);
                    textf2.setEditable(true);
                    textf3.setEditable(true);
                    textf4.setEditable(true);
                    textf5.setEditable(true);
                    textf6.setEditable(true);
                }
                else{
                    //habilitar botones
                    boton1.setEnabled(true);
                    boton2.setEnabled(true);
                    boton3.setEnabled(true);
                    boton4.setEnabled(true);
                    boton6.setEnabled(true);
                    boton7.setEnabled(true);
                    boton5.setText("+");
                   // desactivar combo
                    combo.setVisible(false);
                    //tomar los datos tecleados en los textfields
                    s=fillShow();
                    //llamar al metodo nuevo del controller
                    c.nuevo(s); 
                }
            }
            updating(s);
        }

    }
    
    //escucha el combo
    private class Listenercombo implements ItemListener{
        public void itemStateChanged(ItemEvent e){
            int indice=combo.getSelectedIndex();
            String s = empresas[indice];
            textf6.setText(s);
        }
        
    }
    private show fillShow(){
        show s= new show(textf1.getText(),textf2.getText(),Integer.parseInt(textf3.getText()),
        textf4.getText(),Integer.parseInt(textf5.getText()),textf6.getText());
        return s;
    }
    

    private void updating(show s) {
        textf1.setText(s.getTitle());
        textf2.setText(s.getScripwriter());
        textf3.setText(String.valueOf(s.getSeasons()));
        textf4.setText(s.getGenre());
        textf5.setText(String.valueOf(s.getViews()));
        textf6.setText(s.getPlataforma());
        
    }
    
    
    

}
