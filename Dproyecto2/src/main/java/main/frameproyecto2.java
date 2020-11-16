/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import datos.Conexion;
import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import static datos.Conexion.getConnection;
import java.sql.PreparedStatement;
import datos.PeliculaDAO;
import domain.Pelicula;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

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
    JButton bactualizar = new JButton("SELECT");

    JLabel Id = new JLabel("ID");
    JLabel Name = new JLabel("NAME");
    JLabel Year = new JLabel("YEAR");
    JLabel Type = new JLabel("TYPE");

    JTextField idtext = new JTextField();
    JTextField nametext = new JTextField();
    JTextField yeartext = new JTextField();
    JTextField tipotext = new JTextField();

    public frameproyecto2() throws SQLException {

        setTitle(" proyecto2");
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
        tags[3] = "Type";
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
        //panel y textfiel de ID
        panel2.add(Id);
        panel2.add(idtext);
        idtext.setEnabled(false);
        //panel y textfiel de Name
        panel2.add(Name);
        panel2.add(nametext);
        nametext.setEnabled(false);
        //panel y textfiel del Ano
        panel2.add(Year);
        panel2.add(yeartext);
        yeartext.setEnabled(false);
        //panel y textfiel del tipo
        panel2.add(Type);
        panel2.add(tipotext);
        tipotext.setEnabled(false);

        TitledBorder title3;
        title3 = BorderFactory.createTitledBorder("Botones");
        panel3.setBorder(title3);
        //anado los botones
        panel3.add(binsert);
        panel3.add(bupdate);
        panel3.add(bborrar);
        panel3.add(bactualizar);

        //prepararo todos los botones para que escuchen
        bborrar.addActionListener(new Butonborrar());
        bactualizar.addActionListener(new Butonactualizar());
        binsert.addActionListener(new botoninsert());
        bupdate.addActionListener(new botonupdate());

        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);

        add(panel);

    }

    //boton borrar
    class Butonborrar implements ActionListener {

        public void actionPerformed(ActionEvent e) {
                String id = idtext.getText();
                int id2 = Integer.parseInt(id);
                PeliculaDAO peliculaDAO = new PeliculaDAO();
                Pelicula borar = new Pelicula(id2);
                peliculaDAO.borrar(borar);
                limpiaTabla();
                actualizarlista();
                idtext.setText("");
        }

    }

    class botoninsert implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            String nombre = nametext.getText();
            String anyo = yeartext.getText();
            int anyo2 = Integer.parseInt(anyo);
            String tipo = tipotext.getText();
            PeliculaDAO peliculaDAO = new PeliculaDAO();
            Pelicula insertarpeli = new Pelicula(nombre, anyo2, tipo);
            peliculaDAO.insertar(insertarpeli);
            limpiaTabla();
            actualizarlista();
            nametext.setText("");
            yeartext.setText("");
            tipotext.setText("");
        }
    }

    class botonupdate implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //id
            String id = idtext.getText();
            int id2 = Integer.parseInt(id);
            //nombre
            String nombre = nametext.getText();
            String anyo = yeartext.getText();
            //anyo
            int anyo2 = Integer.parseInt(anyo);
            //tipo
            String tipo = tipotext.getText();
            PeliculaDAO peliculaDAO = new PeliculaDAO();
            Pelicula actualizarpeli = new Pelicula(id2, nombre, anyo2, tipo);
            peliculaDAO.actualizar(actualizarpeli);
            limpiaTabla();
            actualizarlista();
            idtext.setText("");
            nametext.setText("");
            yeartext.setText("");
            tipotext.setText("");
        }
    }

    class Butonactualizar implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //añado el model a ala tabla
            actualizarlista();
        }
    }

    public void actualizarlista() {
        limpiaTabla();
        try {
            Connection conn = Conexion.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from pelicula");
            int numerofila = 0;
            while (rs.next()) {
                // se crea y rellena la fila para el modelo de la tabla
                Object[] rowData = new Object[model.getColumnCount()];
                rowData[0] = rs.getObject(1);
                rowData[1] = rs.getObject(2);
                rowData[2] = rs.getObject(3);
                rowData[3] = rs.getObject(4);
                model.addRow(rowData);
                numerofila++;
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.getMessage();
        }

    }

    public void limpiaTabla() {
        model.setRowCount(0);
    }

}
