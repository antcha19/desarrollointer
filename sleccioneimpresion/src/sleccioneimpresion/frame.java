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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
    private JTextArea area;

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

        //acceder a la base de datos , tambien tenemos  que selecionas el driver
        String url = "jdbc:mysql://localhost:3306/di?useSSL=false&useTimezone="
                + "true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        try {
            //puede ser que sea requerido lo siguiente
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url, "root", "serpis");
            Statement instruccion = (Statement) conexion.createStatement();
            //sentencia sql 
            String sql = "Select id from clients";
            ResultSet resultado = instruccion.executeQuery(sql);

            while (resultado.next()) {
                listModel.addElement(resultado.getString("id"));

            }
            //añadimos la listmodel a la Jlist
            list = new JList(listModel);
            panel2.add(list);

            resultado.close();
            instruccion.close();
            conexion.close();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace(System.out);
        }

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
