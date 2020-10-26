/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sleccioneimpresion;

import java.awt.BorderLayout;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import java.sql.SQLException;
import DAO.all;
import DAO.client;
import java.util.*;

/**
 *
 * @author antcha
 */
public class frame extends JFrame {

    private JButton boton1, boton2, boton3;
    private JList list, list2;
    private DefaultListModel listModel = new DefaultListModel();
    private DefaultListModel listModel2 = new DefaultListModel();
    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();

    public frame() throws SQLException {
        setTitle("seleccion e impresion");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //panel

        panel.setLayout(new BorderLayout());
        //panel botones 
        panel3.setLayout(new GridLayout(3, 1, 10, 10));
        boton1 = new JButton(">>>>");
        boton2 = new JButton("<<<<");
        boton3 = new JButton("Imprimir");

        //botones
        panel3.add(boton1);
        panel3.add(boton2);
        panel3.add(boton3);
        panel.add(panel2, BorderLayout.WEST);
        panel.add(panel3, BorderLayout.CENTER);
        panel.add(panel4, BorderLayout.EAST);
        add(panel);

        ArrayList<client> listac = new ArrayList<>();
        listac = all.obtainData();
        //foreach para recorrer el arraylist
        for (client cli : listac) {
            String id = cli.getId();
            String notas = cli.getNotes();
            //añado la id a la listMOdel
            listModel.addElement(id);
        }

        list = new JList(listModel);
        panel2.add(list);
        list2 = new JList(listModel2);
        panel4.add(list2);

        //boton uno
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s;
                //toma el indice del elemnto seleccionado de la list
                int index = list.getSelectedIndex();
                if (index >= 0) {
                    //devuelve el valor selecionado
                    s = (String) listModel.get(index);
                    listModel.remove(index);
                    //anadira a la listamodel2
                    listModel2.addElement(s);
                }
            }

        });

        // boton dos
        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //toma el indice del elemnto seleccionado de la list
                int index = list2.getSelectedIndex();
                if (index >= 0) {
                    String devuelve = (String) listModel2.get(index);
                    //eliminara de la lista
                    listModel2.remove(index);
                    //anadira a la listamodel
                    listModel.addElement(devuelve);
                }
            }

        });

    }
}
