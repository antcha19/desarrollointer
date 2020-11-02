/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dejemplo;

import javax.swing.JFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

public class Dejemploframe extends JFrame {

    private JButton select;
    private JPanel panel = new JPanel();
    private JPanel panel1;
    private JList list;
    private DefaultListModel listModel1 = new DefaultListModel();
    private JComboBox combo;
    private String[] tema = {"asdas", "2 asdasd"};

    public Dejemploframe() {
        setTitle("Ejercicio");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.setLayout(new GridLayout(1, 2));

        panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        combo = new JComboBox(tema);
        panel1.add(combo);
        //esichca el combo
        combo.addItemListener((ItemListener) new ListenerCombo());
        select = new JButton("Seleccionar");
        //escucha el boton
        select.addActionListener(new ButtonListener());
        panel1.add(select, BorderLayout.SOUTH);
        panel.add(panel1);

        for (int i = 1; i < 10; i++) {
            listModel1.addElement("1 DAM asignatura " + i);
        }
        list = new JList(listModel1);
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        panel.add(new JScrollPane(list));
        add(panel);

    }

    private class ListenerCombo implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            int indice = combo.getSelectedIndex();
            if (indice == 0) {
                listModel1.removeAllElements();
                for (int i = 1; i < 10; i++) {
                    listModel1.addElement("numero1 " + i);
                }
            } else if (indice == 1) {
                listModel1.removeAllElements();
                for (int i = 1; i < 10; i++) {
                    listModel1.addElement("numero2 " + i);
                }
            }

        }
    }
    
    class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            int[] indices = list.getSelectedIndices();

            String salida = " Escogidas: ";
            for (int i = 0; i < indices.length; i++) {
                if (i == indices.length - 1) {
                    salida =salida + listModel1.getElementAt(indices[i]);

                } else {

                    salida =salida+ listModel1.getElementAt(indices[i]) + ", ";
                }
            }
            //ventana de dialogo que avisa lo escogido
            JOptionPane.showMessageDialog(null, salida);

        }

    }
}