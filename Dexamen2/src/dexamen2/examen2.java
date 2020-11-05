package dexamen2;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author antcha
 */
public class examen2 extends JFrame {

    JPanel panel = new JPanel();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();

    private ButtonGroup optionsGroup;
    private JRadioButton radio1;
    private JRadioButton radio2;
    private JRadioButton radio3;

    JButton boton = new JButton("ok");

    private String[] imagenes = {"linux", "mac", "windows"};
    private Icon img;
    private JLabel label;

    private String[] images = {"Rabbit", "Cat", "Dog"};

    public examen2() {
        setTitle(" Examen2");
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.setLayout(new GridLayout(3, 1));

        System.out.println(System.getProperty("java.class.path"));
        //imagenes codigo anado solo la primera foto
        /*    img = new ImageIcon(getClass().getResource("imagenes/linux.png"));
        label = new JLabel();
        label.setIcon(img);
        panel2.add(label);*/

        img = new ImageIcon(getClass().getResource("images/Rabbit.gif"));
        label = new JLabel();
        label.setText("Rabbit");
        label.setIcon(img);
        panel2.add(label);

        System.out.println(System.getProperty("java.class.path"));
        radio1 = new JRadioButton("linux", false);
        radio2 = new JRadioButton("mac", false);
        radio3 = new JRadioButton("mac", false);

        //creo una relacion logica entre los objetos RadioButton
        optionsGroup = new ButtonGroup();
        optionsGroup.add(radio1);
        optionsGroup.add(radio2);
        optionsGroup.add(radio3);
        panel1.add(radio1);
        panel1.add(radio2);
        panel1.add(radio3);

        buttonsescuchar manejador1 = new buttonsescuchar();
        radio1.addActionListener(manejador1);
        radio2.addActionListener(manejador1);
        radio3.addActionListener(manejador1);

        panel3.add(boton);
        buttonsescuchar bl = new buttonsescuchar();
        boton.addActionListener(bl);

        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);
        add(panel);

    }

    class manejador1 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == radio1) {

                img = new ImageIcon(getClass().getResource("images/Dog.gif"));
                label = new JLabel();
               
                label.setIcon(img);
                panel2.add(label);

            }
            if (e.getSource() == radio1) {
                img = new ImageIcon(getClass().getResource("images/Cat.gif"));
                label = new JLabel();
           
                label.setIcon(img);
                panel2.add(label);
            }
        }

    }

    class buttonsescuchar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == boton) {
                JOptionPane.showMessageDialog(null, "has seleccionado");

            }

        }

    }
}
