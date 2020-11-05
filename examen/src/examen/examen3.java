/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

import java.awt.Component;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListModel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author antcha
 */
public class examen3 extends JFrame {

    JPanel panel = new JPanel();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JLabel label1 = new JLabel("Nombre");
    JLabel label2 = new JLabel("Apellidos");
    JTextField text1 = new JTextField();
    JTextField text2 = new JTextField();
    JList lista = new JList();
    JButton boton = new JButton("Añadir");
    JButton boton2 = new JButton("Add");
    
     private DefaultListModel listModel = new DefaultListModel();

    private JComboBox combo = new JComboBox();

    public examen3() {

        setTitle(" Examen2");
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.setLayout(new GridLayout(3, 1));

        panel1.setLayout(new GridLayout(2, 2));
        panel1.add(label1);
        panel1.add(text1);
        panel1.add(label2);
        panel1.add(text2);

        panel2.setLayout(new GridLayout(1, 3));
        listModel.addElement(text1 );
        listModel.addElement(text2 );
             lista = new JList(listModel);
        panel2.add(lista);
        panel2.add(panel3);
        panel3.setLayout(new GridLayout(2, 1));
        panel3.add(boton);
        panel3.add(boton2);
        panel2.add(combo);

        //botones 
        boton.addActionListener(new Listener());
        boton2.addActionListener(new Listener2());
         

        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);
        add(panel);

    }

    class Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
           listModel.addElement(text1);
           
            
        }
    }
    class Listener2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
             int indice = lista.getSelectedIndex();
           if(indice >= 0){
               
           }
           
            
        }
    }

}
