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
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
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
    JLabel Tipe = new JLabel("TYPE");

    JTextField idtext = new JTextField();
    JTextField nametext = new JTextField();
    JTextField yeartext = new JTextField();
    JTextField tipotext = new JTextField();
       
    public frameproyecto1() {

        setTitle(" proyecto1");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        

        panel.setLayout(new GridLayout(3, 1));
        TitledBorder title;
        title = BorderFactory.createTitledBorder("tabla");
        panel1.setBorder(title);
         
        //tabla
        //  model = new DefaultTableModel();
       
        jTable1 = new JTable();

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
         panel3.setLayout(new GridLayout(2, 2));
        panel3.add(binsert);
        binsert.addActionListener(new botoninsertar());
        panel3.add(bupdate);
        bupdate.addActionListener(new botonupdate());
        panel3.add(bborrar);
        bborrar.addActionListener(new Butonborrar());
        panel3.add(bselect);
        bselect.addActionListener(new botonselect());
        

    
        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);

        add(panel);

    }

    class botonselect implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            ControllerPelicula controller = new ControllerPelicula();
            try {
                jTable1.setModel(controller.selectcontroller());
            } catch (SQLException ex) {
                Logger.getLogger(frameproyecto1.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    class botonupdate implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == bupdate) {

                int confirmar = JOptionPane.showConfirmDialog(null, "Do you confirm this?");
                if (JOptionPane.OK_OPTION == confirmar) {
                    ControllerPelicula controller = new ControllerPelicula();
                    String id = idtext.getText();
                    int id2 = Integer.parseInt(id);
                    String nombre = nametext.getText();
                    String anyo = yeartext.getText();
                    int anyo2 = Integer.parseInt(anyo);
                    String tipo = tipotext.getText();
                    Pelicula insertarpeli = new Pelicula(id2, nombre, anyo2, tipo);
                    controller.actualizarcontroller(insertarpeli);
                    idtext.setText("");
                    nametext.setText("");
                    yeartext.setText("");
                    tipotext.setText("");
                   
                } else {
                    JOptionPane.showMessageDialog(null, "you have selected no");
                }
            }

        }
    }

    class Butonborrar implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //confirmacion
            if (e.getSource() == bborrar) {

                int confirmar = JOptionPane.showConfirmDialog(null, "Do you confirm this?");
                if (JOptionPane.OK_OPTION == confirmar) {
                    ControllerPelicula controller = new ControllerPelicula();
                    String id = idtext.getText();
                    int id2 = Integer.parseInt(id);
                    Pelicula borrar = new Pelicula(id2);
                    controller.eliminarcontroller(borrar);

                    idtext.setText("");
                    
                    actulizarlista();
                } else {
                    JOptionPane.showMessageDialog(null, "you have selected no");
                }
            }

        }
    }
    
    

    class botoninsertar implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //confirmacion
            if (e.getSource() == binsert) {

                int confirmar = JOptionPane.showConfirmDialog(null, "Do you confirm this?");
                if (JOptionPane.OK_OPTION == confirmar) {
                    ControllerPelicula controller = new ControllerPelicula();
                    String nombre = nametext.getText();
                    String anyo = yeartext.getText();
                    int anyo2 = Integer.parseInt(anyo);
                    String tipo = tipotext.getText();

                    Pelicula insertarpeli = new Pelicula(nombre, anyo2, tipo);
                    controller.registrarcontroller(insertarpeli);
                    idtext.setText("");
                    nametext.setText("");
                    yeartext.setText("");
                    tipotext.setText("");
                    actulizarlista();
                     limpiaTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "you have selected no");
                }
            }

        }
    }

    public void limpiaTabla() {
        model.setRowCount(0);
    }
    public void actulizarlista() {
        ControllerPelicula controller = new ControllerPelicula();
            try {
                jTable1.setModel(controller.selectcontroller());
            } catch (SQLException ex) {
                Logger.getLogger(frameproyecto1.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

}
