package dejemplo2;


import javax.swing.*;
import java.awt.*;
import javax.swing.border.TitledBorder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author antonio
 */
public class Dejemplo2frame extends JFrame {
    
    private JPanel panelPrin = new JPanel();
    private JPanel panelPreguntas, panelPre1, panelPre2, panelPre3, panelPre4, panelPre5;
    private JLabel lblPre1, lblPre2, lblPre3, lblPre4, lblPre5;
    private JRadioButton pre1a, pre1b, pre1c, pre2a, pre2b, pre2c, pre3a, pre3b, pre3c, pre4a, pre4b, pre4c, pre5a, pre5b, pre5c;
    private ButtonGroup grpre1, grpre2, grpre3, grpre4, grpre5;
    private JButton btnCorregir;
    public Dejemplo2frame(){
         setTitle("Test");
        setSize(600, 1000);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panelPrin.setLayout(new BorderLayout());
        panelPreguntas = new JPanel();
        panelPreguntas.setLayout(new GridLayout(5, 1));
        panelPre1 = new JPanel();
        panelPre1.setLayout(new GridLayout(4, 1));
        TitledBorder titlepre1 = BorderFactory.createTitledBorder("Pregunta: 1");
        panelPre1.setBorder(titlepre1);
        lblPre1 = new JLabel("¿Qué es la máquina Virtual de Java?");
        panelPre1.add(lblPre1);
        //false sirve para no seleccionar automaticamente
        pre1a = new JRadioButton("Una máquina de cafés", false);
        pre1b = new JRadioButton("El sw que se encarga de interpretar el código Java y ejecutarlo", false);
        pre1c = new JRadioButton("Ambas son correctas", false);
        grpre1 = new ButtonGroup();
        grpre1.add(pre1a);
        grpre1.add(pre1b);
        grpre1.add(pre1c);
        panelPre1.add(pre1a);
        panelPre1.add(pre1b);
        panelPre1.add(pre1c);
        panelPreguntas.add(panelPre1);

        panelPre2 = new JPanel();
        panelPre2.setLayout(new GridLayout(4, 1));

        TitledBorder titlepre2 = BorderFactory.createTitledBorder("Pregunta: 2");
        panelPre2.setBorder(titlepre2);
        lblPre2 = new JLabel("Las clases Swing");
        panelPre2.add(lblPre2);
        pre2a = new JRadioButton("Dan soporte a los GUI", false);
        pre2b = new JRadioButton("Son clases de baile", false);
        pre2c = new JRadioButton("Ambas son correctas", false);
        grpre2 = new ButtonGroup();
        grpre2.add(pre2a);
        grpre2.add(pre2b);
        grpre2.add(pre2c);
        panelPre2.add(pre2a);
        panelPre2.add(pre2b);
        panelPre2.add(pre2c);
        panelPreguntas.add(panelPre2);

        panelPre3 = new JPanel();
        panelPre3.setLayout(new GridLayout(4, 1));

        TitledBorder titlepre3 = BorderFactory.createTitledBorder("Pregunta: 3");
        panelPre3.setBorder(titlepre3);
        lblPre3 = new JLabel("JavaFX es:");
        panelPre3.add(lblPre3);
        pre3a = new JRadioButton("Los efectos especiales de Java", false);
        pre3b = new JRadioButton("El nuevo soporte GUI de Java", false);
        pre3c = new JRadioButton("Ambas son correctas", false);
        grpre3 = new ButtonGroup();
        grpre3.add(pre3a);
        grpre3.add(pre3b);
        grpre3.add(pre3c);
        panelPre3.add(pre3a);
        panelPre3.add(pre3b);
        panelPre3.add(pre3c);
        panelPreguntas.add(panelPre3);

        panelPre4 = new JPanel();
        panelPre4.setLayout(new GridLayout(4, 1));

        TitledBorder titlepre4 = BorderFactory.createTitledBorder("Pregunta: 4");
        panelPre4.setBorder(titlepre4);
        lblPre4 = new JLabel("¿NetBeans es peor que Eclipse?");
        panelPre4.add(lblPre4);
        pre4a = new JRadioButton("Si, pero sólo se puede desarrollar en Java", false);
        pre4b = new JRadioButton("No, pero Eclipse es de pago", false);
        pre4c = new JRadioButton("A y B son incorrectas", false);
        grpre4 = new ButtonGroup();
        grpre4.add(pre4a);
        grpre4.add(pre4b);
        grpre4.add(pre4c);
        panelPre4.add(pre4a);
        panelPre4.add(pre4b);
        panelPre4.add(pre4c);
        panelPreguntas.add(panelPre4);

        panelPre5 = new JPanel();
        panelPre5.setLayout(new GridLayout(4, 1));

        TitledBorder titlepre5 = BorderFactory.createTitledBorder("Pregunta: 5");
        panelPre5.setBorder(titlepre5);
        lblPre5 = new JLabel("¿Oracle es la compañia propietaria de Java?");
        panelPre5.add(lblPre5);
        pre5a = new JRadioButton("Si", false);
        pre5b = new JRadioButton("No", false);
        pre5c = new JRadioButton("Sólo del 50%", false);
        grpre5 = new ButtonGroup();
        grpre5.add(pre5a);
        grpre5.add(pre5b);
        grpre5.add(pre5c);
        panelPre5.add(pre5a);
        panelPre5.add(pre5b);
        panelPre5.add(pre5c);
        panelPreguntas.add(panelPre5);
        panelPrin.add(panelPreguntas);
        btnCorregir = new JButton("Corregir");
        panelPrin.add(btnCorregir, BorderLayout.SOUTH);
        add(panelPrin);
        
    }
}
