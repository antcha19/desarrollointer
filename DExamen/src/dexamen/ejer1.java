/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dexamen;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 *
 * @author antcha
 */
class ejer1 extends JFrame {

    //algunos paneles necesarios
    JPanel panel = new JPanel();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JButton boton = new JButton("mortaledo");
    JButton boton2 = new JButton("filemon");
    JButton boton3 = new JButton("carpanta");
    JButton boton4 = new JButton("rompetechos");
    JButton boton5 = new JButton("pep gotera");
    JButton boton6 = new JButton("Otilio");
    JToggleButton toggle = new JToggleButton("mortaledo");
    JToggleButton toggle2 = new JToggleButton("filemon");
    JToggleButton toggle3 = new JToggleButton("carpanta");
    JToggleButton toggle4 = new JToggleButton("rompetechos");
    JToggleButton toggle5 = new JToggleButton("pepe gotera");
    JToggleButton toggle6 = new JToggleButton("Otilio");

    private JCheckBox check = new JCheckBox("mortaledo");
    private JCheckBox check2 = new JCheckBox("filemon");
    private JCheckBox check3 = new JCheckBox("carpanta");
    private JCheckBox check4 = new JCheckBox("rompetechos");
    private JCheckBox check5 = new JCheckBox("pepe gotera");
    private JCheckBox check6 = new JCheckBox("Otilio");

    private ButtonGroup grupo = new ButtonGroup();
    private JRadioButton radio1 = new JRadioButton("mortaledo", false);
    private JRadioButton radio2 = new JRadioButton("filemon", false);
    private JRadioButton radio3 = new JRadioButton("carpanta", false);
    private JRadioButton radio4 = new JRadioButton("rompetechos", false);
    private JRadioButton radio5 = new JRadioButton("pepe gotera", false);
    private JRadioButton radio6 = new JRadioButton("Otilio", true);
  
    public ejer1() {
        setTitle(" Examen1");
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel.setLayout(new GridLayout(4, 1));
        TitledBorder title;
        title = BorderFactory.createTitledBorder("JButton");
        panel1.setBorder(title);
        panel1.add(boton);
        panel1.add(boton2);
        panel1.add(boton3);
        panel1.add(boton4);
        panel1.add(boton5);
        panel1.add(boton6);

        TitledBorder title2;
        title2 = BorderFactory.createTitledBorder("JTootleButton");
        panel2.setBorder(title2);
        panel2.add(toggle);
        panel2.add(toggle2);
        panel2.add(toggle3);
        panel2.add(toggle4);
        panel2.add(toggle5);
        panel2.add(toggle6);

        TitledBorder title3;
        title3 = BorderFactory.createTitledBorder("JCheckBox");
        panel3.setBorder(title3);
        panel3.add(check);
        panel3.add(check2);
        panel3.add(check3);
        panel3.add(check4);
        panel3.add(check5);
        panel3.add(check6);

        TitledBorder title4;
        title4 = BorderFactory.createTitledBorder("JradioButton");
        panel4.setBorder(title4);

        
        grupo.add(radio1);
        grupo.add(radio2);
        grupo.add(radio3);
        grupo.add(radio4);
        grupo.add(radio5);
        grupo.add(radio6);
        
        panel4.add(radio1);
        panel4.add(radio2);
        panel4.add(radio3);
        panel4.add(radio4);
        panel4.add(radio5);
        panel4.add(radio6);
      

        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);
        panel.add(panel4);
        add(panel);

    }
}
