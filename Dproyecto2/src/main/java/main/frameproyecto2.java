/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import static datos.Conexion.getConnection;
import java.sql.PreparedStatement;
import datos.PeliculaDAO;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;

/**
 *
 * @author antonio
 */
public class frameproyecto2 extends JFrame {

    private DefaultTableModel model;
    private JTable jTable1;
    private JScrollPane jscrollPanel1;
    //algunos paneles necesarios
    JPanel panel = new JPanel();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JButton bupdate = new JButton("UPDATE");
    JButton bborrar = new JButton("BORRAR");
    JButton binsert = new JButton("INSERTAR");

    JLabel Id = new JLabel("ID");
    JLabel Name = new JLabel("NAME");
    JLabel Year = new JLabel("YEAR");
    JLabel Tipe = new JLabel("TIPE");
    
    JTextField idtext = new JTextField();
    JTextField nametext = new JTextField();
    JTextField yeartext = new JTextField();
    JTextField tipotext = new JTextField();
    public frameproyecto2() {

        setTitle(" Examen1");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel.setLayout(new GridLayout(3, 1));
        TitledBorder title;
        title = BorderFactory.createTitledBorder("tabla");
        panel1.setBorder(title);

        //tabla
        model = new DefaultTableModel();
        // configuration columns of the DefaultTableModel
        Object[] tags = new Object[4];
        tags[0] = "Id";
        tags[1] = "Name";
        tags[2] = "Year";
        tags[3] = "Tipe";
        jTable1 = new JTable();
        model.setColumnIdentifiers(tags);
        //añado el model a ala tabla
        jTable1.setModel(model);
        jscrollPanel1 = new JScrollPane(jTable1);
        panel1.add(jscrollPanel1, BorderLayout.CENTER);

        TitledBorder title2;
        title2 = BorderFactory.createTitledBorder("Datos");
        panel2.setBorder(title2);
        panel2.setLayout(new GridLayout(4, 2));
        panel2.add(Id);
        panel2.add(idtext);
        panel2.add(Name);
        panel2.add(nametext);
        panel2.add(Year);
        panel2.add(yeartext);
        panel2.add(Tipe);
        panel2.add(tipotext);

        TitledBorder title3;
        title3 = BorderFactory.createTitledBorder("Botones");
        panel3.setBorder(title3);
        panel3.add(binsert);
        panel3.add(bupdate);
        panel3.add(bborrar);

        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);

        add(panel);

    }

}
