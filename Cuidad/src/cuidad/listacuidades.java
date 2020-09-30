/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuidad;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.ListSelectionModel;

/**
 *
 * @author antcha
 */
public class listacuidades extends JFrame {

    private JPanel panel = new JPanel();
    private JList listCuidad;
    private JList listname;
    private JLabel label2, label3;
    private final String namecities[] = {"Bruselas", "Amsterdan", "Belfast", "Edimburgo",
         "Madrid", "Granada"};
    private final String names[] = {"Pepito", "Pepito2", "Pepito3", "Pepito4",
         "Pepito5", "Pepito5"};

    public listacuidades() {
        setTitle("Cuidad");
        setSize(600, 600);
        //añado la lista al panel
        panel.setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JLabel label = new JLabel("Select your city");
        label.setForeground(Color.red);
        label2 = new JLabel();
        label3 = new JLabel();
        //codigo lista
        listCuidad = new JList(namecities);
        listCuidad.setVisibleRowCount(3);
        listCuidad.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //añado la lista al panel
        panel.setLayout(new FlowLayout());
        //uso un objeto scrollopne
        panel.add(new JScrollPane(listCuidad));
        //codigo listanombre
        listname = new JList(names);
        listname.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        //uso un objeto scrollopne
        panel.add(new JScrollPane(listname));
        listname.addListSelectionListener(new listlistenername());
        
        //añadimos al panel
        panel.add(label);
        panel.add(label2);
        panel.add(label3);
        add(panel);

        listCuidad.addListSelectionListener(new listlistener());

    }

    private class listlistener implements ListSelectionListener {

        public void valueChanged(ListSelectionEvent e) {
            label2.setText("Select " + namecities[listCuidad.getSelectedIndex()]);
        }
    }
    
    private class listlistenername implements ListSelectionListener {

        public void valueChanged(ListSelectionEvent e) {
            label3.setText( names[listname.getSelectedIndex()] );
        }
    }
}
