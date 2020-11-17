/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controller.ControllerPelicula;
import Modelo.Pelicula;
import com.connection.Conexion;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author antcha
 */
class frameproyecto1 extends JFrame {

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
    JButton bselect = new JButton("Select");
    JLabel Id = new JLabel("ID");
    JLabel Name = new JLabel("NAME");
    JLabel Year = new JLabel("YEAR");
    JLabel Tipe = new JLabel("TIPE");

    JTextField idtext = new JTextField();
    JTextField nametext = new JTextField();
    JTextField yeartext = new JTextField();
    JTextField tipotext = new JTextField();

    public frameproyecto1() {

        setTitle(" proyecto1");
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
    //    binsert.addActionListener(new botoninsert());
        panel3.add(bupdate);
        panel3.add(bborrar);
          bborrar.addActionListener(new Butonborrar());
        panel3.add(binsert);

        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);

        add(panel);

        //        System.out.println("datos de la pelicula " + pelicula);
//    }
//    public void verPeliculas(List<Pelicula> peliculas){
//        for (Pelicula pelicula : peliculas) {
//			System.out.println("Datos del peliculas: "+pelicula);
//		}
    }

    class Butonborrar implements ActionListener {

        public void actionPerformed(ActionEvent e) {
          ControllerPelicula controller = new ControllerPelicula();
            String id = idtext.getText();
            int id2 = Integer.parseInt(id);
            Pelicula borar = new Pelicula(id2);
            controller.eliminar(borar);
        }
    }

}
