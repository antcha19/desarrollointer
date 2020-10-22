/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sleccioneimpresion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;

/**
 *
 * @author antcha
 */
public class frame extends JFrame {

    private JButton boton1, boton2, boton3;
    private JList list;
    private DefaultListModel listModel = new DefaultListModel();
    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel();

    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    private JTextField text;
    

    private final String namescolours[] = {"Black", "grey", "green", "Light grey", "magenta", "orange", "pink", "white", "yellow"};

    public frame() {
        setTitle("seleccion e impresion");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //panel

        panel.setLayout(new BorderLayout());
        //panel botones 
        panel3.setLayout(new GridLayout(3, 1, 10, 10));

        boton1 = new JButton("<<<");
        boton2 = new JButton(">>>");
        boton3 = new JButton("Imprimir");
        panel3.add(boton1);
        panel3.add(boton2);
        panel3.add(boton3);
        panel.add(panel2, BorderLayout.WEST);
        panel.add(panel3, BorderLayout.CENTER);
        panel.add(panel4, BorderLayout.EAST);
        add(panel);
        list = new JList(namescolours);
        panel2.add(list);
        
        
        

    }

}
